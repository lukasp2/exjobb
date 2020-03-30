import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Graph {
    static ArrayList<Node> nodes = new ArrayList<Node>();

    // builds graph from input data
    Graph(ExcelSim excelRW, Radio radio) {
	int numNodes = excelRW.getNumNodes();
	for (int i = 0; i < numNodes; ++i) {
	    Node node = new Node(i);
	    nodes.add(node);
	}
	
	for (int y = 0; y < numNodes; ++y) {
	    for (int x = 0; x < numNodes; ++x) {
		if (y != x && radio.Com(excelRW, x, y)) {
		    nodes.get(y).addNeighbour(nodes.get(x));
		}
	    }
	}
    }

    // defines the nodes in the graph
    static class Node {    
	int id;
	boolean visited;
	List<Node> neighbours;
	
	Node(int id) {
	    this.id = id;
	    this.neighbours = new ArrayList<>();
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
	}
    }

    // defines an A* search algorithm
    public static void aStar(Node start, Node goal, int maxhops) {
	
	Comparator<Node> nodeDistanceComparator = new Comparator<Node>() {
		@Override
		public int compare(Node n1, Node n2) {
		    return n1.id - n2.id;
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












