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
    
    Graph(Excelfile excelRW, Radio radio) {
	queue = new LinkedList<Node>();

	int numNodes = excelRW.getNumNodes();
	for (int i = 1; i <= numNodes; ++i) {
	    Node node = new Node(i);
	    nodes.add(node);
	}
	
	// build graph from excel data
	for (int y = 0; y < numNodes; ++y) {
	    for (int x = 0; x < numNodes; ++x) {
		if (y != x && radio.Com(excelRW, y, x)) {
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

	    while (steps.get(curr) != -1) {
		System.out.print(curr + " -> ");
		curr = steps.get(curr);
	    }
	    
	    System.out.print(curr);
	}

	public static void addStep(int me, int prev) {
	    steps.put(me, prev);
	}
      }
    
    public void bfs(Node start, Node goal) {
	Path path = new Path();
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
	    System.out.println("failed to find a path between node " + start + " and " + goal);
	}
    }
}
