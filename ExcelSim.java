import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class ExcelSim {
    public static int NUM_NODES;
    private static float[][] latencySheet;
    private static float[][] bandwidthSheet;
    private static float[][] packetlossSheet;
    private static Position[] positionSheet;
    
    // defines on which sheets in the excel document the different values are
    public static final int LATENCY = 0;
    public static final int BANDWIDTH = 1;
    public static final int PACKETLOSS = 2;

    ExcelSim(int NUM_NODES) {
	this.NUM_NODES = NUM_NODES;    
	latencySheet = new float[NUM_NODES][NUM_NODES];
	bandwidthSheet = new float[NUM_NODES][NUM_NODES];
	packetlossSheet = new float[NUM_NODES][NUM_NODES];
	positionSheet = new Position[NUM_NODES];
    }
    
    public static void randomizeSheets() {
	for (int y = 0; y < NUM_NODES; ++y) {
	    for (int x = 0; x < NUM_NODES; ++x)	{
		if (x != y)
		    latencySheet[y][x] = randomFill(100);
	    }
	}

	for (int y = 0; y < NUM_NODES; ++y) {
	    for (int x = 0; x < NUM_NODES; ++x)	{
		if (x != y)
		    bandwidthSheet[y][x] = randomFill(1000);
	    }
	}
	
	for (int y = 0; y < NUM_NODES; ++y) {
	    for (int x = 0; x < NUM_NODES; ++x) {
		if (x != y)
		    packetlossSheet[y][x] = randomFill(1);
	    }
	}

	for (int y = 0; y < NUM_NODES; ++y) {
	    positionSheet[y] = new Position((int)randomFill(100), (int)randomFill(100));
	}
    }
    
    public static float randomFill(int k) {
	Random random = new Random();
	float f = k * random.nextFloat();
	return f;
    }
    
    // randomizes the type of communication to be transmitted
    public static int getCom() {
	Random random = new Random();
	int i = random.nextInt(2);
	return 0;
    }
    
    public static int[] getNodes() {
	Random random = new Random();
	int[] nodes = new int[2];
	nodes[0] = random.nextInt(NUM_NODES);
	nodes[1] = random.nextInt(NUM_NODES);
	
	if (nodes[0] == nodes[1])
	    nodes[1] = (nodes[1] + 1) % NUM_NODES;

	return nodes;
    }

    public static float readCell(int x, int y, int s) {
	if (s == 0) 
	    return latencySheet[y][x];
	if (s == 1)
	    return bandwidthSheet[y][x];
	if (s == 2)
	    return packetlossSheet[y][x];
	return -1;
    }

    // gets the geographical position of a node
    public static Position getPosition(int node) {
    	return positionSheet[node];
    }

    public static int getNumNodes() {
	return NUM_NODES;
    }

    public static void print() {
	System.out.format("%20s\n", "LATENCY SHEET");
	System.out.format("%5s", "Node");
	for (int i = 0; i < NUM_NODES; ++i) { System.out.format("%5d", i); }
	System.out.println();
	
	for (int y = 0; y < NUM_NODES; ++y) {
	    System.out.format("%5d", y);
	    for (int x = 0; x < NUM_NODES; ++x)
		System.out.format("%5.0f", latencySheet[y][x]);
	    System.out.println();
	}
	
	System.out.format("\n%20s\n", "BANDWIDTH SHEET");
	System.out.format("%5s", "Node");
	for (int i = 0; i < NUM_NODES; ++i) { System.out.format("%5d", i); }
	System.out.println();

	for (int y = 0; y < NUM_NODES; ++y) {
	    System.out.format("%5d", y);
	    for (int x = 0; x < NUM_NODES; ++x)
		System.out.format("%5.0f", bandwidthSheet[y][x]);
	    System.out.println();
	}

	System.out.format("\n%20s\n", "PACKET LOSS SHEET");
	System.out.format("%5s", "Node");
	for (int i = 0; i < NUM_NODES; ++i) { System.out.format("%5d", i); }
	System.out.println();

	for (int y = 0; y < NUM_NODES; ++y) {
	    System.out.format("%5d", y);
	    for (int x = 0; x < NUM_NODES; ++x)
		System.out.format("%5.02f", packetlossSheet[y][x]);
	   System.out.println();
	}

	System.out.format("\n%20s\n", "POSITION SHEET");
	System.out.format("%5s\n", "Node - Pos(x,y)");
	
	for (int i = 0; i < NUM_NODES; ++i) {
	    System.out.format("%5d", i);
    	    System.out.format("%3s%.0f,%.0f)", "(", positionSheet[i].x, positionSheet[i].y);
	    System.out.println();
	}

	System.out.println();
    }
}

