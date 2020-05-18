import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
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

	public void addRequest(Request request) {
		if (firstRequest) {
			System.out.println("START TIME!");
			startMillis = System.currentTimeMillis();
			firstRequest = false;
		}

		queueLock.lock();
		requests.addFirst(request);
		queueLock.unlock();

		sema.release(); // resource in queue is available
    }

    // Removes the first element in the queue and returns it.
    public ArrayList<Request> poll() {

		try { sema.acquire(); } catch (InterruptedException ie) { System.out.println("DynQueue semaphore crashed!"); }

		ArrayList<Request> requestList = new ArrayList<>();

		// lock here so we don't add and poll in parallel.
		queueLock.lock();
		Request request = requests.poll();
		requestList.add(request);

		//pollAllSimilar20StepsAhead();
		requestList.addAll(pollUntil20(request.getRequestType()));
		queueLock.unlock();

		// LOGGER:
		if (requests.size() == 0) {
			System.out.print("elapsed time (sec): ");
			System.out.println((double)(System.currentTimeMillis() - startMillis) / 1000);
		}

		return requestList;
    }

    private ArrayList<Request> pollUntil20(int comType) {
		int numRequestsToLookFor = 20;
		int lookahead = 50;
		ArrayList<Request> requestList = new ArrayList<>();

		int i = 0;
		ListIterator<Request> it = requests.listIterator();
		while(it.hasNext() && ++i < lookahead && requestList.size() < numRequestsToLookFor) {
			Request r = it.next();
			if (r.getRequestType() == comType) {
				it.remove();
				requestList.add(r);
			}
		}

		return requestList;
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
