package br.com.danielbgg.algs4.graph.weight;

/**
 * This data type provides the methods either() and other() so that such clients
 * can use other(v) to find the other vertex when it knows v. When neither
 * vertex is known, our clients use the idiomatic code int v = e.either(), w =
 * e.other(v); to access an Edge e's two vertices.
 */
public class Edge implements Comparable<Edge> {

	// one vertex
	private final int v;

	// the other vertex
	private final int w;

	// edge weight
	private final double weight;

	public Edge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public double weight() {
		return weight;
	}

	public int either() {
		return v;
	}

	public int other(int vertex) {
		if (vertex == v) {
			return w;
		} else if (vertex == w) {
			return v;
		} else {
			throw new RuntimeException("Inconsistent edge");
		}
	}

	public int compareTo(Edge that) {
		if (this.weight() < that.weight())
			return -1;
		else if (this.weight() > that.weight())
			return +1;
		else
			return 0;
	}

	public String toString() {
		return String.format("[%d-%d] %.2f", v, w, weight);
	}
}
