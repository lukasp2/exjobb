import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.ArrayList;
import java.nio.file.*;
import java.io.IOException;
import java.nio.charset.*;
import java.util.Arrays;

public class Plotter {

	private final boolean PLOT_NODES = true;
	private final boolean PLOT_EDGE_WEIGHT = false;

	private final String edge_color = "silver";
	private final String traversed_color = "limegreen";
	private final String explored_color = "firebrick";

	private final String filename = "plotter.py";

	public void write(List<String> lines, boolean append) {
		try {
			if (append) {
				Files.write(Paths.get(filename), lines, StandardCharsets.UTF_8,
						StandardOpenOption.CREATE,
						StandardOpenOption.APPEND);
			}
			else {
				Files.write(Paths.get(filename), lines, StandardCharsets.UTF_8);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void writeHeader() {
		List<String> lines = new ArrayList<String>();
		lines.add("#!/usr/bin/env python3");
		lines.add("import matplotlib.pyplot as plt\n");

		write(lines, false);
    }

    // plots all nodes and names of the nodes
    public void writePoints(List<Position> positions) {
		List<String> lines = new ArrayList<String>();

		// plot the nodes
		lines.add("a=[");
		for (Position pos : positions) {
			lines.add("[" + pos.x + ", " + pos.y + "],");
		}
		lines.add("]\n");

		if (PLOT_NODES)
			lines.add("plt.plot(*zip(*a), marker='o', color='k', ls='')\n");

		// plots the id of each node above it
		for (int i = 0; i < positions.size(); ++i) {
			double x = positions.get(i).x + 1;
			double y = positions.get(i).y + 1;

			lines.add("plt.text(" + x + ", " + y + ", "
				  + i + ", "
				  + "bbox=dict(facecolor='red', alpha=0.1), "
				  + "fontsize=10" + ")");
		}

		lines.add("");
		write(lines, true);
    }

    // plots one line
    public void writeLine(double x1, double y1, double x2, double y2, String color) {
		List<String> lines = new ArrayList<String>();

		lines.add("plt.plot(["
			  + x1 + ", " + x2 + "], ["
			  + y1 + ", " + y2 + "], '" + color + "')");

		double x_dist = Math.abs(x1 - x2);
		double y_dist = Math.abs(y1 - y2);
		double dist = Math.sqrt(Math.pow(x_dist, 2) + Math.pow(y_dist, 2));

		double pos_x = (x1 + x2) / 2;
		double pos_y = (y1 + y2) / 2;

		//write the length of each connection
		if (PLOT_EDGE_WEIGHT)
			lines.add("plt.text(" + pos_x + ", " + pos_y + ", " + Math.round(dist) + ", " + "fontsize=6" + ")");

		write(lines, true);
    }

	public void writeResult(Graph graph, ArrayList<Integer> intPath) {
		List<String> lines = new ArrayList<String>();

		for (int i = 1; i < intPath.size(); ++i) {
			double x1 = graph.nodes.get(intPath.get(i-1)).position.x;
			double y1 = graph.nodes.get(intPath.get(i-1)).position.y;

			double x2 = graph.nodes.get(intPath.get(i)).position.x;
			double y2 = graph.nodes.get(intPath.get(i)).position.y;

			lines.add("plt.plot(["+x1+", "+x2+"], ["+y1+", "+y2+"], '" + traversed_color + "')");
		}

		lines.add("plt.savefig(\"graph.svg\")");
		lines.add("plt.show()");

		write(lines, true);
	}

	public void plotGraph(Graph graph) {
		writeHeader();

		List<String> lines = new ArrayList<String>();

		// write nodes
		lines.add("a=[");
		for (Graph.Node node : graph.nodes) {
			lines.add("[" + node.position.x + ", " + node.position.y + "],");
		}
		lines.add("]\n");

		if (PLOT_NODES)
			lines.add("plt.plot(*zip(*a), marker='o', color='k', ls='')\n");

		lines.add("");
		write(lines, true);

		// write edges
		for (Graph.Node node : graph.nodes) {
			for (Graph.Node neighbour : node.getNeighbours()) {
				writeLine(node.position.x, node.position.y, neighbour.position.x, neighbour.position.y, edge_color);
			}
		}
	}
}
