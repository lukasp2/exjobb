import devstudio.generatedcode.*;
import devstudio.generatedcode.exceptions.*;
import devstudio.generatedcode.datatypes.*;
import se.pitch.rpr2.util.convert.GeodeticLocation;
import se.pitch.rpr2.util.datatypes.WorldLocation;

import java.util.*;
import java.io.File;  // file class
import java.io.FileNotFoundException;  // handle errors

public class ConnectionSimulator {
    private final boolean VERBOSE = true;

    private final HlaWorld _hlaWorld;

    public Map<UUID, Boolean> visitedIDs = new HashMap<UUID, Boolean>();

    public ConnectionSimulator() {
        _hlaWorld = HlaWorld.Factory.create(new HlaSettings() {
        });
    }

    // called when file DATAFILE is read and a new ID is found.
    public void createObject(Scanner scanner, byte[] id, double latitude, double longitude) throws HlaNotConnectedException, HlaRtiException, HlaInternalException, HlaAttributeNotOwnedException {
        visitedIDs.put(UuidAdapter.getUUIDFromBytes(id), true);

        GeodeticLocation loc1 = GeodeticLocation.createGeodeticLocation(latitude, longitude, 1000.0);
        WorldLocation xyz = GeodeticLocation.createWorldLocation(loc1);
        double x = xyz.getX();
        double y = xyz.getY();
        double z = xyz.getZ();

        HlaNETNGroundVehicle groundVehicle = _hlaWorld.getHlaNETNGroundVehicleManager().createLocalHlaNETNGroundVehicle();
        HlaNETNGroundVehicleUpdater gvUpdater = groundVehicle.getHlaNETNGroundVehicleUpdater();

        WorldLocationStruct gvLocation = WorldLocationStruct.create(x, y, z);
        OrientationStruct gvOrientation = OrientationStruct.create(0,0,0);
        VelocityVectorStruct gvVelocity = VelocityVectorStruct.create(0,0,0);
        SpatialFPStruct gvSpatial = SpatialFPStruct.create(gvLocation, false, gvOrientation, gvVelocity);

        // set spatial and uuid
        gvUpdater.setSpatial(SpatialVariantStruct.createSpatialFPW(gvSpatial));
        gvUpdater.setUniqueID(id);

        gvUpdater.sendUpdate();
    }

    public void simulate() throws HlaBaseException, InterruptedException {
        HlaLogicalTime currentTime = _hlaWorld.connect();

        HlaCommunicationNetworkStatus comStatus = _hlaWorld.getHlaCommunicationNetworkStatusManager().createLocalHlaCommunicationNetworkStatus();

        HlaCommunicationNetworkStatusUpdater initialUpdater = comStatus.getHlaCommunicationNetworkStatusUpdater();

        ArrayList<NetworkConnectivityStruct> networkConnectivityStructs = new ArrayList<NetworkConnectivityStruct>();

        try {
            File myObj = new File("input/Nodes_200_uuid.txt");
            Scanner scanner = new Scanner(myObj);
            scanner.useLocale(Locale.US);

            if (VERBOSE) {
                System.out.println("from \tto \t\tquality \tlat \t\t\t\tlong");
            }

            while (scanner.hasNext()) {
                byte[] fromUuidArr = UuidAdapter.getBytesFromUUID(scanner.next());
                byte[] toUuidArr = UuidAdapter.getBytesFromUUID(scanner.next());
                double signalQuality = scanner.nextDouble();
                double pos_x = scanner.nextDouble();
                double pos_y = scanner.nextDouble();

                if (VERBOSE) {
                    System.out.print(UuidAdapter.getUUIDFromBytes(fromUuidArr).toString() + "\t\t" + UuidAdapter.getUUIDFromBytes(toUuidArr).toString() + "\t\t" + signalQuality + "\t\t" + pos_x + "\t\t" + pos_y);
                }

                // if new uuid: create new object
                if (!visitedIDs.containsKey(UuidAdapter.getUUIDFromBytes(fromUuidArr))) {
                    if (pos_x != 0.0)
                    {
                        createObject(scanner, fromUuidArr, pos_x, pos_y);
                    }
                }

                networkConnectivityStructs.add(NetworkConnectivityStruct.create(toUuidArr, fromUuidArr, (float)signalQuality));
                if (VERBOSE) {
                    System.out.println();
                }
            }
            scanner.close();

        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        initialUpdater.setCommunicationConnectivity(networkConnectivityStructs.toArray(new NetworkConnectivityStruct[0]));

        initialUpdater.sendUpdate();

        //System.out.println("all connections sent.");

        // prevent disconnecting from federation prematurely
        Thread.sleep(1000);

        _hlaWorld.disconnect();
    }

    public static void main(String[] args) throws HlaBaseException, InterruptedException {
        new ConnectionSimulator().simulate();
    }
}
