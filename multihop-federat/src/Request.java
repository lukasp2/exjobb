import java.util.Random;

public class Request {
    private final int comType;
    private final int toNode;
    private final int fromNode;
    private final long transactionID;

    Request(int fromNode, int toNode, int comType, long transactionID) {
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.comType = comType;
        this.transactionID = transactionID;
    }

    public int getRequestType() {
        return comType;
    }
    
    public int getToNode() {
	    return toNode;
    }
    
    public int getFromNode() {
	    return fromNode;
    }

    public long getTransactionID() {
        return transactionID;
    }

    public String toString() { return "[" + comType + ": " + toNode + "->" + fromNode + "]"; }


}
    
