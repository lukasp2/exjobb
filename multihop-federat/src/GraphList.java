import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.ArrayList;

public class GraphList {

    public GraphList() {
        while (graphs.size() < Radio.numComTypes) { graphs.add(new Graph()); }
    }

    private final ArrayList<Graph> graphs = new ArrayList<>();

    private long timeSinceLastUpdate = System.currentTimeMillis() - 100000;

    // adds or updates a graph
    public void update(Network network) {
        if (System.currentTimeMillis() - timeSinceLastUpdate > 2000) {
            for (int requestType = 0; requestType < Radio.numComTypes; ++requestType) {
                graphs.set(requestType, new Graph(network, requestType));
            }

            timeSinceLastUpdate = System.currentTimeMillis();
        }
    }

    public Graph get(int requestType) {
        if (graphs.size() > requestType)
            return graphs.get(requestType);
        else
            System.out.println("index " + requestType + " is out of rage of " + graphs.size() + " .. " + (System.currentTimeMillis() - timeSinceLastUpdate));

        return null;
    }
}
