import java.util.Random;

public class ExcelSim {
    private static final int NUM_NODES = 10;
    
    private static float[][] latencySheet;
    private static float[][] bandwidthSheet;
    private static float[][] packetlossSheet;

    ExcelSim() {
	latencySheet = new float[NUM_NODES][NUM_NODES];
	for (int y = 0; y < NUM_NODES; ++y) {
	    for (int x = 0; x < NUM_NODES; ++x)	{
		if (x != y)
		    latencySheet[y][x] = randomFill(100);
	    }
	}
	    
	bandwidthSheet = new float[NUM_NODES][NUM_NODES];
	for (int y = 0; y < NUM_NODES; ++y) {
	    for (int x = 0; x < NUM_NODES; ++x)	{
		if (x != y)
		    bandwidthSheet[y][x] = randomFill(1000);
	    }
	}
	
	packetlossSheet = new float[NUM_NODES][NUM_NODES];
	for (int y = 0; y < NUM_NODES; ++y) {
	    for (int x = 0; x < NUM_NODES; ++x) {
		if (x != y)
		    packetlossSheet[y][x] = randomFill(1);
	    }
	}
    }

    public static float randomFill(int k) {
	Random random = new Random();
	float f = k * random.nextFloat(); 
	return f;
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

    public static int getNumNodes() {
	return NUM_NODES;
    }

    public static void printSheets() {
	System.out.println("Latency Sheet:");
	for (int y = 0; y < NUM_NODES; ++y) {
	    for (int x = 0; x < NUM_NODES; ++x)
		System.out.format("%4.0f ", latencySheet[y][x]);
	    System.out.println();
	}

	System.out.println("\nBandwidth Sheet:");
	for (int y = 0; y < NUM_NODES; ++y) {
	    for (int x = 0; x < NUM_NODES; ++x)
		System.out.format("%4.0f ", bandwidthSheet[y][x]);
	    System.out.println();
	}
	    
	System.out.println("\nPacket loss Sheet:");
	for (int y = 0; y < NUM_NODES; ++y) {
	    for (int x = 0; x < NUM_NODES; ++x)
		System.out.printf("%.02f ", packetlossSheet[y][x]);
	   System.out.println();
	}
	System.out.println();	
    }
    
}
