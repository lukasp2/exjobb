import devstudio.generatedcode.*;
import devstudio.generatedcode.exceptions.*;
import devstudio.generatedcode.datatypes.*;
import internal.prti1516e.com.google.common.collect.BiMap;
import internal.prti1516e.com.google.common.collect.HashBiMap;
import se.pitch.rpr2.util.convert.GeodeticLocation;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private final static int NUM_THREADS = Runtime.getRuntime().availableProcessors();

    private final boolean BRUTE_FORCE = false;
    private final boolean REQUEST_RESPONSE = true;

    private final boolean PRINT_NODES_ADDED = false;
    private final boolean PRINT_CONN_INFO = false;

    private final HlaWorld _hlaWorld;

    public Network network = new Network();

    public RequestQueueList requestQueueList = new RequestQueueList();

    public static Semaphore sema = new Semaphore(-1 * NUM_THREADS + 1);

    public BiMap<UUID, Integer> nodeIDs = HashBiMap.create();
    private int nextNodeID = 0;

    public Main() {
        _hlaWorld = HlaWorld.Factory.create(new HlaSettings() {});
        _hlaWorld.getHlaNETNGroundVehicleManager().addHlaNETNGroundVehicleDefaultInstanceValueListener(_gvListener);
        _hlaWorld.getHlaCommunicationNetworkStatusManager().addHlaCommunicationNetworkStatusDefaultInstanceListener(_cnListener);
        _hlaWorld.getHlaInteractionManager().addHlaInteractionListener(_rrListener);
    }

    private final HlaNETNGroundVehicleValueListener _gvListener = new HlaNETNGroundVehicleValueListener.Adapter() {
        @Override
        public void spatialUpdated(HlaNETNGroundVehicle nETNGroundVehicle, SpatialVariantStruct spatial, boolean validOldSpatial, SpatialVariantStruct oldSpatial, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime)
        {
            byte[] id = nETNGroundVehicle.getHlaNETNGroundVehicleAttributes().getUniqueID();
            UUID uuid = UuidAdapter.getUUIDFromBytes(id);

            GeodeticLocation loc1 = GeodeticLocation.createGeodeticLocationFromXYZ(spatial.spatialFPW.worldLocation.x, spatial.spatialFPW.worldLocation.y, spatial.spatialFPW.worldLocation.z);
            double latitude = loc1.getLatitude();
            double longitude = loc1.getLongitude();

            if (!nodeIDs.containsKey(uuid)) {
                nodeIDs.put(uuid, nextNodeID++);
                if (PRINT_NODES_ADDED) {
                    System.out.println("ADDED node " + nodeIDs.get(uuid) + " (uuid: " + uuid + ") position set to lat: " + latitude + ", long: " + longitude);
                }
            }
            else if (PRINT_NODES_ADDED) {
                System.out.println("UPDATED node " + nodeIDs.get(uuid) + " (uuid: " + uuid + ") position set to lat: " + latitude + ", long: " + longitude);
            }

            network.addNode(nodeIDs.get(uuid), loc1.getLatitude(), loc1.getLongitude());
        }
    };

    private final HlaCommunicationNetworkStatusListener _cnListener = new HlaCommunicationNetworkStatusListener.Adapter() {
        @Override
        public void attributesUpdated(HlaCommunicationNetworkStatus communicationNetworkStatus, Set<HlaCommunicationNetworkStatusAttributes.Attribute> attributes, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
            HlaCommunicationNetworkStatusAttributes attr = communicationNetworkStatus.getHlaCommunicationNetworkStatusAttributes();

            NetworkConnectivityStruct[] ncsArr = attr.getCommunicationConnectivity();

            for (NetworkConnectivityStruct ncs : ncsArr) {
                UUID fromUuid = UuidAdapter.getUUIDFromBytes(ncs.sender);
                UUID toUuid = UuidAdapter.getUUIDFromBytes(ncs.receiver);

                if (nodeIDs.containsKey(fromUuid) && nodeIDs.containsKey(toUuid)) {
                    network.addConnection(nodeIDs.get(fromUuid), nodeIDs.get(toUuid), ncs.networkState);
                }
                else if (PRINT_CONN_INFO) {
                    System.out.println("Connection between uuid " + fromUuid + " and " + toUuid + " could not be added: nodes does not exists.");
                }
            }

            if (PRINT_CONN_INFO) {
                System.out.println("network has been (re)built");
            }

            if (BRUTE_FORCE) {
                new QueueFillerThread(network, requestQueueList);
            }
        }
    };

    private final HlaInteractionListener _rrListener = new HlaInteractionListener() {
        @Override
        public void request(boolean local, HlaInteractionManager.HlaRequestParameters parameters, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
            UUID fromUuid = UuidAdapter.getUUIDFromBytes(parameters.getFromNode());
            UUID toUuid = UuidAdapter.getUUIDFromBytes(parameters.getToNode());
            int comType = parameters.getComType();
            long transactionID = parameters.getTransactionID();

            if (REQUEST_RESPONSE && nodeIDs.containsKey(fromUuid) && nodeIDs.containsKey(toUuid)) {
                Request r = new Request(nodeIDs.get(fromUuid), nodeIDs.get(toUuid), comType, transactionID);
                requestQueueList.add(r);
            }
            else {
                System.out.println("A request for a path between unknown node(s) was received. Ignoring request.");
            }
        }

        @Override
        public void response(boolean local, HlaInteractionManager.HlaResponseParameters parameters, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime) {
        }
    };

    public void simulate() throws HlaBaseException, InterruptedException {
        _hlaWorld.connect();

        // a replacement for the network-federate:
        //FileReader fw = new FileReader(network, requestQueueList, nodeIDs);
        //fw.readFile();

        ReentrantLock lock = new ReentrantLock();

        long startTime = System.nanoTime();

        for (int i = 1; i < NUM_THREADS; ++i) {
            Thread t1 = new Thread(new MultihopSimulator(_hlaWorld, i,
                    network, requestQueueList, nodeIDs, lock));
            t1.start();
        }

        MultihopSimulator t2 = new MultihopSimulator(_hlaWorld, NUM_THREADS,
                network, requestQueueList, nodeIDs, lock);
        t2.run();

        // wait for all threads to finish
        sema.acquire();

        System.out.print((System.nanoTime() - startTime) / 1000000 + ", ");

        _hlaWorld.disconnect();
    }

    public static void main(String[] args) throws HlaBaseException, InterruptedException {
        new Main().simulate();
    }
}