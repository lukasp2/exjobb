import java.util.Random;

public class Radio {
	//avg distance was 0.034
    public static double DISTANCE = 0.002;

	private final int MAX_HOPS = 4;

	public static final int numComTypes = 3;

    // specifies communication type currently used
    private int comType;

	// randomizes the type of communication to be transmitted
	public static int randomizeCom() {
		Random random = new Random();
		return random.nextInt(numComTypes);
	}

    public void setCom(int i) {
	comType = i;
    }

    public int getMaxHops() {
		return MAX_HOPS;
	}

    public boolean Com(Network nw, int fromNode, int toNode) {
		switch (comType) {
			case 0:
				return distCom(nw, fromNode, toNode); //voiceCom(nw, fromNode, toNode);
			case 1:
				return distCom(nw, fromNode, toNode); //dataCom(nw, fromNode, toNode);
			case 2:
				return distCom(nw, fromNode, toNode);
		}
		return false;
    }
    
    // return the possibility of voice communication between node A and node B
    public boolean voiceCom(Network nw, int fromNode, int toNode) {
    	return nw.getConnection(fromNode, toNode) > 5;
		/*return nw.readCell(fromNode, toNode, nw.LATENCY) < 20
			&& nw.readCell(fromNode, toNode, nw.BANDWIDTH) > 600
			&& nw.readCell(fromNode, toNode, nw.PACKETLOSS) < 0.2;*/
    }
    
    // return the possibility of data communication between node A and node B
    public boolean dataCom(Network nw, int fromNode, int toNode) {
		return nw.getConnection(fromNode, toNode) > 3;
		/*return nw.readCell(fromNode, toNode, nw.LATENCY) < 70
			&& nw.readCell(fromNode, toNode, nw.BANDWIDTH) > 300
			&& nw.readCell(fromNode, toNode, nw.PACKETLOSS) < 0.3;*/
    }

    // return the possibility of communication between node A and node B
    // purely based on distance
    public boolean distCom(Network nw, int fromNode, int toNode) {
		Position p1 = nw.getPosition(fromNode);
		Position p2 = nw.getPosition(toNode);

		double x_dist = Math.abs(p1.x - p2.x);
		double y_dist = Math.abs(p1.y - p2.y);
		double dist = Math.sqrt(Math.pow(x_dist, 2) + Math.pow(y_dist, 2));

		return dist < DISTANCE;
    }
}
