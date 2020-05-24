import java.util.*;

public class Graph {

	public Graph() {}

    public final boolean PLOT = true;

    public final ArrayList<Node> nodes = new ArrayList<>();

	// for writing to file
	public FileWriter fw = new FileWriter();

    // builds graph from input data
    Graph(Network network, int requestType) {

		Radio radio = new Radio();
		radio.setCom(requestType);

		if (PLOT) { fw.writeHeader(); }
		List<Position> posList = new ArrayList<>();

		// create nodes
		int numNodes = network.getNumNodes();
		for (int i = 0; i < numNodes; ++i) {
			Position nodePos = network.getPosition(i);
			Node node = new Node(i, nodePos);
			nodes.add(node);
			posList.add(nodePos);
		}
		if (PLOT) { fw.writePoints(posList); }

		// create graph neighbours
		for (int y = 0; y < numNodes; ++y) {
			for (int x = 0; x < numNodes; ++x) {
				if (y != x && radio.Com(network, x, y)) {
					Node n1 = nodes.get(y);
					Node n2 = nodes.get(x);
					n1.addNeighbour(n2);

					if (PLOT) { fw.writeLine(n1.position.x, n1.position.y, n2.position.x, n2.position.y, "silver"); }
				}
			}
		}
    }

    // defines the nodes in the graph
    static class Node {    
		int id;
		boolean visited = false;
		int hops = 0;
		Node previous_node;

		List<Node> neighbours = new ArrayList<>();
		Position position;

		// construct with geographic position of a node (used by A* search)
		Node(int id, Position position) {
			this.id = id;
			this.position = position;
		}

		public List<Node> getNeighbours() {
			return neighbours;
		}

		public void addNeighbour(Node node) {
			neighbours.add(node);
		}
    }
}
