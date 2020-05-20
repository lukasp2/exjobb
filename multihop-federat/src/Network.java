import java.util.*;

// This class holds all information about the network and its nodes
public class Network {

	Network() { }

	private final Map<Integer, Position> nodePositions = new HashMap<>();
	private final Map<Integer, Map<Integer, Double>> connections = new HashMap<>();

	public Map<Integer, Map<Integer, Double>> getConnections() {
		return connections;
	}

	// adds node to network
	public void addNode(int id, double latitude, double longitude) {
		nodePositions.put(id, new Position(latitude, longitude));
	}

	// returns the geographical position of a node
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

	// returns the signal quality between two nodes
	public double getConnection(int fromNode, int toNode) {
		if (connections.containsKey(fromNode) && connections.get(fromNode).containsKey(toNode)) {
			return connections.get(fromNode).get(toNode);
		}

		return -1;
	}

	// returns number of nodes in the network
	public int getNumNodes() {
		return nodePositions.size();
	}
}

