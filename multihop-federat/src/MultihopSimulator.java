import devstudio.generatedcode.*;
import devstudio.generatedcode.exceptions.*;
import internal.prti1516e.com.google.common.collect.BiMap;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

public class MultihopSimulator implements Runnable {

    public MultihopSimulator(HlaWorld _hlaWorld, String name, Network nw, DynamicQueue dynamicQueue, BiMap<UUID, Integer> nodeIDs, ReentrantLock printLock) {
        this._hlaRI = _hlaWorld.getHlaInteractionManager().getHlaResponseInteraction();
        this.name = name;
        this.nw = nw;
        this.dynamicQueue = dynamicQueue;
        this.nodeIDs = nodeIDs;
        this.printLock = printLock;

        Thread t = new Thread(this);
        t.start();
    }

    HlaInteractionManager.HlaResponseInteraction _hlaRI;

    public Network nw;

    public DynamicQueue dynamicQueue;

    public ReentrantLock printLock;

    public BiMap<UUID, Integer> nodeIDs;

    private int prevRequestType = -1;

    private final String name;

    private Graph graph = new Graph();

    public void run() {
        // for logging statistical data
        // Logger logs = new Logger(nw.getNumNodes(), radio.DISTANCE, dynamicQueue.BLOCK_SIZE, 1);

        while (true) {
            Request request = dynamicQueue.poll(); // request.print();

            if (request.getRequestType() != prevRequestType) // also rebuild immediately if the network changes?
            {
                //logs.startTime();
                graph = new Graph(nw, request.getRequestType()); // graph.print();
                //logs.graphstats.add(System.nanoTime() - logs.startTime);
                //logs.graphRebuilds++;

                prevRequestType = request.getRequestType();
            }

            //logs.branchFactors.add(graph.branchingFactor);

            // logs.startTime();
            ArrayList<Integer> res = graph.aStar(request);
            // logs.Astarstats.add(System.nanoTime() - logs.startTime);

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
        printLock.lock();
        System.out.print(name + " with request " + request.toString() + " is publishing path ");
        for (int nodeID : intArray) {
            System.out.print(nodeID + " ");
            byteArray.add(UuidAdapter.getBytesFromUUID(nodeIDs.inverse().get(nodeID)));
        }
        System.out.println();
        printLock.unlock();

        _hlaRI.setPath(byteArray.toArray(new byte[byteArray.size()][16]));
        _hlaRI.setTransactionID(request.getTransactionID());
        _hlaRI.sendInteraction();
    }
}
