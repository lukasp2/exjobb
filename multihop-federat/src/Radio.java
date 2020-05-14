public class Radio {
    public int DISTANCE = 15;

	public final int MAX_HOPS = 6;

    // defines which communication type is currently used in the graph
    private int comType;

    public void setCom(int i) {
	comType = i;
    }

    public boolean Com(Network xmlRW, int A, int B) {
		switch (comType) {
			case 0:
				return voiceCom(xmlRW, A, B);
			case 1:
				return dataCom(xmlRW, A, B);
			case 2:
				return distCom(xmlRW, A, B);
		}
		return false;
    }
    
    // return the possibility of voice communication between node A and node B
    public boolean voiceCom(Network nw, int A, int B) {
    	return nw.getConnection(A, B) > 5;
		/*return nw.readCell(A, B, nw.LATENCY) < 20
			&& nw.readCell(A, B, nw.BANDWIDTH) > 600
			&& nw.readCell(A, B, nw.PACKETLOSS) < 0.2;*/
    }
    
    // return the possibility of data communication between node A and node B
    public boolean dataCom(Network nw, int A, int B) {
		return nw.getConnection(A, B) > 3;
		/*return nw.readCell(A, B, nw.LATENCY) < 70
			&& nw.readCell(A, B, nw.BANDWIDTH) > 300
			&& nw.readCell(A, B, nw.PACKETLOSS) < 0.3;*/
    }

    // return the possibility of communication between node A and node B
    // purely based on distance
    public boolean distCom(Network nw, int A, int B) {
		Position p1 = nw.getPosition(A);
		Position p2 = nw.getPosition(B);

		double x_dist = Math.abs(p1.x - p2.x);
		double y_dist = Math.abs(p1.y - p2.y);
		double dist = Math.sqrt(Math.pow(x_dist, 2) + Math.pow(y_dist, 2));

		return dist < DISTANCE;
    }
}
