import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class MultihopSimulator implements Runnable {

    public MultihopSimulator(String name, Network nw, DynamicQueue dynamicQueue, ReentrantLock requestLock) {
        // stores network and dynamic queue as references.
        this.nw = nw;
        this.dynamicQueue = dynamicQueue;
        this.requestLock = requestLock;
        this.name = name;

        Thread t = new Thread(this);
        t.start();
    }

    public ReentrantLock requestLock;
    public Network nw;
    public DynamicQueue dynamicQueue;

    private String name;
    private final Radio radio = new Radio();
    private Graph graph = new Graph();

    // serves the queue
    public void run() {
        // for logging statistical data
        // Logger logs = new Logger(nw.getNumNodes(), radio.DISTANCE, dynamicQueue.BLOCK_SIZE, 1);

        // begin satisfy requests
        while (true) {
            requestLock.lock();
            Request request = dynamicQueue.poll(); // request.print();

            System.out.print(name + " serving "); request.print();

            // Building graph
            if (dynamicQueue.changedRequestType()) // also rebuild immediately if the network changes?
            {
                requestLock.unlock();

                radio.setCom(request.getComType());

                //logs.startTime();
                graph = new Graph(nw, radio); // graph.print();
                //logs.graphstats.add(System.nanoTime() - logs.startTime);
                //logs.graphRebuilds++;
            }
            else { requestLock.unlock(); }

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
