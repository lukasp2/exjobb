import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// input:
// - every second containing excel document
// - a pair of nodes which requests communication

// cache the previous connections?

public class Main {
    public static void main(String args[]) {

	// initiate graph with excel values:
	Graph graph = new Graph();
	
	Vertice fromNode = new Vertice(1); // id from input
	Vertice toNode = new Vertice(2); // id from input

	Radio radio = new Radio();

	// decide function pointer here (type of com. between node A and B)
	func_ptr = radio.voiceCom();
	
	// if the two nodes does not have a good enough connection
	if ( func_ptr(fromNode, toNode) ) {
	    graph.getEdge(fromNode, toNode);
	}
	else {
	    graph.bfs(fromNode, toNode, func_ptr);
	}
    }
}
