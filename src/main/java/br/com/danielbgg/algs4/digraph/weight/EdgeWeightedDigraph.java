package br.com.danielbgg.algs4.digraph.weight;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * This EdgeWeightedDigraph implementation is an amalgam of EdgeWeightedGraph
 * and Digraph that maintains a vertex-indexed array of bags of DirectedEdge
 * objects. As with Digraph, every edge appears just once: if an edge connects v
 * to w, it appears in v’s adjacency list. Self-loops and parallel edges are
 * allowed.
 */
public class EdgeWeightedDigraph {

	// number of vertices
	private final int V;

	// number of edges
	private int E;

	// adjacency lists
	private Bag<DirectedEdge>[] adj;

	public EdgeWeightedDigraph(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<DirectedEdge>[]) new Bag[V];
		for (int v = 0; v < V; v++)
			adj[v] = new Bag<DirectedEdge>();
	}

	public EdgeWeightedDigraph(In in) {
		this(in.readInt());
		int E = in.readInt();
		for (int i = 0; i < E; i++) {
			int v = in.readInt();
			int w = in.readInt();
			if (v < 0 || v >= V)
				throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V - 1));
			if (w < 0 || w >= V)
				throw new IndexOutOfBoundsException("vertex " + w + " is not between 0 and " + (V - 1));
			double weight = in.readDouble();
			addEdge(new DirectedEdge(v, w, weight));
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void addEdge(DirectedEdge e) {
		adj[e.from()].add(e);
		E++;
	}

	public Iterable<DirectedEdge> adj(int v) {
		return adj[v];
	}

	public Iterable<DirectedEdge> edges() {
		Bag<DirectedEdge> bag = new Bag<DirectedEdge>();
		for (int v = 0; v < V; v++)
			for (DirectedEdge e : adj[v])
				bag.add(e);
		return bag;
	}

	public String toString() {
		String NEWLINE = System.getProperty("line.separator");
		StringBuilder s = new StringBuilder();
		s.append(V + " " + E + NEWLINE);
		for (int v = 0; v < V; v++) {
			s.append(v + ": ");
			for (DirectedEdge e : adj[v]) {
				s.append(e + "  ");
			}
			s.append(NEWLINE);
		}
		return s.toString();
	}

}