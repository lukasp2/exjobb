
public class QueueFillerThread implements Runnable {

    public QueueFillerThread(Network nw, DynamicQueue dynamicQueue) {
        // stores network and dynamic queue as references.
        this.nw = nw;
        this.dynamicQueue = dynamicQueue;

        Thread t = new Thread(this);
        t.setName("QueueFillerThread");
        t.start();
    }

    public Network nw;

    public DynamicQueue dynamicQueue;

    // fill the queue with all possible requests
    public void run() {
        for (int fromNode : nw.getConnections().keySet()) {
            for (int toNode : nw.getConnections().get(fromNode).keySet()) {
                //for (int i = 0; i < Radio.numComTypes; ++i) {
                    dynamicQueue.addRequest(new Request(fromNode, toNode, Radio.randomizeCom(), 1));
                //}
            }
        }

        if (true) {
            System.out.println("Filled queue:");
            dynamicQueue.print();
        }
    }
}