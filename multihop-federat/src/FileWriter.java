import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.ArrayList;
import java.nio.file.*;
import java.io.IOException;
import java.nio.charset.*;
import java.util.Arrays;

public class FileWriter {

    public void write(String filename, List<String> lines, boolean append) {
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

		write("plotter.py", lines, false);
    }

    // writes all points and names of the points
    public void writePoints(List<Position> positions) {
		List<String> lines = new ArrayList<String>();

		// write the points
		lines.add("a=[");
		for (Position pos : positions) {
			lines.add("[" + pos.x + ", " + pos.y + "],");
		}
		lines.add("]\n");

		lines.add("plt.plot(*zip(*a), marker='o', color='k', ls='')\n");

		// write the id of each node above it
		for (int i = 0; i < positions.size(); ++i) {
			double x = positions.get(i).x + 1;
			double y = positions.get(i).y + 1;

			lines.add("plt.text(" + x + ", " + y + ", "
				  + i + ", "
				  + "bbox=dict(facecolor='red', alpha=0.1), "
				  + "fontsize=10" + ")");
		}

		lines.add("");
		//write("plotter.py", lines, true);
    }

    // writes one line
    public void writeLine(double x1, double y1, double x2, double y2, char color) {
		List<String> lines = new ArrayList<String>();

		lines.add("plt.plot(["
			  + x1 + ", " + x2 + "], ["
			  + y1 + ", " + y2 + "], '" + color + "' )");

		double x_dist = Math.abs(x1 - x2);
		double y_dist = Math.abs(y1 - y2);
		double dist = Math.sqrt(Math.pow(x_dist, 2) + Math.pow(y_dist, 2));

		double pos_x = (x1 + x2) / 2;
		double pos_y = (y1 + y2) / 2;

		// write the length of each connection
		//lines.add("plt.text(" + pos_x + ", " + pos_y + ", " + Math.round(dist) + ", " + "fontsize=6" + ")");

		write("plotter.py", lines, true);
    }
    
    public void writeResult(Map<Integer, Integer> steps, ArrayList<Graph.Node> nodes, int goal) {
		List<String> pathLines = new ArrayList<String>();
		List<String> neighbourLines = new ArrayList<String>();
		List<String> lines = new ArrayList<String>();

		if (!steps.containsKey(goal)) {
			lines.add("plt.show()");
			write("plotter.py", lines, true);
			return;
		}

		int curr = goal;
		while (steps.get(curr) != -1) {
			double x1 = nodes.get(curr).position.x;
			double y1 = nodes.get(curr).position.y;
			curr = steps.get(curr);
			double x2 = nodes.get(curr).position.x;
			double y2 = nodes.get(curr).position.y;

			pathLines.add("\tplt.pause(0.1)");
			pathLines.add("\tplt.plot(["+x1+", "+x2+"], ["+y1+", "+y2+"], 'r' )");
			neighbourLines.add("\tplt.plot(["+x1+", "+x2+"], ["+y1+", "+y2+"], 'g' )");
		}

		Collections.reverse(pathLines);

		lines.add("\nwhile True:");
		lines.add("\tplt.pause(0.2)");

		write("plotter.py", lines, true);
		write("plotter.py", pathLines, true);
		write("plotter.py", neighbourLines, true);
    }

	public void writeNonActiveResult(Map<Integer, Integer> steps, ArrayList<Graph.Node> nodes, int goal) {
		List<String> lines = new ArrayList<String>();

		int curr = goal;
		while (steps.get(curr) != -1) {
			double x1 = nodes.get(curr).position.x;
			double y1 = nodes.get(curr).position.y;
			curr = steps.get(curr);
			double x2 = nodes.get(curr).position.x;
			double y2 = nodes.get(curr).position.y;

			lines.add("plt.plot(["+x1+", "+x2+"], ["+y1+", "+y2+"], 'r' )");
		}

		lines.add("plt.show()");
		write("plotter.py", lines, true);
	}
}
