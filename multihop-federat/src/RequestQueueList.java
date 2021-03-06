import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class RequestQueueList {

	RequestQueueList() {
		for (int i = 0; i < Radio.numComTypes; ++i) {
			requestQueueList.add(new RequestQueue());
		}
	}

	private final ArrayList<RequestQueue> requestQueueList = new ArrayList<>();

	public static final ReentrantLock lock = new ReentrantLock();

	// tracks number of requests in the queue
	private final Semaphore sema = new Semaphore(0);

	public boolean firstRequest = true;

	public long startMillis;

	public void add(Request request) {
		if (firstRequest) {
			startMillis = System.currentTimeMillis();
			firstRequest = false;
		}

		requestQueueList.get(request.getRequestType()).add(request);

		sema.release();
	}

	// all queues share a semaphore, when there exists one or more request in any queue, threads
	// will attempt to poll, but only one is let through
    public RequestQueue poll() throws InterruptedException {

		int requestType = Radio.randomizeCom();
		int i = 0;

		// wait for request
		sema.acquire();

		while (requestQueueList.get(requestType).isEmpty() && i++ < Radio.numComTypes) {
			requestType = (++requestType) % Radio.numComTypes;
		}
		RequestQueue requestQueue = requestQueueList.get(requestType).poll25();

		// .acquire() for each request taken
		sema.acquire(requestQueue.size() - 1);

		return requestQueue;
	}

    // returns true iff the RequestQueues contained in the RequestQueueList are empty
	public boolean isEmpty() {
		for (int i = 0; i < Radio.numComTypes; ++i) {
			if (!requestQueueList.get(i).isEmpty()) {
				return false;
			}
		}
		return true;
	}
}
