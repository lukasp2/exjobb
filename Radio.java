public class Radio {
    public static int DISTANCE = 15;
    
    // defines on which sheets in the excel document the different values are
    private static final int LATENCY = 0;
    private static final int BANDWIDTH = 1;
    private static final int PACKETLOSS = 2;
    
    // defines which communication type is currently used in the graph
    private static int comType;

    public static void setCom(int i) {
	comType = i;
    }

    public static boolean Com(ExcelSim excelRW, int A, int B) {
	switch (comType) {
	case 0:
	    return voiceCom(excelRW, A, B);
	case 1:
	    return dataCom(excelRW, A, B);
	case 2:
	    return distCom(excelRW, A, B);
	}
	return false;
    }
    
    // return the possibility of voice communication between node A and node B
    public static boolean voiceCom(ExcelSim excelRW, int A, int B) {
	return excelRW.readCell(A, B, LATENCY) < 50
	    && excelRW.readCell(A, B, BANDWIDTH) > 500
	    && excelRW.readCell(A, B, PACKETLOSS) < 0.7;
    }
    
    // return the possibility of data communication between node A and node B
    public static boolean dataCom(ExcelSim excelRW, int A, int B) {
	return excelRW.readCell(A, B, LATENCY) < 1000
	    && excelRW.readCell(A, B, BANDWIDTH) > 0.01
	    && excelRW.readCell(A, B, PACKETLOSS) < 0.3;
    }

    // return the possibility of communication between node A and node B
    // purely based on distance
    public static boolean distCom(ExcelSim excelRW, int A, int B) {
	Position p1 = excelRW.getPosition(A);
	Position p2 = excelRW.getPosition(B);

	double x_dist = Math.abs(p1.x - p2.x);
	double y_dist = Math.abs(p1.y - p2.y);
	double dist = Math.sqrt(Math.pow(x_dist, 2) + Math.pow(y_dist, 2));

	return dist < DISTANCE;
    }
}
