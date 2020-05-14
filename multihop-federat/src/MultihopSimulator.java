import java.util.*;

public class MultihopSimulator implements Runnable {

    public MultihopSimulator(Network nw, DynamicQueue dynamicQueue) {
        // stores network and dynamic queue as references.
        this.nw = nw;
        this.dynamicQueue = dynamicQueue;

        Thread t = new Thread(this);
        t.start();
    }

    public Network nw;
    public DynamicQueue dynamicQueue;
    private static final Radio radio = new Radio();
    private Graph graph = new Graph();

    // serves the queue
    public void run() {
        // class for logging statistical data
        // Logger logs = new Logger(nw.getNumNodes(), radio.DISTANCE, dynamicQueue.BLOCK_SIZE, 1);

        // graph = new Graph();
        // dynamicQueue.print();

        // begin satisfy requests
        while (true) {
            // lock
            Request request = dynamicQueue.poll(); // request.print();

            System.out.print("serving "); request.print();

            // Building graph
            if (dynamicQueue.changedRequestType()) // also rebuild if the NETWORK CHANGES!!!
            {
                // unlock
                radio.setCom(request.getComType());

                //logs.startTime();
                graph = new Graph(nw, radio); // graph.print();
                //logs.graphstats.add(System.nanoTime() - logs.startTime);
                //logs.graphRebuilds++;
            }
            // unlock

            //logs.branchFactors.add(graph.branchingFactor);

            // performs A* search in the graph
            // logs.startTime();
            graph.aStar(request.getToNode(), request.getFromNode(), radio.MAX_HOPS);
            // logs.Astarstats.add(System.nanoTime() - logs.startTime);
        }

        // logs.print();

        // logs.printBFS2();
        // logs.printAstar2();
        // logs.printBuild();

        // _hlaWorld.disconnect();
    }
}
