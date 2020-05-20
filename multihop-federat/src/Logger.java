import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Logger {

	public double elapsedTime = 0;
    public long startTime = 0;	

    private List<Long> Astarstats = new ArrayList<Long>();
    public List<Long> graphstats = new ArrayList<Long>();
    public List<Double> branchFactors = new ArrayList<Double>();

    public double RADIO_DISTANCE = 0;
    public int BLOCK_SIZE = 0;
    public int NUM_NODES = 0;
    public int HEURISTIC_TYPE = 0;

    private final ReentrantLock lock = new ReentrantLock();

    Logger(int NUM_NODES, double RADIO_DISTANCE, int BLOCK_SIZE, int HEURISTIC_TYPE) {
		this.NUM_NODES = NUM_NODES;
		this.RADIO_DISTANCE = RADIO_DISTANCE;
		this.BLOCK_SIZE = BLOCK_SIZE;
		this.HEURISTIC_TYPE = HEURISTIC_TYPE;
    }

    public void addAstarstat(Long val) {
    	lock.lock();
    	Astarstats.add(val);
    	lock.unlock();
	}

	public List<Long> getAstarstats() {
    	return Astarstats;
	}

	public void startTime() {
		startTime = System.nanoTime();
    }

	public void stopTime(List<Long> statList) {
    	Long time = System.nanoTime() - startTime;
		statList.add(time);
	}

	public void setElapsedTime() {
		elapsedTime = ((double) (System.currentTimeMillis() - RequestQueueList.startMillis) / 1000);
	}

	public void addBFactor(double d) {
    	branchFactors.add(d);
	}

    public void print() {
		double avgbr = 0;
		for (double d : branchFactors) {
			avgbr += d;
		}
		avgbr /= branchFactors.size();

		System.out.println("elapsed time: " + elapsedTime + " seconds");
		System.out.println("nodes in network: " + NUM_NODES);
		System.out.println("radio reach: " + RADIO_DISTANCE);
		System.out.println("queue block size: " + BLOCK_SIZE);
		System.out.printf("%s%.2f\n\n", "avg branching factor: ", avgbr);
    }

    public void printGraph() {
		System.out.println("Graph build");
		long sum = 0;
		for (long d : graphstats) {
			sum += d;
		}
		System.out.println("\trebuilds: " + graphstats.size() + " (" + (double)graphstats.size()/Astarstats.size() * 100 + "% of requests required rebuild)");
		System.out.println("\ttot runtime: " + sum/1000000 + " ms");

		double Graphavg = (double)sum / graphstats.size();
		System.out.printf("\t%s%.3f%s\n\n","avg runtime: ", Graphavg/1000000, " ms");
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
}
