import devstudio.generatedcode.*;
import devstudio.generatedcode.exceptions.*;
import internal.prti1516e.com.google.common.collect.BiMap;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.Semaphore;

public class MultihopSimulator implements Runnable {

    public boolean EXIT_PROGRAM_WHEN_QUEUES_ARE_EMPTY = true;

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
        this.sema = sema;
        this.id = i;
    }

    HlaInteractionManager.HlaResponseInteraction _hlaRI;

    private final AStarSearch aStarSearch;

    public GraphList graphs;

    public RequestQueue requestQueue;

    public BiMap<UUID, Integer> nodeIDs;

    public Semaphore sema;

    private int id;

    public void run() {
        while (true) {

            if (EXIT_PROGRAM_WHEN_QUEUES_ARE_EMPTY && requestQueue.isEmpty()) {
                sema.release();
                return;
            }
            else {
                //sema2.aquire(); wait for new request
            }

            Request request = requestQueue.poll();

            //System.out.println("thread " + id + " picked up request " + request.toString());

            ArrayList<Integer> res = aStarSearch.search(graphs, request);

            ArrayList<byte[]> byteArray = new ArrayList<>();
            for (int nodeID : res) {
                byteArray.add(UuidAdapter.getBytesFromUUID(nodeIDs.inverse().get(nodeID)));
            }

            _hlaRI.setPath(byteArray.toArray(new byte[byteArray.size()][16]));
            _hlaRI.setTransactionID(request.getTransactionID());

            try {
                _hlaRI.sendInteraction();
            } catch (HlaNotConnectedException | HlaFomException | HlaInternalException | HlaRtiException e) {
                e.printStackTrace();
            }
        }
    }
}
