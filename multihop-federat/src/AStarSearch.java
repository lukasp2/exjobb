import java.util.*;

public class AStarSearch {

    private final int MAX_HOPS = 10;

    // for plotting graph
    public Plotter plotter = new Plotter();

    public AStarSearch(Network network) {
        this.network = network;
    }

    private Graph.Node start;

    private Graph.Node goal;

    public Network network;

    public ArrayList<Integer> search(GraphList graphs, Request request) {
        Graph graph = graphs.get(request.getRequestType());

        start = graph.nodes.get(request.getFromNode());
        goal = graph.nodes.get(request.getToNode());

        PriorityQueue<Graph.Node> prioQueue = new PriorityQueue<>(distanceComparator);
        //PriorityQueue<Graph.Node> prioQueue = new PriorityQueue<>(signalQualityComparator);
        //PriorityQueue<Graph.Node> prioQueue = new PriorityQueue<>(randomComparator);

        prioQueue.add(start);

        Path path = new Path();
        path.addStep(start.id, -1);

        start.visited = true;
        start.previous_node = start;

        while (!prioQueue.isEmpty()) {
            Graph.Node curr = prioQueue.poll();

            if (MultihopSimulator.PLOT) {  plotter.writeLine(curr.position.x, curr.position.y,
                    curr.previous_node.position.x, curr.previous_node.position.y, "firebrick"); }

            if (curr.hops < MAX_HOPS) {
                List<Graph.Node> neighbours = curr.getNeighbours();

                if (neighbours.contains(goal)) {
                    path.addStep(goal.id, curr.id);
                    break;
                }

                for (Graph.Node neighbour : neighbours) {
                    if (neighbour != null && !neighbour.visited) {
                        prioQueue.add(neighbour);
                        neighbour.visited = true;
                        path.addStep(neighbour.id, curr.id);
                        neighbour.hops = curr.hops + 1;
                        neighbour.previous_node = curr;
                    }
                }
            }
        }

        return path.getPath(goal.id);
    }

    // heuristic based on distance to the goal
    Comparator<Graph.Node> distanceComparator = (n1, n2) -> {
        double n1dx = Math.abs(n1.position.x - goal.position.x);
        double n1dy = Math.abs(n1.position.y - goal.position.y);
        double n1dist = Math.sqrt(Math.pow(n1dx, 2) + Math.pow(n1dy, 2));

        double n2dx = Math.abs(n2.position.x - goal.position.x);
        double n2dy = Math.abs(n2.position.y - goal.position.y);
        double n2dist = Math.sqrt(Math.pow(n2dx, 2) + Math.pow(n2dy, 2));

        if (n1dist > n2dist)
            return 1;
        else
            return -1;
    };

    // heuristic based on signal quality to the goal
    Comparator<Graph.Node> signalQualityComparator = (n1, n2) -> {
        double n1S = network.getConnection(n1.id, goal.id);
        double n2S = network.getConnection(n2.id, goal.id);

        if (n1S > n2S)
            return 1;
        else
            return -1;
    };

    // heuristic based on signal quality to the goal
    Comparator<Graph.Node> randomComparator = (n1, n2) -> {
        Random random = new Random();
        int b = random.nextInt(2) + 1;
        return (int) (b  - 2);
    };

    // defines the graph traversal path
    class Path {
        Path() { }
        private final Map<Integer, Integer> steps = new HashMap<>();

        public void addStep(int me, int prev) {
            steps.put(me, prev);
        }

        public ArrayList<Integer> getPath(int goal) {
            ArrayList<Integer> path = new ArrayList<>();

            if (steps.containsKey(goal)) {
                int curr = goal;
                while (steps.get(curr) != -1) {
                    path.add(curr);
                    curr = steps.get(curr);
                }
                path.add(curr);
            }

            return path;
        }
    }
}
