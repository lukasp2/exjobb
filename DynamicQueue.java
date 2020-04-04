import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class DynamicQueue {

    public int BLOCK_SIZE = 10;

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
    
    public boolean isEmpty() {
	return requests.isEmpty();
    }

    public boolean changedRequestType() {
	return changedRequestType;
    }
    
    public void print() {
	for (Request r : requests) {
	    r.print();
	}
    }
}
