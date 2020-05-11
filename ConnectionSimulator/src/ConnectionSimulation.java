import devstudio.generatedcode.*;
import devstudio.generatedcode.exceptions.HlaBaseException;
import devstudio.generatedcode.datatypes.*;

import java.util.*;
import java.io.File;  // file class
import java.io.FileNotFoundException;  // handle errors

import java.util.concurrent.TimeUnit;

/**
 * Simple Pitch Developer Studio Federate
 */
public class ConnectionSimulation {
    private final HlaWorld _hlaWorld;

    public ConnectionSimulation() {
        _hlaWorld = HlaWorld.Factory.create(new HlaSettings() {
        });
    }

    public void simulate() throws HlaBaseException, InterruptedException {
        HlaLogicalTime currentTime = _hlaWorld.connect();

        HlaCommunicationNetworkStatus comStatus = _hlaWorld.getHlaCommunicationNetworkStatusManager().createLocalHlaCommunicationNetworkStatus();

        _hlaWorld.get


        HlaCommunicationNetworkStatusUpdater initialUpdater = comStatus.getHlaCommunicationNetworkStatusUpdater();

        ArrayList<NetworkConnectivityStruct> networkConnectivityStructs = new ArrayList<NetworkConnectivityStruct>();

        try {
            File myObj = new File("DATAFILE.txt");
            Scanner myReader = new Scanner(myObj);
            myReader.useLocale(Locale.US);

            Map<Integer, UUID> uuidMap = new HashMap<Integer, UUID>();
            System.out.println("from \tto \t\tquality \tlat \t\tlong");
            while (myReader.hasNext()) {

                int fromID = myReader.nextInt();
                if (!uuidMap.containsKey(fromID)) {
                    uuidMap.put(fromID, UUID.randomUUID());
                }
                byte[] fromUuidArr = UuidAdapter.getBytesFromUUID(uuidMap.get(fromID));
                System.out.print(fromID + "\t\t");

                int toID = myReader.nextInt();//myReader.useDelimiter(" ");
                if (!uuidMap.containsKey(toID)) {
                    uuidMap.put(toID, UUID.randomUUID());
                }
                byte[] toUuidArr = UuidAdapter.getBytesFromUUID(uuidMap.get(toID));
                System.out.print(toID + "\t\t");

                /*
                String uuidStr = myReader.next();
                UUID uuid = UUID.fromString(uuidStr);
                byte[] fromUuidArr = UuidAdapter.getBytesFromUUID(uuid);

                uuidStr = myReader.next();
                uuid = UUID.fromString(uuidStr);
                byte[] toUuidArr = UuidAdapter.getBytesFromUUID(uuid);
                */
                double signalQual = 0;
                if (myReader.hasNextDouble()) {
                    signalQual = myReader.nextDouble();
                    System.out.print(signalQual + " \t\t");
                }
                else {
                    System.out.println("Error!! " + myReader.next());
                }

                if (myReader.hasNextDouble()) {
                    double latitude = myReader.nextDouble();
                    System.out.print(latitude + "\t");
                }
                else {
                    System.out.println("Error!! " + myReader.next());
                }

                if (myReader.hasNextDouble()) {
                    double longitude = myReader.nextDouble();
                    System.out.println(longitude + "\t");
                }
                else {
                    System.out.println("Error!! " + myReader.next());
                }

                networkConnectivityStructs.add(NetworkConnectivityStruct.create(toUuidArr, fromUuidArr, (float)signalQual));
            }
            myReader.close();

            while (true) {
                Thread.sleep(4000);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // place structs here:
        initialUpdater.setCommunicationConnectivity(networkConnectivityStructs.toArray(new NetworkConnectivityStruct[0]));

        initialUpdater.sendUpdate();

        _hlaWorld.disconnect();
    }

    public static void main(String[] args) throws HlaBaseException, InterruptedException {
        new ConnectionSimulation().simulate();
    }
}
