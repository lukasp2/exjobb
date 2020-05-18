
public class QueueFillerThread implements Runnable {

    public QueueFillerThread(Network nw, RequestQueueList requestQueueList) {
        // stores network and dynamic queue as references.
        this.nw = nw;
        this.requestQueueList = requestQueueList;

        Thread t = new Thread(this);
        t.setName("QueueFillerThread");
        t.start();
    }

    public Network nw;

    public RequestQueueList requestQueueList;

    // fill the queue with all possible requests
    public void run() {
        for (int fromNode : nw.getConnections().keySet()) {
            for (int toNode : nw.getConnections().get(fromNode).keySet()) {
                //for (int i = 0; i < Radio.numComTypes; ++i) {
                    requestQueueList.add(new Request(fromNode, toNode, Radio.randomizeCom(), 1));
                //}
            }
        }

        if (true) {
            System.out.println("Filled queue:");
            requestQueueList.print();
        }
    }
}