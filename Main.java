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
        ExcelRW excelfile = new ExcelRW("./file.xlsx");

	// create the radio functions
	Radio radio = new Radio();

	// .. following part is looped when a new request comes in .. //
	
	// sets a specified path function
	pathFunc = radio.voiceCom();
	
	// creates adjecency matrix - Graph(pathFunction);
	Graph graph = new Graph(excelfile, pathFunc);
	
	// perform bfs search in the graph for a path between A and B!
	graph.bfs(fromNode, toNode);

	// ... //
    }
}
