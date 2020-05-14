import devstudio.generatedcode.*;
import devstudio.generatedcode.exceptions.*;
import devstudio.generatedcode.datatypes.*;
import se.pitch.rpr2.util.convert.GeodeticLocation;
import se.pitch.rpr2.util.datatypes.WorldLocation;

import java.util.*;
import java.io.File;  // file class
import java.io.FileNotFoundException;  // handle errors

public class ConnectionSimulator {
    private final HlaWorld _hlaWorld;
    
    public Map<Integer, UUID> uuidMap = new HashMap<Integer, UUID>();

    public Map<UUID, Boolean> visitedIDs = new HashMap<UUID, Boolean>();

    public ConnectionSimulator() {
        _hlaWorld = HlaWorld.Factory.create(new HlaSettings() {
        });
    }

    // called when file DATAFILE is read and a new ID is found.
    public void createObject(Scanner scanner, byte[] id) throws HlaNotConnectedException, HlaRtiException, HlaInternalException, HlaAttributeNotOwnedException {
        visitedIDs.put(UuidAdapter.getUUIDFromBytes(id), true);

        double latitude = getDoubleFromFile(scanner);
        double longitude = getDoubleFromFile(scanner);

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

    public byte[] getBytesFromMap(Scanner scanner) throws HlaAttributeNotOwnedException, HlaRtiException, HlaNotConnectedException, HlaInternalException {
        int ID = scanner.nextInt();
        if (!uuidMap.containsKey(ID)) {
            uuidMap.put(ID, UuidAdapter.getUUIDFromInt(ID));

        }
        System.out.print(ID + "\t\t");
        
        return UuidAdapter.getBytesFromUUID(uuidMap.get(ID));
    }

    public double getDoubleFromFile(Scanner scanner) {
        double value = 0;
        if (scanner.hasNextDouble()) {
            value = scanner.nextDouble();
            System.out.print(value + " \t\t");
        }
        else {
            System.out.println("Error, could not retrieve Double. Found: " + scanner.next());
        }

        return value;
    }

    public void simulate() throws HlaBaseException, InterruptedException {
        HlaLogicalTime currentTime = _hlaWorld.connect();

        HlaCommunicationNetworkStatus comStatus = _hlaWorld.getHlaCommunicationNetworkStatusManager().createLocalHlaCommunicationNetworkStatus();

        HlaCommunicationNetworkStatusUpdater initialUpdater = comStatus.getHlaCommunicationNetworkStatusUpdater();

        ArrayList<NetworkConnectivityStruct> networkConnectivityStructs = new ArrayList<NetworkConnectivityStruct>();

        try {
            File myObj = new File("DATAFILE.txt");
            Scanner scanner = new Scanner(myObj);
            scanner.useLocale(Locale.US);

            System.out.println("from \tto \t\tquality \tlat \t\t\t\tlong");
            while (scanner.hasNext()) {
                byte[] fromUuidArr = getBytesFromMap(scanner);
                byte[] toUuidArr = getBytesFromMap(scanner);
                double signalQuality = getDoubleFromFile(scanner);

                // if new uuid: create new object, else trash the position values
                if (!visitedIDs.containsKey(UuidAdapter.getUUIDFromBytes(fromUuidArr))) {
                    createObject(scanner, fromUuidArr);
                }
                else {
                    getDoubleFromFile(scanner);
                    getDoubleFromFile(scanner);
                }

                networkConnectivityStructs.add(NetworkConnectivityStruct.create(toUuidArr, fromUuidArr, (float)signalQuality));

                System.out.println();
            }
            scanner.close();

        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        initialUpdater.setCommunicationConnectivity(networkConnectivityStructs.toArray(new NetworkConnectivityStruct[0]));

        initialUpdater.sendUpdate();

        Thread.sleep(1000000);

        _hlaWorld.disconnect();
    }

    public static void main(String[] args) throws HlaBaseException, InterruptedException {
        new ConnectionSimulator().simulate();
    }
}
