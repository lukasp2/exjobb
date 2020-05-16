import java.util.*;
import java.lang.Math;

public class Graph {
    public final boolean VERBOSE = false;
    public final boolean PLOT = false;
    
    public final ArrayList<Node> nodes = new ArrayList<>();

	private final Radio radio = new Radio();

    // for writing to file
    public FileWriter fw = new FileWriter();

    public double branchingFactor = 0; // FOR TESTING
    
    Graph() { }
    
    public Network nw;
    
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

					if (PLOT) { fw.writeLine(n1.position.x, n1.position.y, n2.position.x, n2.position.y, 'y'); }
					branchingFactor++;
				}
			}
		}

		branchingFactor /= numNodes; // avg. branch factor
    }

    // defines the nodes in the graph
    static class Node {    
		int id;
		boolean visited = false;
		int hops = 0;

		Node previous_node; // FOR FW, CALC PACKETLOSS AND BANDWIDTH

		List<Node> neighbours = new ArrayList<>();
		Position position = new Position(0, 0);

		// construct with id of a node (used by BFS)
		Node(int id) {
			this.id = id;
		}

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
			ArrayList<Integer> path = new ArrayList<Integer>();

			int curr = goal;
			while (steps.get(curr) != -1) {
				path.add(curr);
				curr = steps.get(curr);
			}
			path.add(curr);

			if (PLOT) { fw.writeResult(steps, nodes, goal); }

			return path;
		}
    }

    // defines an A* search algorithm
    public ArrayList<Integer> aStar(Request request) {
		int maxhops = radio.getMaxHops(request.getRequestType());

		Node fromNode = nodes.get(request.getFromNode());
		Node goal = nodes.get(request.getToNode());

		// heuristic based on distance to the goal
		Comparator<Node> nodeDistanceComparator = (n1, n2) -> {
			double n1dx = Math.abs(n1.position.x - goal.position.x);
			double n1dy = Math.abs(n1.position.y - goal.position.y);
			double n1ddist = Math.sqrt(Math.pow(n1dx, 2) + Math.pow(n1dy, 2));

			double n2dx = Math.abs(n2.position.x - goal.position.x);
			double n2dy = Math.abs(n2.position.y - goal.position.y);
			double n2ddist = Math.sqrt(Math.pow(n2dx, 2) + Math.pow(n2dy, 2));

			return (int) (n1ddist - n2ddist);
		};

		PriorityQueue<Node> prioQueue = new PriorityQueue<>(nodeDistanceComparator);

		prioQueue.add(fromNode);

		Path path = new Path();
		path.addStep(fromNode.id, -1);

		fromNode.visited = true;
		fromNode.previous_node = fromNode;

		while (!prioQueue.isEmpty()) {
			Node curr = prioQueue.poll();

			if (PLOT) {  fw.writeLine(curr.position.x, curr.position.y,
					 curr.previous_node.position.x, curr.previous_node.position.y, 'g'); }

			if (curr.hops < maxhops) {
				if (VERBOSE) { System.out.println("expanded node " + curr.id); }

				List<Node> neighbours = curr.getNeighbours();

				if (neighbours.contains(goal)) {
					if (VERBOSE) { System.out.println("expanded node " + goal.id + ", found path!"); }
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
			else {
				if (VERBOSE) { System.out.println("... could not access node " + curr.id + ": maxhops reached"); }
			}
		}

		return path.getPath(goal.id);
    }

    // defines an breadth first search (BFS) algorithm
    public void bfs(int start_i, int goal_i, int maxhops) {
		Node start = nodes.get(start_i);
		Node goal = nodes.get(goal_i);

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(start);

		Path path = new Path();
		path.addStep(start.id, -1);

		start.visited = true;
		start.previous_node = start;

		while (!queue.isEmpty()) {
			Node curr = queue.remove();

			if (PLOT) { fw.writeLine(curr.position.x, curr.position.y,
					 curr.previous_node.position.x, curr.previous_node.position.y, 'g'); }

			if (curr.hops < maxhops) {
				if (VERBOSE) { System.out.println("expanded node " + curr.id); }

				List<Node> neighbours = curr.getNeighbours();

				if (neighbours.contains(goal)) {
					if (VERBOSE) { System.out.println("expanded node " + goal.id + ", found path!"); }
					path.addStep(goal.id, curr.id);
					break;
				}

				for (Node neighbour : neighbours) {
					if (neighbour != null && !neighbour.visited) {
						queue.add(neighbour);
						neighbour.visited = true;
						path.addStep(neighbour.id, curr.id);
						neighbour.hops = curr.hops + 1;
						neighbour.previous_node = curr;
					}
				}
			}
			else {
				if (VERBOSE) { System.out.println("... could not access node " + curr.id + ": maxhops reached"); }
			}
		}

		path.getPath(goal.id);
    }
    
    public void print() {
		System.out.format("%10s\n", "Graph Adjacency List");
		for (Node node : nodes) {
			System.out.print("Node " + node.id + " | ");
			for (int k = 0; k < node.neighbours.size(); ++k) {
				System.out.format("%4d", node.neighbours.get(k).id);
			}
			System.out.println();
		}
		System.out.println();
    }
}
