import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class DynamicQueue {

    private int BLOCK_SIZE = 5;

    private int lastRequest = -1;

    private boolean changedRequestType = true;
    
    private LinkedList<Request> requests = new LinkedList<Request>();
    
    public void add(Request request) {
	int countConsecutive = 0;
	
	for (int i = 0; i < requests.size(); i++) {
	    if (requests.get(i).getComType() == request.getComType()) {
		while (i < requests.size()
		       && requests.get(i).getComType() == request.getComType()
		       && countConsecutive < BLOCK_SIZE) {
		    countConsecutive++;
		    i++;
		}
		if (countConsecutive < BLOCK_SIZE && i < requests.size()) {
		    requests.add(i, request);
		    return;
		}
		countConsecutive = 0;
	    }
	}
	requests.add(request);
    }

    // removes the first element in the queue and returns it
    public Request poll() {
	Request thisRequest = requests.poll();
	
	if (thisRequest.getComType() != lastRequest) {
	    changedRequestType = true;
	    lastRequest = thisRequest.getComType();
	}
	else {
	    changedRequestType = false;
	}
	
	return thisRequest;
    }

    // fills the queue with random requests
    public void fill(ExcelSim excelSim, int requests) {
	for (int i = 0; i < requests; ++i) {
	    int[] tf_node = excelSim.getNodes();
	    Request request = new Request(tf_node[0], tf_node[1], excelSim.getCom());
	    add(request);
	}
    }

    // prints all requests in the queue
    public void print() {
	for (Request r : requests) {
	    r.print();
	}
	System.out.println();
    }
    
    // getters //
    public boolean changedRequestType() {
	return changedRequestType;
    }

    public int getBlockSize() {
	return BLOCK_SIZE;
    }
    
    public boolean isEmpty() {
	return requests.isEmpty();
    }
}
