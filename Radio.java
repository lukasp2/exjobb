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

    public static boolean Com(ExcelRW excelRW, int A, int B) {
	switch (comType) {
	case 0:
	    return voiceCom(excelRW, A, B);
	    break;
	case 1:
	    return dataCom(excelRW, A, B);
	    break;
	}
    }
    
    // return the possibility of voice communication between node A and node B
    public static boolean voiceCom(ExcelRW excelRW, int A, int B) {
	return excelRW.readCell(A, B, LATENCY) < 100
	    && excelRW.readCell(A, B, BANDWIDTH) > 1
	    && excelRW.readCell(A, B, PACKETLOSS) < 0.1;
    }
    
    // return the possibility of data communication between node A and node B
    public static boolean dataCom(ExcelRW excelRW, int A, int B) {
	return excelRW.readCell(A, B, LATENCY) < 1000
	    && excelRW.readCell(A, B, BANDWIDTH) > 0.01
	    && excelRW.readCell(A, B, PACKETLOSS) < 0.1;
    }
}
