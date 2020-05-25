import java.util.ArrayList;

public class RequestQueueList {

    RequestQueueList() {
        for (int i = 0; i < Main.NUM_THREADS; ++i) {
            requestQueueList.add(new RequestQueue());
        }
    }

    private final ArrayList<RequestQueue> requestQueueList = new ArrayList<>();

    public void add(Request request, int thread) {
        requestQueueList.get(thread).add(request);
    }

    public RequestQueue get(int index) {
        return requestQueueList.get(index);
    }
}
