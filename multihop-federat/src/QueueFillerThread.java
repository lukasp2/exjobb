public class QueueFillerThread implements Runnable {

    public QueueFillerThread(Network nw, DynamicQueue dynamicQueue) {
        // stores network and dynamic queue as references.
        this.nw = nw;
        this.dynamicQueue = dynamicQueue;

        Thread t = new Thread(this);
        t.start();
    }

    public Network nw;
    public DynamicQueue dynamicQueue;
    private int fillTimer = 5000;

    // fill the queue with all possible requests
    public void run() {
        // TODO: only perform fill if
        //  1. timer is 0, and
        //  2. ConnectionSimulator has since last fill sent a new network description
        //  then reset timer to original value.

        // if (fillTimer = 0 && nw.isUpdated) {
        for (int fromNode : nw.getConnections().keySet()) {
            for (int toNode : nw.getConnections().get(fromNode).keySet()) {
                dynamicQueue.addRequest(new Request(fromNode, toNode, nw.getCom()));
            }
        }
        // }
        // nw.isUpdated=false;
        fillTimer = 5000;
    }
}