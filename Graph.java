import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.lang.Math;

public class Graph {
    public static boolean VERBOSE = false;
    public static boolean PLOT = true;
    
    public static ArrayList<Node> nodes;

    // for writing to file
    public static FileWriter fw = new FileWriter();

    public double branchingFactor = 0; // FOR TESTING
    
    Graph() {}
    
    public static ExcelSim xmlRW;
    
    // builds graph from input data
    Graph(ExcelSim xmlRW, Radio radio) {
	
	if (PLOT) { fw.writeHeader(); }
	nodes = new ArrayList<>();
	List<Position> posList = new ArrayList<Position>();
	
	this.xmlRW = xmlRW;
	
	// create nodes
	int numNodes = xmlRW.getNumNodes();
	for (int i = 0; i < numNodes; ++i) {
	    Position nodePos = xmlRW.getPosition(i);
	    Node node = new Node(i, nodePos);
	    nodes.add(node);
	    posList.add(nodePos);
	}
	if (PLOT) { fw.writePoints(posList); }

	List<String> lines = new ArrayList<String>();
	// create graph neighbours
	for (int y = 0; y < numNodes; ++y) {
	    for (int x = 0; x < numNodes; ++x) {
		if (y != x && radio.Com(xmlRW, x, y)) {
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
    static class Path {
	static Map<Integer, Integer> steps;
	
	Path() {
	    steps = new HashMap<Integer, Integer>();
	}

	public static void addStep(int me, int prev) {
	    steps.put(me, prev);
	}
	
	public static void printResult(int goal) {
	    if (steps.containsKey(goal)) {
		int curr = goal;
		while (steps.get(curr) != -1) {		
		    if (VERBOSE) { System.out.print(curr + " <- "); }
		    curr = steps.get(curr);
		}
		if (VERBOSE) { System.out.println(curr); }
	    }
	    else {
		if (VERBOSE) { System.out.println("\nno path was found ..."); }
	    }

	    if (PLOT) { fw.writeResult(steps, nodes, goal); }
	}
    }

    // defines an A* search algorithm
    public static void aStar(int start_i, int goal_i, int maxhops) {
	Node start = nodes.get(start_i);
	Node goal = nodes.get(goal_i);

	// heuristic based on distance to the goal
	Comparator<Node> nodeDistanceComparator = new Comparator<Node>() {
		@Override
		public int compare(Node n1, Node n2) {
		    double n1dx = Math.abs(n1.position.x - goal.position.x);
		    double n1dy = Math.abs(n1.position.y - goal.position.y);
		    double n1ddist = Math.sqrt(Math.pow(n1dx, 2) + Math.pow(n1dy, 2));
		    
		    double n2dx = Math.abs(n2.position.x - goal.position.x);
		    double n2dy = Math.abs(n2.position.y - goal.position.y);
		    double n2ddist = Math.sqrt(Math.pow(n2dx, 2) + Math.pow(n2dy, 2));
		    
		    return (int)(n1ddist - n2ddist);
		}
	    };
	
	// heuristic based on -latency * bandwidth * (1-packetloss)
	Comparator<Node> connectionComparator = new Comparator<Node>() {
		@Override
		public int compare(Node n1, Node n2) {
		    double n1conn = -xmlRW.readCell(n1.id, goal.id, xmlRW.LATENCY)
		    * xmlRW.readCell(n1.id, goal.id, xmlRW.BANDWIDTH)
		    * (1 - xmlRW.readCell(n1.id, goal.id, xmlRW.PACKETLOSS));
		    
		    double n2conn = -xmlRW.readCell(n2.id, goal.id, xmlRW.LATENCY)
		    * xmlRW.readCell(n2.id, goal.id, xmlRW.BANDWIDTH)
		    * (1 - xmlRW.readCell(n2.id, goal.id, xmlRW.PACKETLOSS));
		    
		    return (int)(n1conn - n2conn);
		}
	    };

	PriorityQueue<Node> prioQueue = new PriorityQueue<>(connectionComparator);
	// PriorityQueue<Node> prioQueue = new PriorityQueue<>(nodeDistanceComparator);
	
	prioQueue.add(start);

	Path path = new Path();
	path.addStep(start.id, -1);

	start.visited = true;
	start.previous_node = start;
	
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
	    
		for (int i = 0; i < neighbours.size(); i++) {
		    Node neighbour = neighbours.get(i);
		
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

	path.printResult(goal.id);
    }

    // defines an breadth first search (BFS) algorithm
    public static void bfs(int start_i, int goal_i, int maxhops) {
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
	    
		for (int i = 0; i < neighbours.size(); i++) {
		    Node neighbour = neighbours.get(i);
		
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

	path.printResult(goal.id);
    }
    
    public static void print() {
	System.out.format("%10s\n", "Graph Adjecency List");
	for (int i = 0; i < nodes.size(); ++i) {
	    System.out.print("Node " + nodes.get(i).id + " | ");
	    for (int k = 0; k < nodes.get(i).neighbours.size(); ++k) {
		System.out.format("%4d", nodes.get(i).neighbours.get(k).id);
	    }
	    System.out.println();
	}
	System.out.println();
    }
}
