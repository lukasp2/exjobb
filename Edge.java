public class Edge {

    Edge(float latency, float bandwidth, int packet_loss) {}
    
    // in milliseconds
    float latency;

    // in Mb/s
    float bandwidth;

    // a percentage (0 .. 1)
    int packet_loss;
}
