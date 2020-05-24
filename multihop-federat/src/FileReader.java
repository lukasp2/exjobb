import devstudio.generatedcode.HlaSettings;
import devstudio.generatedcode.HlaWorld;
import internal.prti1516e.com.google.common.collect.BiMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileReader {

    public FileReader(Network network, BiMap<UUID, Integer> nodeIDs) {
        this.network = network;
        this.nodeIDs = nodeIDs;
        HlaWorld.Factory.create(new HlaSettings() {});
    }

    public Map<UUID, Boolean> visitedIDs = new HashMap<UUID, Boolean>();

    public Network network;

    public BiMap<UUID, Integer> nodeIDs;

    private int nextNodeID = 0;

    public void readFile() {
        try {
            File myObj = new File("../network-federat/input/Nodes_200_uuid.txt");
            Scanner scanner = new Scanner(myObj);
            scanner.useLocale(Locale.US);

            while (scanner.hasNext()) {
                byte[] fromUuidArr = UuidAdapter.getBytesFromUUID(scanner.next());
                byte[] toUuidArr = UuidAdapter.getBytesFromUUID(scanner.next());
                double signalQuality = scanner.nextDouble();
                double pos_x = scanner.nextDouble();
                double pos_y = scanner.nextDouble();

                UUID fromUuid = UuidAdapter.getUUIDFromBytes(fromUuidArr);
                UUID toUuid = UuidAdapter.getUUIDFromBytes(toUuidArr);

                if (!nodeIDs.containsKey(fromUuid)) {
                    nodeIDs.put(fromUuid, nextNodeID++);
                }

                if (!nodeIDs.containsKey(toUuid)) {
                    nodeIDs.put(toUuid, nextNodeID++);
                }

                network.addConnection(nodeIDs.get(fromUuid), nodeIDs.get(toUuid), signalQuality);

                if (!visitedIDs.containsKey(fromUuid)) {
                    visitedIDs.put(fromUuid, true);
                    network.addNode(nodeIDs.get(fromUuid), pos_x, pos_y);
                }

            }
            scanner.close();

        } catch (
            FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
