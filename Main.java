import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String args[]) {
	
	// when a connection between node A and B is requested:
	// get input and convert everything to graph representation
	//
	// cache the previous connections?

	Graph graph = new Graph();
	
	Vertice fromNode = new Vertice(1);
	Vertice toNode = new Vertice(2);
	
	// if the two nodes does not have a good enough connection
	if ( !graph.voiceCom(fromNode, toNode) ) {
	    
	    // perform breadth-first search
	    graph.bfs(fromNode, toNode);
	}
	
    }
}
