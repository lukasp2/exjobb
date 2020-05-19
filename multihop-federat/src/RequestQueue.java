import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class RequestQueue {
    public RequestQueue() {}

    private final LinkedBlockingQueue<Request> requestQueue = new LinkedBlockingQueue();

    private final ReentrantLock lock = new ReentrantLock();

    public void add(Request r) {
        requestQueue.add(r);
    }

    // removes and returns 20 elements in the request queue
    public RequestQueue poll20() {
        RequestQueue subRequestQueue = new RequestQueue();

        for (int i = 0; i < 20; ++i) {
            Request request = requestQueue.poll();

            if (request == null) {
                break;
            }

            subRequestQueue.add(request);
        }

        return subRequestQueue;
    }

    public int size() { return requestQueue.size(); }

    public boolean isEmpty() { return requestQueue.isEmpty(); }

    public int getRequestType() {
        if (requestQueue.peek() != null) {
            return requestQueue.peek().getRequestType();
        }
        return -1;
    }

    public void print() {
        for (Request r : requestQueue) {
            System.out.print(r.toString() + ", ");
        }
    }

    public Request poll() {
        return requestQueue.poll();
    }
}
