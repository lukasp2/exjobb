import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.Semaphore;

public class DynamicQueue {

	DynamicQueue() {}

	private LinkedList<Request> requests = new LinkedList<Request>();

	public final int BLOCK_SIZE = 20;

	private final ReentrantLock queueLock = new ReentrantLock();

	private final Semaphore sema = new Semaphore(0, false);

	// LOGGER:
	private boolean firstRequest = true;
	private long startMillis = 0;
	//

	public void  addRequest(Request request) {
		if (firstRequest) {
			System.out.println("START TIME!");
			startMillis = System.currentTimeMillis();
			firstRequest = false;
		}

		int countConsecutive = 0;

		queueLock.lock();
		for (int i = 0; i < requests.size(); i++) {
			if (requests.get(i).getRequestType() == request.getRequestType()) {
				while (i < requests.size()
					   && requests.get(i).getRequestType() == request.getRequestType()
					   && countConsecutive < BLOCK_SIZE) {
					countConsecutive++;
					i++;
				}
				if (countConsecutive < BLOCK_SIZE && i < requests.size()) {
					requests.add(i, request);
					sema.release(); // resource is available
					queueLock.unlock();
					return;
				}
				countConsecutive = 0;
			}
		}
		requests.add(request);
		queueLock.unlock();
		sema.release(); // resource is available
    }

    // Removes the first element in the queue and returns it.
    public Request poll() {

		try { sema.acquire(); } catch (InterruptedException ie) { System.out.println("DynQueue semaphore crashed!"); }

		// lock here so we don't add and poll in parallel.
		queueLock.lock();
		Request newRequest = requests.poll();
		queueLock.unlock();

		// LOGGER:
		if (requests.size() == 0) {
			System.out.print("elapsed time (ms): ");
			System.out.println((double)(System.currentTimeMillis() - startMillis) / 1000);
		}

		return newRequest;
    }

    // prints all requests in the queue
    public void print() {
    	queueLock.lock();
		for (Request r : requests) {
			System.out.println(r.toString());
		}
		queueLock.unlock();
    }

    public boolean isEmpty() {
		return requests.isEmpty();
    }
}
