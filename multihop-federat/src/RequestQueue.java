import java.util.concurrent.LinkedBlockingQueue;

public class RequestQueue {

    public RequestQueue() {}

    private final LinkedBlockingQueue<Request> requestQueue = new LinkedBlockingQueue<>();

    public boolean firstRequest = true;

    public long startMillis;

    public void add(Request r) {
        if (firstRequest) {
            startMillis = System.currentTimeMillis();
            firstRequest = false;
        }

        requestQueue.add(r);
    }

    public int size() {
        return requestQueue.size();
    }

    public boolean isEmpty() {
        return requestQueue.isEmpty();
    }

    public Request poll() {
        return requestQueue.poll();
    }
}
