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
    static ArrayList<Node> nodes = new ArrayList<>();

    // builds graph from input data
    Graph(ExcelSim excelRW, Radio radio) {
	
	// for writing to file
	FileWriter fw = new FileWriter();
	List<String> lines = new ArrayList<String>();
	
	// create nodes
	int numNodes = excelRW.getNumNodes();
	for (int i = 0; i < numNodes; ++i) {
	    Position nodePos = excelRW.getPosition(i);
	    Node node = new Node(i, nodePos);
	    nodes.add(node);
	    lines.add("[" + nodePos.x + ", " + nodePos.y + "],");
	}
	lines.add("]");
	
	// create graph neighbours
	for (int y = 0; y < numNodes; ++y) {
	    for (int x = 0; x < numNodes; ++x) {
		if (y != x && radio.Com(excelRW, x, y)) {
		    Node n1 = nodes.get(y);
		    Node n2 = nodes.get(x);
		    
		    n1.addNeighbour(n2);

		    lines.add("plt.plot([" + n1.position.x + ", " + n2.position.x + "],"
				 + "[" + n1.position.y + ", " + n2.position.y + "], 'y')");
		    
		}
	    }
	}
	
	fw.writeHeader();
	fw.writeList(lines);
    }

    // defines the nodes in the graph
    static class Node {    
	int id;
	boolean visited = false;
	List<Node> neighbours = new ArrayList<>();
	Position position = new Position(0, 0);

	// construct with id of a node
	Node(int id) {
	    this.id = id;
	}

	// construct with geographic position of a node
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
		System.out.println("found path!");
	    }
	    else {
		System.out.println("failed to find a path");
		return;
	    }
	    
	    int curr = goal;
	    while (steps.get(curr) != -1) {
		System.out.print(curr + " <- ");
		curr = steps.get(curr);
	    }
	    System.out.println(curr);

	    FileWriter fw = new FileWriter();
	    fw.writeResult(steps, nodes, goal);
	}
    }

    // defines an A* search algorithm
    public static void aStar(Node start, Node goal) {
	
	Comparator<Node> nodeDistanceComparator = new Comparator<Node>() {
		@Override
		public int compare(Node n1, Node n2) {
		    double n1dx = Math.abs(n1.position.x - goal.position.x);
		    double n1dy = Math.abs(n1.position.y - goal.position.y);
		    double n1ddist = Math.sqrt(Math.pow(n1dx, 2) + Math.pow(n1dy, 2));
		    
		    double n2dx = Math.abs(n2.position.x - goal.position.x);
		    double n2dy = Math.abs(n2.position.y - goal.position.y);
		    double n2ddist = Math.sqrt(Math.pow(n2dx, 2) + Math.pow(n2dy, 2));
		    
		    return (int)(n2ddist - n1ddist);
		}
	    };
	
	PriorityQueue<Node> prioQueue = new PriorityQueue<>(nodeDistanceComparator);
	prioQueue.add(start);

	Path path = new Path();
	path.addStep(start.id, -1);

	start.visited = true;
        // TODO: hopcounter
	
	while (!prioQueue.isEmpty()) {
	    Node curr = prioQueue.poll();
	    
	    List<Node> neighbours = curr.getNeighbours();

	    if (neighbours.contains(goal)) {
		path.addStep(goal.id, curr.id);
		break;
	    }
	    
	    for (int i = 0; i < neighbours.size(); i++) {
		Node neighbour = neighbours.get(i);
		
		if (neighbour != null && !neighbour.visited) {
		    prioQueue.add(neighbour);
		    neighbour.visited = true;
		    path.addStep(neighbour.id, curr.id);
		}
	    }
	}

	path.printResult(goal.id);
    }

    // defines an breadth first search (BFS) algorithm
    public void bfs(Node start, Node goal) {
	Queue<Node> queue = new LinkedList<Node>();
	queue.add(start);

	Path path = new Path();
	path.addStep(start.id, -1);

	start.visited = true;
        // TODO: hopcounter
	
	while (!queue.isEmpty()) {
	    Node curr = queue.remove();
	    List<Node> neighbours = curr.getNeighbours();

	    if (neighbours.contains(goal)) {
		path.addStep(goal.id, curr.id);
		break;
	    }
	    
	    for (int i = 0; i < neighbours.size(); i++) {
		Node neighbour = neighbours.get(i);
		
		if (neighbour != null && !neighbour.visited) {
		    queue.add(neighbour);
		    neighbour.visited = true;
		    path.addStep(neighbour.id, curr.id);
		}
	    }
	}

	path.printResult(goal.id);
    }
    
    public static void printNeighbours() {
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
