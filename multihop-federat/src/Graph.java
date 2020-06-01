import java.util.*;

public class Graph {

	public Graph() {}

    public final ArrayList<Node> nodes = new ArrayList<>();

    // builds graph from input data
    Graph(Network network, int requestType) {

		Radio radio = new Radio();
		radio.setCom(requestType);

		// create nodes
		int numNodes = network.getNumNodes();
		for (int i = 0; i < numNodes; ++i) {
			Position nodePos = network.getPosition(i);
			Node node = new Node(i, nodePos);
			nodes.add(node);
		}

		// create graph neighbours
		for (int y = 0; y < numNodes; ++y) {
			for (int x = 0; x < numNodes; ++x) {
				if (y != x && radio.Com(network, x, y)) {
					Node n1 = nodes.get(y);
					Node n2 = nodes.get(x);
					n1.addNeighbour(n2);
				}
			}
		}
    }

    // defines the nodes in the graph
    static class Node {    
		public int id;
		public boolean visited = false;
		public int hops = 0;
		public Node previous_node;

		public List<Node> neighbours = new ArrayList<>();
		public Position position;

		// construct with geographic position of a node (used by A* search)
		Node(int id, Position position) {
			this.id = id;
			this.position = position;
		}

		public List<Node> getNeighbours() {
			return neighbours;
		}

		public Position getPosition() {
			return position;
		}

		public void addNeighbour(Node node) {
			neighbours.add(node);
		}
    }
}
