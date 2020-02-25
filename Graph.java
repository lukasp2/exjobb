import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

    Graph(int fromNode, int toNode, pathFunc) {
	queue = new LinkedList<Node>();

	// build graph from excel data
    }

    static class Node {    
	int id;
	boolean visited;
    
	Node(int id) {
	    this.id = id;
	    this.visited = false;
	}
	
	public List<Node> getNeighbours(func_ptr) {
	    // lookup in the excel doc
	    // return only those accepted by func_ptr?
	}

	public void setNeighbours(List<Node> neighbours) {
	    this.neighbours = neighbours;
	}
    }
    static ArrayList<Node> nodes = new ArrayList<Node>();
    
    private Queue<Node> queue;
    
    // returns edge connecting A and B
    public Edge getEdge(node A, node B) {
	// lookup in the excel doc
    }
    
    // performs a BFS search for a possible connection between A and B
    public void bfs(node A, node B, pathFunc) {

	queue.add(node);
	node.visited = true;
        // hopcounter? (max hops dependent on pathFunc?)
	
	while (!queue.isEmpty()) {
	    
	    Node element = queue.remove();
	    
	    System.out.print(element.data + "t");
	    
	    List<Node> neighbours = element.getNeighbours(func_ptr);
	    
	    for (int i = 0; i < neighbours.size(); i++) {

		Node n = neighbours.get(i);
		
		if (n != null && !n.visited) {
		    queue.add(n);
		    n.visited = true;
		}
	    }
	}
    }
}
