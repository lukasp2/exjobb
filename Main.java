// input:
// - data every second from excel document
// - a pair of nodes which requests communication

// ideas:
// cache the previous connections?

public class Main {
    public static void main(String args[]) {

	Radio radio = new Radio();

	// sets a specified path function - type of communication between nodes
	pathFunc = radio.voiceCom();
	
	// creates adjecency matrix - Graph(fromNode, toNode, pathFunction);
	Graph graph = new Graph(1, 2, pathFunc);
	
	// communicates directly if the two nodes has a good enough connection.
	if ( pathFunc(fromNode, toNode) ) {
	    graph.getEdge(fromNode, toNode);
	}
	else {
	    graph.bfs(fromNode, toNode, pathFunc);
	}
    }
}
