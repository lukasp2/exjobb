public class Request {
    private int comType;
    private int toNode;
    private int fromNode;

    Request(int to_node, int from_node, int comType) {
	this.toNode = to_node;
	this.fromNode = from_node;
	this.comType = comType;
    }

    public int getComType() {
	return comType;
    }
    
    public int getToNode() {
	return toNode;
    }
    
    public int getFromNode() {
	return fromNode;
    }

    public void print() {
	System.out.println("[" + comType + ": " + toNode + "->" + fromNode + "] ");
    }
}
    
