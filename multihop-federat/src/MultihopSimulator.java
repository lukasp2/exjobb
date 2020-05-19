import devstudio.generatedcode.*;
import devstudio.generatedcode.exceptions.*;
import internal.prti1516e.com.google.common.collect.BiMap;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

public class MultihopSimulator implements Runnable {

    public MultihopSimulator(HlaWorld _hlaWorld, String name, Network nw,
                             RequestQueueList requestQueueList,
                             BiMap<UUID, Integer> nodeIDs,
                             Logger logger,
                             ReentrantLock lock) {
        this._hlaRI = _hlaWorld.getHlaInteractionManager().getHlaResponseInteraction();
        this.name = name;
        this.nw = nw;
        this.requestQueueList = requestQueueList;
        this.nodeIDs = nodeIDs;
        this.logger = logger;
        this.lock = lock;
    }

    HlaInteractionManager.HlaResponseInteraction _hlaRI;

    public Network nw;

    public RequestQueueList requestQueueList;

    public ReentrantLock lock;

    public BiMap<UUID, Integer> nodeIDs;

    public Logger logger;

    private int prevRequestType = -1;

    private final String name;

    private Graph graph = new Graph();

    private RequestQueue requests = new RequestQueue();

    public void run() {

        while (true) {
            if (requests.isEmpty()) {
                try {

                    if (requestQueueList.queuesAreEmpty() && !requestQueueList.firstRequest) {
                        logger.setElapsedTime();
                        break;
                    }

                    requests = requestQueueList.poll();

                    if ( requests.getRequestType() != prevRequestType ) {
                        rebuildGraph();
                    }
                }
                catch (InterruptedException e) { e.printStackTrace(); }
            }

            Request request = requests.poll();

            logger.addBFactor(graph.branchingFactor);
            logger.startTime();
            ArrayList<Integer> res = graph.aStar(request);
            logger.stopTime(logger.Astarstats);

            try {
                sendResponse(res, request);
            } catch (HlaInternalException | HlaRtiException | HlaNotConnectedException | HlaFomException e) {
                e.printStackTrace();
            }
        }

        //logger.print();
        //logger.printGraph();
        //logger.printAstar();

        int sum = 0;
        for (long d : logger.Astarstats) {
            sum += d;
        }
        System.out.println("runtime: " + sum/1000000 + " ms");
    }

    public void rebuildGraph() {
        logger.startTime();
        graph = new Graph(nw, requests.getRequestType()); // graph.print();
        logger.stopTime(logger.graphstats);
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
