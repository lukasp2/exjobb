// input:
// - data every second from excel document
// - a pair of nodes which requests communication

// ideas:
// §1. cache the previous connections?
// §2. this program opens a filestream and then runs another program which reads
//     the excel file and updates the graph. This subprogram is then called each
//     time that the excel file is updated. See $ man entr.

public class Main {
    public static void main(String args[]) {

	// open the excel file
        // ExcelRW excelRW = new ExcelRW("./file.xlsx");
	ExcelSim excelSim = new ExcelSim();
	
	// create the radio functions
	Radio radio = new Radio();

	excelSim.generateSheets();
	excelSim.printSheets();
	int communication_type = excelSim.getCom();
	int[] to_from_node = excelSim.getNodes();
	System.out.println("Seeking path between node " + to_from_node[0] + " and " + to_from_node[1] + "\n");
	
	// .. following part is looped when a new request comes in .. //
	// set communication type to voice e.g.
	radio.setCom(communication_type);
	
	// creates adjecency matrix - Graph(pathFunction);
	// Graph graph = new Graph(excelRW, radio);
	Graph graph = new Graph(excelSim, radio);
	graph.printNeighbours();
	
	// perform bfs search in the graph for a path between A and B!
	graph.bfs(graph.nodes.get(to_from_node[0]), graph.nodes.get(to_from_node[1]));
	
	// ... //
    }
}
