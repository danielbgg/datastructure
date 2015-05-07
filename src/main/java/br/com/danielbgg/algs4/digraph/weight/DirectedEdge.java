package br.com.danielbgg.algs4.digraph.weight;

/**
 * This DirectedEdge implementation is simpler than the undirected weighted Edge
 * implementation of Section 4.3 (see page 610) because the two vertices are
 * distinguished. Our clients use the idiomatic code int v = e.to(), w =
 * e.from(); to access a DirectedEdge e’s two vertices.
 */
public class DirectedEdge {

	// edge source
	private final int v;

	// edge target
	private final int w;

	// edge weight
	private final double weight;

	public DirectedEdge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public double weight() {
		return weight;
	}

	public int from() {
		return v;
	}

	public int to() {
		return w;
	}

	public String toString() {
		return String.format("[%d->%d] %.2f", v, w, weight);
	}
}