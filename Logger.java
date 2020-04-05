import java.util.ArrayList;
import java.util.List;

public class Logger {

    public static long startTime = 0;	
    public static int graphRebuilds = 0;
    
    public static List<Long> BFSstats = new ArrayList<Long>();
    public static List<Long> Astarstats = new ArrayList<Long>();
    public static List<Long> graphstats = new ArrayList<Long>();
    public static List<Double> branchFactors = new ArrayList<Double>();

    public static int NUM_REQUESTS;
    public static int RADIO_DISTANCE;
    public static int BLOCK_SIZE;
    public static int NUM_NODES;
    
    public void startTime() {
	startTime = System.nanoTime();
    }

    public void print() {
	double avgbr = 0;
	for (double d : branchFactors) {
	    avgbr += d;
	}
	avgbr /= branchFactors.size();
    
	System.out.println("graph searches: " + NUM_REQUESTS);
	System.out.println("nodes in graph: " + NUM_NODES);
	System.out.println("radio reach: " + RADIO_DISTANCE);
	System.out.printf("%s%.2f\n", "avg branching factor: ", avgbr);
	System.out.println("queue block size: " + BLOCK_SIZE + "\n");

	System.out.println("Graph build");
	long sum = 0;
	for (long d : graphstats) {
	    sum += d;
	}
	System.out.println("\ttot runtime: " + sum/1000000 + " ms");

	double Graphavg = (double)sum / graphstats.size();
	System.out.printf("\t%s%.3f%s\n","avg runtime: ", Graphavg/1000000, " ms");
	System.out.printf("\t%s%d%s%.2f%s\n","rebuilds: ", graphRebuilds, " (", (double)graphRebuilds/NUM_REQUESTS * 100,"% of requests required rebuild)");
	
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
    }
}
