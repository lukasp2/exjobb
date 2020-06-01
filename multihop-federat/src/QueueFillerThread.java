public class QueueFillerThread implements Runnable {

    public QueueFillerThread(Network network, RequestQueueList requestQueueList) {
        this.network = network;
        this.requestQueueList = requestQueueList;
    }

    Network network;

    RequestQueueList requestQueueList;

    // fill the queue with all possible requests R. for 200 nodes, N, and 3 request types, K: R = N(N - 1) * K
    public void run() {
        int assignRequestToThread = 0;

        for (int fromNode : network.getConnections().keySet()) {
            for (int toNode : network.getConnections().get(fromNode).keySet()) {
                for (int requestType = 0; requestType < Radio.numComTypes; ++requestType)
                {
                    requestQueueList.add(new Request(fromNode, toNode, Radio.randomizeCom(), 0), assignRequestToThread);
                    assignRequestToThread = (++assignRequestToThread) % Main.NUM_THREADS;
                }
            }
        }
    }
}