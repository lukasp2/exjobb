import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

/*
 * ./plotter.py requires matplotlib to be installed
 * $ pip3 install matplotlib
 */

public class Main {
    public static void main(String args[]) {

	// create input simulator
	ExcelSim excelSim = new ExcelSim();
	
	// create the radio functions
	Radio radio = new Radio();
	
	// randomize communication type (e.g. voice)
	// radio.setCom(excelSim.getCom());

	long startTime;	
	long endTime;	
	List<Long> BFSstats = new ArrayList<Long>();
	List<Long> Astarstats = new ArrayList<Long>();
	List<Long> graphstats = new ArrayList<Long>();
	List<Double> branchFactors = new ArrayList<Double>();

	DynamicQueue dynamicQueue = new DynamicQueue();

	// Fill the queue with requests
	int LOOPS = 1000;
	for (int i = 0; i < LOOPS; ++i) {
	    int[] tf_node = excelSim.getNodes();
	    Request request = new Request(tf_node[0], tf_node[1], excelSim.getCom());
	    dynamicQueue.add(request);
	}
	// dynamicQueue.print();

	Graph graph = new Graph();

	int graphRebuilds = 0;
        // Satisfy requests
	while (!dynamicQueue.isEmpty()) { 
	    Request request = dynamicQueue.poll();
	    radio.setCom(request.getComType());

	    excelSim.randomizeSheets();
	    //excelSim.printSheets();

	    startTime = System.nanoTime();

	    if (dynamicQueue.changedRequestType())
	    {
		graph = new Graph(excelSim, radio);
		graphRebuilds++;
	    }
	    
	    endTime = System.nanoTime();	    
	    graphstats.add(endTime - startTime);
	    //graph.printNeighbours();

	    branchFactors.add(graph.branchingFactor);
	    //System.out.println("Seeking path between nodes " + tf_node[0] + " and " + tf_node[1]);
	       
	    // performs BFS search in the graph
	    startTime = System.nanoTime();
	    graph.bfs(request.getToNode(), request.getFromNode(), 4);
	    endTime = System.nanoTime();
	    BFSstats.add(endTime - startTime);
	    
	    // performs A* search in the graph
	    startTime = System.nanoTime();
	    graph.aStar(request.getToNode(), request.getFromNode(), 4);
	    endTime = System.nanoTime();
	    Astarstats.add(endTime - startTime);
	} 

	////////// OUTPUT //////////
	double avgbr = 0;
	for (double d : branchFactors) {
	    avgbr += d;
	}
	avgbr /= branchFactors.size();
    
	System.out.println("graph searches: " + LOOPS);
	System.out.println("nodes in graph: " + excelSim.NUM_NODES);
	System.out.println("radio reach: " + radio.DISTANCE);
	System.out.printf("%s%.2f\n\n", "avg branching factor: ", avgbr);

	System.out.println("Graph build");
	long sum = 0;
	for (long d : graphstats) {
	    sum += d;
	}
	System.out.println("\ttot runtime: " + sum/1000000 + " ms");

	double Graphavg = (double)sum / graphstats.size();
	System.out.printf("%s%.3f%s\n","\tavg runtime: ", Graphavg/1000000, " ms");
	
	System.out.println("\nBreadth First Search");
	sum = 0;
	for (long d : BFSstats) {
	    sum += d;
	}
	System.out.println("\ttot runtime: " + sum/1000000 + " ms");

	double BFSavg = (double)sum / BFSstats.size();
	System.out.printf("%s%.3f%s\n","\tavg runtime: ", BFSavg/1000000, " ms");

	System.out.println("\nA* search");
	sum = 0;
	for (long d : Astarstats) {
	    sum += d;
	}
	System.out.println("\ttot runtime: " + sum/1000000 + " ms");

	double Astaravg = (double)sum / Astarstats.size();
	System.out.printf("%s%.3f%s\n","\tavg runtime: ", Astaravg/1000000, " ms");
	
	System.out.printf("\n%s\n\t%d\n","Graph Rebuilds ", graphRebuilds);
    }
}
