public class Radio {
    public int DISTANCE = 15;

	public final int MAX_HOPS = 6;

    // defines which communication type is currently used in the graph
    private int comType;

    public void setCom(int i) {
	comType = i;
    }

    public boolean Com(Network nw, int fromNode, int toNode) {
		switch (comType) {
			case 0:
				return voiceCom(nw, fromNode, toNode);
			case 1:
				return dataCom(nw, fromNode, toNode);
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
