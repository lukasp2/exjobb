public class Radio {

    // return the possibility of voice communication between A and B
    public static boolean voiceCom(Graph graph, node A, node B) {
	Edge edge = graph.getEdge(A, B);
	
	if ( edge.latency < 100
	     && edge.bandwidth > 1
	     && edge.packet_loss < 0.1 )
	{
	    return true;
	}
	
	return false;
    }
    
    // return the possibility of data communication between A and B
    public static boolean dataCom(Graph graph, node A, node B) {
	Edge edge = graph.getEdge(A, B);
	
	if ( edge.latency < 1000
	     && edge.bandwidth > 0.01
	     && edge.packet_loss < 0.1 )
	{
	    return true;
	}
	
	return false;
    }
}
