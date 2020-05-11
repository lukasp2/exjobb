public class Radio {
    public static int DISTANCE = 15;
    
    // defines which communication type is currently used in the graph
    private static int comType;

    public static void setCom(int i) {
	comType = i;
    }

    public static boolean Com(ExcelSim xmlRW, int A, int B) {
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
    public static boolean voiceCom(ExcelSim xmlRW, int A, int B) {
	return xmlRW.readCell(A, B, xmlRW.LATENCY) < 20
	    && xmlRW.readCell(A, B, xmlRW.BANDWIDTH) > 600
	    && xmlRW.readCell(A, B, xmlRW.PACKETLOSS) < 0.2;
    }
    
    // return the possibility of data communication between node A and node B
    public static boolean dataCom(ExcelSim xmlRW, int A, int B) {
	return xmlRW.readCell(A, B, xmlRW.LATENCY) < 70
	    && xmlRW.readCell(A, B, xmlRW.BANDWIDTH) > 300
	    && xmlRW.readCell(A, B, xmlRW.PACKETLOSS) < 0.3;
    }

    // return the possibility of communication between node A and node B
    // purely based on distance
    public static boolean distCom(ExcelSim xmlRW, int A, int B) {
	Position p1 = xmlRW.getPosition(A);
	Position p2 = xmlRW.getPosition(B);

	double x_dist = Math.abs(p1.x - p2.x);
	double y_dist = Math.abs(p1.y - p2.y);
	double dist = Math.sqrt(Math.pow(x_dist, 2) + Math.pow(y_dist, 2));

	return dist < DISTANCE;
    }
}
