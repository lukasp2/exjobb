import devstudio.generatedcode.HlaInteractionManager;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class MultihopSimulator implements Runnable {

    public MultihopSimulator(String name, Network nw, DynamicQueue dynamicQueue, ReentrantLock printLock) {
        // stores network and dynamic queue as references.
        this.nw = nw;
        this.dynamicQueue = dynamicQueue;
        this.name = name;
        this.printLock = printLock;

        Thread t = new Thread(this);
        t.start();
    }

    public Network nw;
    public DynamicQueue dynamicQueue;

    public ReentrantLock printLock;

    private int prevRequestType = -1;

    private final String name;

    private Graph graph = new Graph();

    // serves the queue
    public void run() {
        // for logging statistical data
        // Logger logs = new Logger(nw.getNumNodes(), radio.DISTANCE, dynamicQueue.BLOCK_SIZE, 1);

        // begin satisfy requests
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

            // translate array list integers to byte[] using map in Main and Uuid.Adapter

            HlaInteractionManager.HlaResponseInteraction.setPath();
            HlaInteractionManager.HlaResponseInteraction.setTransactionID();
            HlaInteractionManager.HlaResponseInteraction.sendUpdate();
        }

        // logs.print();

        // logs.printBFS2();
        // logs.printAstar2();
        // logs.printBuild();
    }
}
