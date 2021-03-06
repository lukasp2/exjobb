import java.util.*;
import java.lang.Math;

public class Graph {

	Graph() { }

    public final boolean PLOT = true;

    public final ArrayList<Node> nodes = new ArrayList<>();

	public Network nw;

	private final Radio radio = new Radio();

	// for writing to file
	public FileWriter fw = new FileWriter();

    // builds graph from input data
    Graph(Network nw, int requestType) {

		radio.setCom(requestType);
		this.nw = nw;

		if (PLOT) { fw.writeHeader(); }
		List<Position> posList = new ArrayList<>();

		// create nodes
		int numNodes = nw.getNumNodes();
		for (int i = 0; i < numNodes; ++i) {
			Position nodePos = nw.getPosition(i);
			Node node = new Node(i, nodePos);
			nodes.add(node);
			posList.add(nodePos);
		}
		if (PLOT) { fw.writePoints(posList); }

		// create graph neighbours
		for (int y = 0; y < numNodes; ++y) {
			for (int x = 0; x < numNodes; ++x) {
				if (y != x && radio.Com(nw, x, y)) {
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

    // defines the graph traversal path
    class Path {
		Path() { }
		private final Map<Integer, Integer> steps = new HashMap<>();

		public void addStep(int me, int prev) {
			steps.put(me, prev);
		}

		public ArrayList<Integer> getPath(int goal) {
			ArrayList<Integer> path = new ArrayList<>();

			if (steps.containsKey(goal)) {
				int curr = goal;
				while (steps.get(curr) != -1) {
					path.add(curr);
					curr = steps.get(curr);
				}
				path.add(curr);
			}
			if (PLOT) { fw.writeNonActiveResult(steps, nodes, goal); }

			return path;
		}
    }

    // defines an A* search algorithm
    public ArrayList<Integer> aStar(Request request) {
		int maxhops = radio.getMaxHops();

		Node fromNode = nodes.get(request.getFromNode());
		Node goal = nodes.get(request.getToNode());

		// heuristic based on distance to the goal
		Comparator<Node> distanceComparator = (n1, n2) -> {
			double n1dx = Math.abs(n1.position.x - goal.position.x);
			double n1dy = Math.abs(n1.position.y - goal.position.y);
			double n1dist = Math.sqrt(Math.pow(n1dx, 2) + Math.pow(n1dy, 2));

			double n2dx = Math.abs(n2.position.x - goal.position.x);
			double n2dy = Math.abs(n2.position.y - goal.position.y);
			double n2dist = Math.sqrt(Math.pow(n2dx, 2) + Math.pow(n2dy, 2));

			if (n1dist > n2dist) // > is good, < is bad
				return 1;
			else
				return -1;
		};

		// heuristic based on signal quality to the goal
		Comparator<Node> signalQualityComparator = (n1, n2) -> {
			double n1S = nw.getConnection(n1.id, goal.id);
			double n2S = nw.getConnection(n2.id, goal.id);

			if (n1S > n2S)
				return 1;
			else
				return -1;
		};

		// heuristic based on signal quality to the goal
		Comparator<Node> randomComparator = (n1, n2) -> {
			Random random = new Random();
			int b = random.nextInt(2) + 1;
			return (int) (b  - 2);
		};

		//PriorityQueue<Node> prioQueue = new PriorityQueue<>(distanceComparator);
		PriorityQueue<Node> prioQueue = new PriorityQueue<>(signalQualityComparator);
		//PriorityQueue<Node> prioQueue = new PriorityQueue<>(randomComparator);

		prioQueue.add(fromNode);

		Path path = new Path();
		path.addStep(fromNode.id, -1);

		fromNode.visited = true;
		fromNode.previous_node = fromNode;

		while (!prioQueue.isEmpty()) {
			Node curr = prioQueue.poll();

			if (PLOT) {  fw.writeLine(curr.position.x, curr.position.y,
					 curr.previous_node.position.x, curr.previous_node.position.y, "firebrick"); }

			if (curr.hops < maxhops) {
				List<Node> neighbours = curr.getNeighbours();

				if (neighbours.contains(goal)) {
					path.addStep(goal.id, curr.id);
					break;
				}

				for (Node neighbour : neighbours) {
					if (neighbour != null && !neighbour.visited) {
						prioQueue.add(neighbour);
						neighbour.visited = true;
						path.addStep(neighbour.id, curr.id);
						neighbour.hops = curr.hops + 1;
						neighbour.previous_node = curr;
					}
				}
			}
		}

		return path.getPath(goal.id);
    }
}
