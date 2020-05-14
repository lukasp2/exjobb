import java.util.*;

public class MultihopSimulator {

    public MultihopSimulator() { }

    private static final Radio radio = new Radio();

    private Graph graph = new Graph();

    private final int filQueueTimer = 5000;

    // fill the queue with all possible requests
    public void fillQueue(Network nw, DynamicQueue dynamicQueue) {
        // TODO: only perform fill if timer is 0, then reset timer to original value.

        for ( int fromNode : nw.getConnections().keySet()) {
            for ( int toNode : nw.getConnections().get(fromNode).keySet()) {
                dynamicQueue.addRequest(new Request(fromNode, toNode, nw.getCom()));
            }
        }
    }

    public void serveQueue(Network nw, DynamicQueue dynamicQueue) {
        // class for logging statistical data
        Logger logs = new Logger(nw.getNumNodes(), radio.DISTANCE, dynamicQueue.BLOCK_SIZE, 1);

        System.out.println("Ready to start!");

        // begin satisfy requests
        while (true) {
            // lock
            Request request = dynamicQueue.poll(); // request.print();

            System.out.print("serving "); request.print();

            // dynamicQueue.print();

            // Building graph
            if (dynamicQueue.changedRequestType()) // also rebuild if the NETWORK CHANGES!!!
            {
                // unlock
                radio.setCom(request.getComType());

                logs.startTime();
                graph = new Graph(nw, radio); // graph.print();
                logs.graphstats.add(System.nanoTime() - logs.startTime);
                logs.graphRebuilds++;
            }

            logs.branchFactors.add(graph.branchingFactor);

            // performs A* search in the graph
            logs.startTime();
            graph.aStar(request.getToNode(), request.getFromNode(), radio.MAX_HOPS);
            logs.Astarstats.add(System.nanoTime() - logs.startTime);
        }

        // logs.print();

        // logs.printBFS2();
        // logs.printAstar2();
        // logs.printBuild();

        // _hlaWorld.disconnect();
    }
}
