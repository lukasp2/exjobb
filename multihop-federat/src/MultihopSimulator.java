import devstudio.generatedcode.*;
import devstudio.generatedcode.exceptions.*;
import internal.prti1516e.com.google.common.collect.BiMap;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.Semaphore;

public class MultihopSimulator implements Runnable {

    public boolean EXIT_PROGRAM_WHEN_QUEUE_IS_EMPTY = true;

    public MultihopSimulator(HlaWorld _hlaWorld,
                             AStarSearch aStarSearch,
                             GraphList graphs,
                             RequestQueue requestQueue,
                             BiMap<UUID, Integer> nodeIDs,
                             Semaphore sema,
                             int i) {
        this._hlaRI = _hlaWorld.getHlaInteractionManager().getHlaResponseInteraction();
        this.aStarSearch = aStarSearch;
        this.graphs = graphs;
        this.requestQueue = requestQueue;
        this.nodeIDs = nodeIDs;
        this.exitThread = sema;
    }

    HlaInteractionManager.HlaResponseInteraction _hlaRI;

    private final AStarSearch aStarSearch;

    public GraphList graphs;

    // queue of requests that are handled locally by the thread
    public RequestQueue requestQueue;

    // translation between uuid <-> int
    public BiMap<UUID, Integer> nodeIDs;

    // counting threads that are not finished
    public Semaphore exitThread;

    public void run() {
        while (true) {
            if (EXIT_PROGRAM_WHEN_QUEUE_IS_EMPTY && requestQueue.isEmpty()) {
                exitThread.release();
                return;
            }

            Request request = getRequest();

            ArrayList<Integer> intPath = aStarSearch.search(graphs, request);

            sendResult(intPath, request.getTransactionID());
        }
    }

    private Request getRequest() {
        Request request = null;
        try {
            request = requestQueue.poll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return request;
    }

    private void sendResult(ArrayList<Integer> intPath, long transactionID) {
        ArrayList<byte[]> bytePath = new ArrayList<>();
        for (int nodeID : intPath) {
            bytePath.add(UuidAdapter.getBytesFromUUID(nodeIDs.inverse().get(nodeID)));
        }

        _hlaRI.setPath(bytePath.toArray(new byte[bytePath.size()][16]));
        _hlaRI.setTransactionID(transactionID);

        try {
            _hlaRI.sendInteraction();
        } catch (HlaNotConnectedException | HlaFomException | HlaInternalException | HlaRtiException e) {
            e.printStackTrace();
        }
    }
}
