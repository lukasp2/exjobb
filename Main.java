import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

/*
 * ./plotter.py requires matplotlib to be installed
 * $ pip3 install matplotlib
 */

public class Main {

    public static int NUM_REQUESTS = 1;
    public static int MAX_HOPS = 6;
    
    public static void main(String args[]) {

	// create the radio functions which will define the graph
	Radio radio = new Radio();

	// creates input simulator defining network
	ExcelSim excelSim = new ExcelSim(100);

	// define graph
	Graph graph = new Graph();

	// creates queue for scheduling requests fill with random requests
	DynamicQueue dynamicQueue = new DynamicQueue(excelSim, NUM_REQUESTS); //dynamicQueue.print();

	// class for logging statistical data
	Logger logs = new Logger(excelSim.NUM_NODES, radio.DISTANCE,
				 dynamicQueue.BLOCK_SIZE, NUM_REQUESTS);
	
	// begin satisfy requests
	while (!dynamicQueue.isEmpty()) { 
	    Request request = dynamicQueue.poll(); //request.print();
	    radio.setCom(request.getComType());
	    
	    excelSim.randomizeSheets(); //excelSim.print();

	    // Building graph
	    if (dynamicQueue.changedRequestType()) // also rebuild if the network changes!!!
	    {
		logs.startTime();
		graph = new Graph(excelSim, radio); // graph.print();
		logs.graphstats.add(System.nanoTime() - logs.startTime);
		logs.graphRebuilds++;
	    }
	    
	    logs.branchFactors.add(graph.branchingFactor);
	    
	    // performs BFS search in the graph
	    // logs.startTime();
	    // graph.bfs(request.getToNode(), request.getFromNode(), MAX_HOPS);
	    // logs.BFSstats.add(System.nanoTime() - logs.startTime);
	    	    
	    // performs A* search in the graph
	    logs.startTime();
	    graph.aStar(request.getToNode(), request.getFromNode(), MAX_HOPS);
	    logs.Astarstats.add(System.nanoTime() - logs.startTime);
	}

	logs.print();
	    
	//logs.printBFS2();
	//logs.printAstar2();
	//logs.printBuild();
    }
}
