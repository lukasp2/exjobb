public class QueueFillerThread implements Runnable {

    public QueueFillerThread(Network network, RequestQueue requestQueue) {
        this.network = network;
        this.requestQueue = requestQueue;

        Thread t1 = new Thread(this);
        t1.start();
    }

    Network network;

    RequestQueue requestQueue;

    // fill the queue with all possible requests
    public void run() {
        for (int fromNode : network.getConnections().keySet()) {
            for (int toNode : network.getConnections().get(fromNode).keySet()) {
                //for (int i = 0; i < Radio.numComTypes; ++i) {
                    requestQueue.add(new Request(fromNode, toNode, Radio.randomizeCom(), 1));
                //}
            }
        }
    }
}