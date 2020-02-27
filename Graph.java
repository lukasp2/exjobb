import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Map;
import java.util.HashMap;

public class Graph {
    static ArrayList<Node> nodes = new ArrayList<Node>();
    private Queue<Node> queue;
    private boolean success;
    
    Graph(ExcelSim excelRW, Radio radio) {
	queue = new LinkedList<Node>();

	int numNodes = excelRW.getNumNodes();
	for (int i = 0; i < numNodes; ++i) {
	    Node node = new Node(i);
	    nodes.add(node);
	}
	
	// build graph from excel data
	for (int y = 0; y < numNodes; ++y) {
	    for (int x = 0; x < numNodes; ++x) {
		if (y != x && radio.Com(excelRW, x, y)) {
		    nodes.get(y).addNeighbour(nodes.get(x));
		}
	    }
	}
    }
    
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

    static class Path {
	static Map<Integer, Integer> steps;
	
	Path() {
	    steps = new HashMap<Integer, Integer>();
	}
	
	public static void printPath(int goal) {
	    int curr = goal;
	    
	    System.out.println("Found path!");
	    while (steps.get(curr) != -1) {
		System.out.print(curr + " <- ");
		curr = steps.get(curr);
	    }
	    
	    System.out.println(curr);
	}

	public static void addStep(int me, int prev) {
	    steps.put(me, prev);
	}
    }
    
    public void bfs(Node start, Node goal) {
	Path path = new Path();
	path.addStep(start.id, -1);
	queue.add(start);
	start.visited = true;
        // TODO: hopcounter
	
	while (!queue.isEmpty()) {
	    Node curr = queue.remove();
	    List<Node> neighbours = curr.getNeighbours();

	    if (neighbours.contains(goal)) {
		path.addStep(goal.id, curr.id);
		path.printPath(goal.id);
		success = true;
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

	if (!success) {
	    System.out.println("failed to find a path between node " + start.id + " and " + goal.id);
	}
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












