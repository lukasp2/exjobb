public class Radio {

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
	    && excelRW.readCell(A, B, PACKETLOSS) < 0.1;
    }
}
