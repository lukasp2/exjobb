import devstudio.generatedcode.*;
import devstudio.generatedcode.exceptions.*;
import internal.prti1516e.com.google.common.collect.BiMap;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

public class MultihopSimulator implements Runnable {

    public MultihopSimulator(HlaWorld _hlaWorld, String name, Network nw, RequestQueueList requestQueueList, BiMap<UUID, Integer> nodeIDs, ReentrantLock printLock) {
        this._hlaRI = _hlaWorld.getHlaInteractionManager().getHlaResponseInteraction();
        this.name = name;
        this.nw = nw;
        this.requestQueueList = requestQueueList;
        this.nodeIDs = nodeIDs;
        this.printLock = printLock;

        Thread t = new Thread(this);
        t.start();
    }

    HlaInteractionManager.HlaResponseInteraction _hlaRI;

    public Network nw;

    public RequestQueueList requestQueueList;

    public ReentrantLock printLock;

    public BiMap<UUID, Integer> nodeIDs;

    private int prevRequestType = -1;

    private final String name;

    private Graph graph = new Graph();

    RequestQueue requests = new RequestQueue();

    public void run() {
        // for logging statistical data
        // Logger logs = new Logger(nw.getNumNodes(), radio.DISTANCE, dynamicQueue.BLOCK_SIZE, 1);

        while (true) {
            if (requests.isEmpty()) {
                try { requests = requestQueueList.poll(); }
                catch (InterruptedException e) { e.printStackTrace(); }
            }

            printLock.lock();
            System.out.println("requests size " + requests.size());
            Request request = requests.poll();

            if (request.getRequestType() != prevRequestType) {
                printLock.unlock();
                //logs.startTime();
                graph = new Graph(nw, request.getRequestType()); // graph.print();
                //logs.graphstats.add(System.nanoTime() - logs.startTime);
                //logs.graphRebuilds++;

                prevRequestType = request.getRequestType();
            }
            else { printLock.unlock(); }

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

    public void sendResponse(ArrayList<Integer> intArray, Request request) throws HlaInternalException, HlaRtiException, HlaNotConnectedException, HlaFomException {

        ArrayList<byte[]> byteArray = new ArrayList<>();

        if (false) {
            printLock.lock();
            System.out.print(name + " with request " + request.toString() + " is publishing path ");
            for (int nodeID : intArray) {
                System.out.print(nodeID + " ");
                byteArray.add(UuidAdapter.getBytesFromUUID(nodeIDs.inverse().get(nodeID)));
            }
            System.out.println();
            printLock.unlock();
        }

        _hlaRI.setPath(byteArray.toArray(new byte[byteArray.size()][16]));
        _hlaRI.setTransactionID(request.getTransactionID());
        _hlaRI.sendInteraction();
    }
}
