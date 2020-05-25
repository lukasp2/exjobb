import java.util.concurrent.LinkedBlockingQueue;

public class RequestQueue {

    public RequestQueue() {}

    private final LinkedBlockingQueue<Request> requestQueue = new LinkedBlockingQueue<>();

    public void add(Request r) {
        requestQueue.add(r);
    }

    public Request poll() {
        return requestQueue.poll();
    }

    public int size() {
        return requestQueue.size();
    }

    public boolean isEmpty() {
        return requestQueue.isEmpty();
    }

    public void print() {
        for (Request r : requestQueue) {
            System.out.println(r.toString());
        }
    }
}
