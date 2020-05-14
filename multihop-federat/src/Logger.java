import java.util.ArrayList;
import java.util.List;

public class Logger {

    public long startTime = 0;	
    public int graphRebuilds = 0;
    
    public List<Long> BFSstats = new ArrayList<Long>();
    public List<Long> Astarstats = new ArrayList<Long>();
    public List<Long> graphstats = new ArrayList<Long>();
    public List<Double> branchFactors = new ArrayList<Double>();

    public int NUM_REQUESTS = 0;
    public int RADIO_DISTANCE = 0;
    public int BLOCK_SIZE = 0;
    public int NUM_NODES = 0;

    Logger(int NUM_NODES, int RADIO_DISTANCE, int BLOCK_SIZE, int NUM_REQUESTS) {
		this.NUM_NODES = NUM_NODES;
		this.RADIO_DISTANCE = RADIO_DISTANCE;
		this.BLOCK_SIZE = BLOCK_SIZE;
		this.NUM_REQUESTS = NUM_REQUESTS;
    }
    
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
		System.out.println("queue block size: " + BLOCK_SIZE);
		System.out.printf("%s%.2f\n\n", "avg branching factor: ", avgbr);
		System.out.printf("%s%d%s%.2f%s\n\n","rebuilds: ", graphRebuilds, " (", (double)graphRebuilds/NUM_REQUESTS * 100,"% of requests required rebuild)");

		printGraph();
		printBFS();
		printAstar();
    }

    public void printGraph() {
		System.out.println("Graph build");
		long sum = 0;
		for (long d : graphstats) {
			sum += d;
		}
		System.out.println("\ttot runtime: " + sum/1000000 + " ms");

		double Graphavg = (double)sum / graphstats.size();
		System.out.printf("\t%s%.3f%s\n","avg runtime: ", Graphavg/1000000, " ms");
    }
    
    public void printBFS() {
		System.out.println("\nBreadth First Search");
		int sum = 0;
		for (long d : BFSstats) {
			sum += d;
		}
		System.out.println("\ttot runtime: " + sum/1000000 + " ms");

		double BFSavg = (double)sum / BFSstats.size();
		System.out.printf("%s%.3f%s\n","\tavg runtime: ", BFSavg/1000000, " ms");
    }
    
    public void printBFS2() {
		System.out.print("[" + NUM_NODES);

		int sum = 0;
		for (long d : BFSstats) {
			sum += d;
		}
		System.out.println("," + (double)sum/1000000 + "],");
    }

    public void printAstar() {
		System.out.println("\nA* search");
		int sum = 0;
		for (long d : Astarstats) {
			sum += d;
		}
		System.out.println("\ttot runtime: " + sum/1000000 + " ms");

		double Astaravg = (double)sum / Astarstats.size();
		System.out.printf("%s%.3f%s\n","\tavg runtime: ", Astaravg/1000000, " ms");
    }

    public void printAstar2() {
		System.out.print("[" + NUM_NODES);

		int sum = 0;
		for (long d : Astarstats) {
			sum += d;
		}
		System.out.println("," + (double)sum/1000000 + "],");
    }
    
    public void printBuild() {
		System.out.print("[" + BLOCK_SIZE);

		long sum = 0;
		for (long d : graphstats) {
			sum += d;
		}
		System.out.println("," + (double)sum/1000000 + "],");
    }
}
