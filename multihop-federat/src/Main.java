import devstudio.generatedcode.*;
import devstudio.generatedcode.exceptions.*;
import devstudio.generatedcode.datatypes.*;
import se.pitch.rpr2.util.convert.GeodeticLocation;

import java.util.*;

public class Main {

    private Network nw = new Network();

    // tools to map each uuid to an integer for convenience
    public Map<UUID, Integer> nodeIDs = new HashMap<UUID, Integer>();
    private int nextNodeID = 0;

    private DynamicQueue dynamicQueue = new DynamicQueue();

    private final HlaWorld _hlaWorld;

    public Main() {
        _hlaWorld = HlaWorld.Factory.create(new HlaSettings() {});
        _hlaWorld.getHlaNETNGroundVehicleManager().addHlaNETNGroundVehicleDefaultInstanceValueListener(_gvListener);
        _hlaWorld.getHlaCommunicationNetworkStatusManager().addHlaCommunicationNetworkStatusDefaultInstanceListener(_cnListener);
    }

    private final HlaNETNGroundVehicleValueListener _gvListener = new HlaNETNGroundVehicleValueListener.Adapter() {
        @Override
        public void spatialUpdated(HlaNETNGroundVehicle nETNGroundVehicle, SpatialVariantStruct spatial, boolean validOldSpatial, SpatialVariantStruct oldSpatial, HlaTimeStamp timeStamp, HlaLogicalTime logicalTime)
        {
            UUID uuid = UuidAdapter.getUUIDFromBytes(nETNGroundVehicle.getHlaNETNGroundVehicleAttributes().getUniqueID());

            GeodeticLocation loc1 = GeodeticLocation.createGeodeticLocationFromXYZ(spatial.spatialFPW.worldLocation.x, spatial.spatialFPW.worldLocation.y, spatial.spatialFPW.worldLocation.z);
            double latitude = loc1.getLatitude();
            double longitude = loc1.getLongitude();

            if (!nodeIDs.containsKey(uuid)) {
                nodeIDs.put(uuid, nextNodeID++);
            }

            System.out.println("Node added with id: " + nodeIDs.get(uuid) + ", uuid: " + uuid + ", [lat: " + latitude + ", long: " + longitude + "]");

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
                else {
                    System.out.println("Connection between uuid " + fromUuid + " and " + toUuid + " could not be added: nodes does not exists.");
                }
            }

            System.out.println("network has been (re)built");

            nw.print();
        }
    };

    /*
    * Listener of requests does: dynamicQueue.addRequest(new Request(fromNode, toNode, requestType));
    * */

    public void simulate() throws HlaBaseException, InterruptedException {
        HlaLogicalTime currentTime = _hlaWorld.connect();

        MultihopSimulator multihopSimulator = new MultihopSimulator();

        // we need to spawn a separate thread to fill the brute force queue every ~5 secs here.
        multihopSimulator.fillQueue(nw, dynamicQueue);

        // then create threads to serve the queue here
        multihopSimulator.serveQueue(nw, dynamicQueue);
        // threads

        _hlaWorld.disconnect();
    }

    public static void main(String[] args) throws HlaBaseException, InterruptedException {
        new Main().simulate();
    }
}

