import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.Semaphore;

public class DynamicQueue {

    public int BLOCK_SIZE = 20;

    private final ReentrantLock queueLock = new ReentrantLock();
    private final ReentrantLock requestLock = new ReentrantLock();
	private final Semaphore sema = new Semaphore(0, false);

	// I removed volatile:
    private LinkedList<Request> requests = new LinkedList<Request>();

    DynamicQueue() {}

	public void  addRequest(Request request) {
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

    	// "lock here so that two threads don't .aquire() for the same request."
    	//requestLock.lock();
		try { sema.acquire(); } catch (InterruptedException ie) { System.out.println("DynQueue semaphore crashed!"); }

		// lock here so we don't addRequest and poll in parallel.
		queueLock.lock();
		Request newRequest = requests.poll();
		queueLock.unlock();
		//requestLock.unlock();

		return newRequest;
    }

    // fills the queue with random requests
    public void fill(Network network, int requests) {
		for (int i = 0; i < requests; ++i) {
			int[] tf_node = network.getNodes();
			Request request = new Request(tf_node[0], tf_node[1], network.getCom());
			addRequest(request);
		}
    }

    // prints all requests in the queue
    public void print() {
    	queueLock.lock();
		for (Request r : requests) {
			r.print();
		}
		queueLock.unlock();
		System.out.println();
    }

    public boolean isEmpty() {
		return requests.isEmpty();
    }
}
