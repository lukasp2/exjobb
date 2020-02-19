public class Edge {

    // in milliseconds
    float latency;

    // in Mb/s
    float bandwidth;

    // decimal = [0 .. 1]
    int packet_loss;

    Edge(float latency, float bandwidth, int packet_loss) {
	this.latency = latency;
	this.bandwidth = bandwidth;
	this.packet_loss = packet_loss;
    }
}
