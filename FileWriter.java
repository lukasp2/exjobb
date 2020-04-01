import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.nio.file.*;
import java.io.IOException;
import java.nio.charset.*;
import java.util.Arrays;

// to automatically run: $echo plotter.py | entr -p ./plotter.py

public class FileWriter {

    private static void write(String filename, List<String> lines, boolean append) {
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
    
    public static void writeHeader() {
	List<String> lines = new ArrayList<String>();
	lines.add("#!/usr/bin/env python3\nimport matplotlib.pyplot as plt\na=[");
	write("plotter.py", lines, false);
    }
    
    public static void writeList(List<String> lines) {
	write("plotter.py", lines, true);
    }
    
    public static void writeResult(Map<Integer, Integer> steps, ArrayList<Graph.Node> nodes, int goal) {
	List<String> lines = new ArrayList<String>();
	    
	int curr = goal;
	while (steps.get(curr) != -1) {
	    double x1 = nodes.get(curr).position.x;
	    double y1 = nodes.get(curr).position.y;
	    curr = steps.get(curr);
	    double x2 = nodes.get(curr).position.x;
	    double y2 = nodes.get(curr).position.y;

	    lines.add("plt.plot([" + x1 + ", "+ x2 + "],"
		      + "[" + y1 + ", " + y2 + "], 'g')");
	}

	lines.add("plt.plot(*zip(*a), marker='o', color='k', ls='')");
	lines.add("plt.show()");

	writeList(lines);
    }
}
