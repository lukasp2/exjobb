import java.util.*;

// This class holds all information about the network and its nodes
public class Network {

	Network() { }

	private Map<Integer, Position> nodePositions = new HashMap();
	private Map<Integer, Map<Integer, Double>> connections = new HashMap();

	public Map<Integer, Map<Integer, Double>> getConnections() {
		return connections;
	}

	public void addNode(int id, double latitude, double longitude) {
		nodePositions.put(id, new Position(latitude, longitude));
	}

	// gets the geographical position of a node
	public Position getPosition(int node) {
		return nodePositions.get(node);
	}

	// adds or updates a connection between two nodes
	public void addConnection(int fromNode, int toNode, double signalQuality) {
		if (!connections.containsKey(fromNode)) {
			connections.put(fromNode, new HashMap<>());
		}

		connections.get(fromNode).put(toNode, signalQuality);
	}

	// gets the signal quality between two nodes
	public double getConnection(int fromNode, int toNode) {
		if (connections.containsKey(fromNode) && connections.get(fromNode).containsKey(toNode)) {
			return connections.get(fromNode).get(toNode);
		}

		return -1;
	}

	// randomizes two nodes which will communicate
	public int[] getNodes() {
		int NUM_NODES = nodePositions.size();

		Random random = new Random();
		int[] nodes = new int[2];
		nodes[0] = random.nextInt(NUM_NODES);
		nodes[1] = random.nextInt(NUM_NODES);

		if (nodes[0] == nodes[1])
			nodes[1] = (nodes[1] + 1) % NUM_NODES;

		return nodes;
	}

	public int getNumNodes() {
		return nodePositions.size();
	}

	public void print() {
		int NUM_NODES = nodePositions.size();

		System.out.format("\n%20s\n", "POSITION SHEET");
		System.out.format("%5s\n", "Node - Pos(x,y)");

		for (int i = 0; i < NUM_NODES; ++i) {
			System.out.format("%5d", i);
			System.out.format("%3s%.5f,%.5f)", "(", nodePositions.get(i).x, nodePositions.get(i).y);
			System.out.println();
		}

		System.out.format("\n%20s\n", "SIGNAL QUALITY SHEET");
		System.out.format("%5s\n", "Quality of signal - 0..11");

		System.out.print("     ");
		for (int y = 0; y < NUM_NODES; ++y) {
			System.out.format("%8d", y);
		}
		System.out.println();

		int a = 0;
		int b = 0;
		for (Map.Entry<Integer, Map<Integer, Double>> entry : connections.entrySet()) {
			System.out.format("%5d", entry.getKey());
			a++;
			b=0;
			for (Map.Entry<Integer, Double> entry2 : entry.getValue().entrySet()) {
				b++;
				if (a == b) { System.out.format("%8.03f", -1.0); }
				System.out.format("%8.03f", entry2.getValue());
			}
			System.out.println();
		}
		System.out.println();
	}
}

