import devstudio.generatedcode.*;
import devstudio.generatedcode.exceptions.*;
import devstudio.generatedcode.datatypes.*;
import internal.prti1516e.com.google.common.collect.BiMap;
import internal.prti1516e.com.google.common.collect.HashBiMap;
import se.pitch.rpr2.util.convert.GeodeticLocation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    private final boolean BRUTE_FORCE = true;
    private final boolean REQUEST_RESPONSE = true;

    private final boolean PRINT_NODES_ADDED = false;
    private final boolean PRINT_CONN_INFO = false;

    private final HlaWorld _hlaWorld;

    public Network nw = new Network();

    public RequestQueueList requestQueueList = new RequestQueueList();

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
                    System.out.println("Node " + nodeIDs.get(uuid) + " ADDED (uuid: " + uuid + ") position set to lat: " + latitude + ", long: " + longitude);
                }
            }
            else if (PRINT_NODES_ADDED) {
                System.out.println("Node " + nodeIDs.get(uuid) + " UPDATED (uuid: " + uuid + ") position set to lat: " + latitude + ", long: " + longitude);
            }

            nw.addNode(nodeIDs.get(uuid), latitude, longitude);
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
                    nw.addConnection(nodeIDs.get(fromUuid), nodeIDs.get(toUuid), ncs.networkState);
                }
                else if (PRINT_CONN_INFO) {
                    System.out.println("Connection between uuid " + fromUuid + " and " + toUuid + " could not be added: nodes does not exists.");
                }
            }

            if (PRINT_CONN_INFO) {
                System.out.println("network has been fully (re)built");
            }

            if (BRUTE_FORCE) {
                new QueueFillerThread(nw, requestQueueList);
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

    public void simulate() throws HlaBaseException {
        _hlaWorld.connect();

        // a replacement for the network-federate:
        //FileReader fw = new FileReader(nw, requestQueueList, nodeIDs);
        //fw.readFile();

        long startTime = System.nanoTime();

        int numThreads = 8;
        for (int i = 1; i < numThreads; ++i) {
            Thread t1 = new Thread(new MultihopSimulator(_hlaWorld, i,
                    nw, requestQueueList, nodeIDs));
            t1.start();
        }

        MultihopSimulator t2 = new MultihopSimulator(_hlaWorld,numThreads,
                nw, requestQueueList, nodeIDs);
        t2.run();

        System.out.print( "execution time: " + (System.nanoTime() - startTime) / 1000000 + " ms");

        _hlaWorld.disconnect();
    }

    public static void main(String[] args) throws HlaBaseException {
        new Main().simulate();
    }
}