import java.util.concurrent.locks.ReentrantLock;

public class MultihopSimulator implements Runnable {

    public MultihopSimulator(String name, Network nw, DynamicQueue dynamicQueue) {
        // stores network and dynamic queue as references.
        this.nw = nw;
        this.dynamicQueue = dynamicQueue;
        this.name = name;

        Thread t = new Thread(this);
        t.start();
    }

    public Network nw;
    public DynamicQueue dynamicQueue;

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

            System.out.print(name + " serving "); request.print();

            // Building graph
            if (request.getRequestType() != prevRequestType) // also rebuild immediately if the network changes?
            {
                prevRequestType = request.getRequestType();

                //logs.startTime();
                graph = new Graph(nw, request.getRequestType()); // graph.print();
                //logs.graphstats.add(System.nanoTime() - logs.startTime);
                //logs.graphRebuilds++;
            }

            //logs.branchFactors.add(graph.branchingFactor);

            // performs A* search in the graph
            // logs.startTime();

            graph.aStar(request);
            // logs.Astarstats.add(System.nanoTime() - logs.startTime);
        }

        // logs.print();

        // logs.printBFS2();
        // logs.printAstar2();
        // logs.printBuild();

        // _hlaWorld.disconnect();
    }
}
