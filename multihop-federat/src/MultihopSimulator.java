import devstudio.generatedcode.*;
import devstudio.generatedcode.exceptions.*;
import devstudio.generatedcode.impl.utils.MinMax;
import internal.prti1516e.com.google.common.collect.BiMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

public class MultihopSimulator implements Runnable {

    public MultihopSimulator(HlaWorld _hlaWorld, String name, Network nw, DynamicQueue dynamicQueue, BiMap<UUID, Integer> nodeIDs, ReentrantLock printLock) {
        HlaInteractionManager.HlaResponseInteraction _hlaRI = _hlaWorld.getHlaInteractionManager().getHlaResponseInteraction();
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

            printLock.lock();
            System.out.print(name + " picked up "); request.print();
            //System.out.println();
            printLock.unlock();

            // Building graph
            if (request.getRequestType() != prevRequestType) // also rebuild immediately if the network changes?
            {
                //logs.startTime();
                graph = new Graph(nw, request.getRequestType()); // graph.print();
                //logs.graphstats.add(System.nanoTime() - logs.startTime);
                //logs.graphRebuilds++;

                prevRequestType = request.getRequestType();
            }

            //logs.branchFactors.add(graph.branchingFactor);

            // performs A* search in the graph
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

        // logs.printBFS2();
        // logs.printAstar2();
        // logs.printBuild();
    }

    public void sendResponse(ArrayList<Integer> path, Request request) throws HlaInternalException, HlaRtiException, HlaNotConnectedException, HlaFomException {

        ArrayList<byte[]> a = new ArrayList<>();
        for (int i : path) {
            a.add(UuidAdapter.getBytesFromUUID(nodeIDs.inverse().get(i)));
        }


        byte[][] b = new byte[a.size()][16];
        b = a.toArray(b);

        printLock.lock();
        System.out.println("name: " + name);
        for (byte[] k : b) {
            System.out.println(Arrays.toString(k));
        }

        if (b == null) {
            System.out.println("b is null");
        }

        _hlaRI.setPath(b);
        _hlaRI.setTransactionID(request.getTransactionID());
        _hlaRI.sendInteraction();
        printLock.unlock();
    }
}
