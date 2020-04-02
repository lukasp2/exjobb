/*
 * ./plotter.py requires matplotlib to be installed
 * $ pip3 install matplotlib
 */

public class Main {
    public static void main(String args[]) {

	// open the excel file
        // ExcelRW excelRW = new ExcelRW("./file.xlsx");
	ExcelSim excelSim = new ExcelSim();
	
	// create the radio functions
	Radio radio = new Radio();

	excelSim.randomizeSheets();
	//excelSim.printSheets();
	int communication_type = excelSim.getCom();
	
	// .. following part is looped when a new request comes in .. //
	// set communication type to voice e.g.
	radio.setCom(communication_type);
	
	// creates adjecency matrix - Graph(pathFunction);
	// Graph graph = new Graph(excelRW, radio);
	Graph graph = new Graph(excelSim, radio);
	// graph.printNeighbours();

	int[] to_from_node = excelSim.getNodes();
	System.out.println("Seeking path between node "
			   + to_from_node[0] + " and " + to_from_node[1] + "\n");
	
	// performs BFS search in the graph
	// graph.bfs(graph.nodes.get(to_from_node[0]), graph.nodes.get(to_from_node[1]), 4);

	// performs A* search in the graph
	graph.aStar(graph.nodes.get(to_from_node[0]), graph.nodes.get(to_from_node[1]), 4);
	// ... //
    }
}
