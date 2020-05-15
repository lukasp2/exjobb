public class Request {
    private final int comType;
    private final int toNode;
    private final int fromNode;
    
    Request(int fromNode, int toNode, int comType) {
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.comType = comType;
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

    public void print() {
	System.out.println("request: [" + comType + ": " + toNode + "->" + fromNode + "] ");
    }
}
    
