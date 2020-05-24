import devstudio.generatedcode.*;
import devstudio.generatedcode.exceptions.*;
import internal.prti1516e.com.google.common.collect.BiMap;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class MultihopSimulator implements Runnable {

    public boolean EXIT_PROGRAM_WHEN_QUEUES_ARE_EMPTY = true;

    public MultihopSimulator(HlaWorld _hlaWorld,
                             Network network,
                             GraphList graphs,
                             RequestQueue requestQueue,
                             BiMap<UUID, Integer> nodeIDs,
                             Semaphore sema, ReentrantLock lock) {
        this._hlaRI = _hlaWorld.getHlaInteractionManager().getHlaResponseInteraction();
        this.aStarSearch = new AStarSearch(network);
        this.graphs = graphs;
        this.requestQueue = requestQueue;
        this.nodeIDs = nodeIDs;
        this.sema = sema;
        this.lock = lock;
    }

    public ReentrantLock lock;

    HlaInteractionManager.HlaResponseInteraction _hlaRI;

    private final AStarSearch aStarSearch;

    public GraphList graphs;

    public Network network;

    public RequestQueue requestQueue;

    public BiMap<UUID, Integer> nodeIDs;

    public Semaphore sema;

    public void run() {
        while (true) {

            lock.lock();
            if (EXIT_PROGRAM_WHEN_QUEUES_ARE_EMPTY && requestQueue.isEmpty()) {
                lock.unlock();
                sema.release();
                return;
            }

            Request request = requestQueue.poll();
            lock.unlock();

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
