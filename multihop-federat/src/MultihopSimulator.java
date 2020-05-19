import devstudio.generatedcode.*;
import devstudio.generatedcode.exceptions.*;
import internal.prti1516e.com.google.common.collect.BiMap;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

public class MultihopSimulator implements Runnable {

    public MultihopSimulator(HlaWorld _hlaWorld, String name, Network nw, RequestQueueList requestQueueList, BiMap<UUID, Integer> nodeIDs, ReentrantLock lock) {
        this._hlaRI = _hlaWorld.getHlaInteractionManager().getHlaResponseInteraction();
        this.name = name;
        this.nw = nw;
        this.requestQueueList = requestQueueList;
        this.nodeIDs = nodeIDs;
        this.lock = lock;
    }

    HlaInteractionManager.HlaResponseInteraction _hlaRI;

    public Network nw;

    public RequestQueueList requestQueueList;

    public ReentrantLock lock;

    public BiMap<UUID, Integer> nodeIDs;

    private int prevRequestType = -1;

    private final String name;

    private Graph graph = new Graph();

    private RequestQueue requests = new RequestQueue();

    public void run() {
        // for logging statistical data
        // Logger logs = new Logger(nw.getNumNodes(), radio.DISTANCE, dynamicQueue.BLOCK_SIZE, 1);

        while (true) {
            if (requests.isEmpty()) {
                try {
                    requests = requestQueueList.poll();

                    if ( requests.getRequestType() != prevRequestType ) {
                        rebuildGraph();
                    }
                }
                catch (InterruptedException e) { e.printStackTrace(); }
            }

            Request request = requests.poll();

            //logs.branchFactors.add(graph.branchingFactor);

            //logs.startTime();
            ArrayList<Integer> res = graph.aStar(request);
            //logs.Astarstats.add(System.nanoTime() - logs.startTime);

            try {
                sendResponse(res, request);
            } catch (HlaInternalException | HlaRtiException | HlaNotConnectedException | HlaFomException e) {
                e.printStackTrace();
            }
        }

        // logs.print();

        // logs.printAstar2();
        // logs.printBuild();
    }

    public void rebuildGraph() {
        //logs.startTime();
        graph = new Graph(nw, requests.getRequestType()); // graph.print();
        //logs.graphstats.add(System.nanoTime() - logs.startTime);
        //logs.graphRebuilds++;

        prevRequestType = requests.getRequestType();
    }

    public void sendResponse(ArrayList<Integer> intArray, Request request) throws HlaInternalException, HlaRtiException, HlaNotConnectedException, HlaFomException {

        ArrayList<byte[]> byteArray = new ArrayList<>();

        if (false) {
            lock.lock();
            System.out.print(name + " with request " + request.toString() + " is publishing path ");
            for (int nodeID : intArray) {
                System.out.print(nodeID + " ");
                byteArray.add(UuidAdapter.getBytesFromUUID(nodeIDs.inverse().get(nodeID)));
            }
            System.out.println();
            lock.unlock();
        }

        _hlaRI.setPath(byteArray.toArray(new byte[byteArray.size()][16]));
        _hlaRI.setTransactionID(request.getTransactionID());
        _hlaRI.sendInteraction();
    }
}
