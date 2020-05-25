import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class RequestQueue {

    public RequestQueue() {}

    private final LinkedBlockingQueue<Request> requestQueue = new LinkedBlockingQueue<>();

    // count requests in the queue
    public Semaphore requestSema = new Semaphore(0);

    public void add(Request r) {
        requestQueue.add(r);
        requestSema.release();
    }

    public Request poll() throws InterruptedException {
        requestSema.acquire();
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
