import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

    Graph(Excelfile excelfile, pathFunc) {
	queue = new LinkedList<Node>();

	// build graph from excel data and pathFunc
	for (int y = 0; y < ..; ++y) {
	    Node node = new Node(y);
	    nodes.add(node);
	    
	    for (int x = 0; x < ..; ++x) {
		int cellValue = excelfile.getCell(x, y);
		
		if (pathFunc(cellValue)) {
		    node.addNeighbour(x);
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
	    this.visited = false;
	}
	
	public List<Node> getNeighbours() {
	    return neighbours;
	}

	public void addNeighbour(int id) {
	    neighbours.add(id);
	}
    }
    static ArrayList<Node> nodes = new ArrayList<Node>();
    
    private Queue<Node> queue;
    
    public Edge getEdge(node A, node B) {
	// lookup in the excel doc
    }
    
    // performs a BFS search for a possible connection between A and B
    public void bfs(node A, node B, pathFunc) {

	queue.add(node);
	node.visited = true;
        // TODO: hopcounter
        // TODO: prioritize the immidiate path between A -> B!
	
	while (!queue.isEmpty()) {
	    
	    Node element = queue.remove();
	    
	    System.out.print(element.data + "t");
	    
	    List<Node> neighbours = element.getNeighbours();
	    
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
