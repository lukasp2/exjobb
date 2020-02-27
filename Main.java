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
	excelSim.printSheets();
	
	// create the radio functions
	Radio radio = new Radio();

	// .. following part is looped when a new request comes in .. //
	// set communication type to voice e.g.
	radio.setCom(0);
	
	// creates adjecency matrix - Graph(pathFunction);
	// Graph graph = new Graph(excelRW, radio);
	Graph graph = new Graph(excelSim, radio);
	graph.printNeighbours();
	
	// perform bfs search in the graph for a path between A and B!
	graph.bfs(graph.nodes.get(0), graph.nodes.get(1));
	
	// ... //
    }
}
