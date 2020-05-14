
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

    // fill the queue with all possible requests
    public void run() {
        while (true) {
            if (nw.isUpdated) {
                for (int fromNode : nw.getConnections().keySet()) {
                    for (int toNode : nw.getConnections().get(fromNode).keySet()) {
                        dynamicQueue.addRequest(new Request(fromNode, toNode, nw.getCom()));
                    }
                }
                System.out.println("Filled queue:");
                dynamicQueue.print();

                nw.isUpdated = false;
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}