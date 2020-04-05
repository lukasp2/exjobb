import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

/*
 * ./plotter.py requires matplotlib to be installed
 * $ pip3 install matplotlib
 */

public class Main {
    public static void main(String args[]) {

	// class for logging statistical data
	Logger logs = new Logger();
	
	// create input simulator defining network
	ExcelSim excelSim = new ExcelSim();
	
	// create the radio functions which will define the graph
	Radio radio = new Radio();

	// create a dynamic queue for scheduling requests
	DynamicQueue dynamicQueue = new DynamicQueue();

	// define graph
	Graph graph = new Graph();
	
	// fill the dynamic queue with random requests
	int NUM_REQUESTS = 983;
	dynamicQueue.fill(excelSim, NUM_REQUESTS);
	//dynamicQueue.print();

        // satisfy requests
	while (!dynamicQueue.isEmpty()) { 
	    Request request = dynamicQueue.poll();
	    //request.print();
	    radio.setCom(request.getComType());

	    excelSim.randomizeSheets();
	    //excelSim.print();

	    // Building graph
	    logs.startTime();
	    if (dynamicQueue.changedRequestType()) {
		graph = new Graph(excelSim, radio);
		logs.graphRebuilds++;
	    }
	    logs.graphstats.add(System.nanoTime() - logs.startTime);
	    //graph.print();

	    logs.branchFactors.add(graph.branchingFactor);
	       
	    // performs BFS search in the graph
	    logs.startTime();
	    graph.bfs(request.getToNode(), request.getFromNode(), 4);
	    logs.BFSstats.add(System.nanoTime() - logs.startTime);
	    
	    // performs A* search in the graph
	    logs.startTime();
	    graph.aStar(request.getToNode(), request.getFromNode(), 4);
	    logs.Astarstats.add(System.nanoTime() - logs.startTime);
	} 

	logs.NUM_NODES = excelSim.NUM_NODES;
	logs.RADIO_DISTANCE = radio.DISTANCE;
	logs.BLOCK_SIZE = dynamicQueue.getBlockSize();
	logs.NUM_REQUESTS = NUM_REQUESTS;
	logs.print();
    }
}
