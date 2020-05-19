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

	private final ReentrantLock queueLock = new ReentrantLock();

	private final Semaphore sema = new Semaphore(0);

	// LOGGER:
	private boolean firstRequest = true;
	private long startMillis;
	//

	public void add(Request request) {
		if (firstRequest) {
			System.out.println("START TIME!");
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

		queueLock.lock();
		sema.acquire();

		while (requestQueueList.get(requestType).isEmpty() && i++ < Radio.numComTypes) {
			requestType = (++requestType) % Radio.numComTypes;
		}
		RequestQueue requestQueue = requestQueueList.get(requestType).poll20();

		sema.acquire(requestQueue.size() - 1);

		if (queuesAreEmpty()) {
			System.out.print("elapsed time (sec): ");
			System.out.println((double) (System.currentTimeMillis() - startMillis) / 1000);
		}
		queueLock.unlock();

		return requestQueue;
	}

    // prints all requests in the queues
    public void print() {
    	queueLock.lock();
		for (RequestQueue rQ : requestQueueList) {
			rQ.print();
			System.out.println();
		}
		queueLock.unlock();
    }

	public boolean queuesAreEmpty() {
		for (int i = 0; i < Radio.numComTypes; ++i) {
			if (!requestQueueList.get(i).isEmpty()) {
				return false;
			}
		}
		return true;
	}
}
