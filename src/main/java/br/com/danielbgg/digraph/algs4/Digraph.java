package br.com.danielbgg.digraph.algs4;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * Definition. A directed graph (or digraph) is a set of vertices and a
 * collection of directed edges. Each directed edge connects an ordered pair of
 * vertices.
 * 
 * Definition. A directed path in a digraph is a sequence of vertices in which
 * there is a (directed) edge pointing from each vertex in the sequence to its
 * successor in the sequence. A directed cycle is a directed path with at least
 * one edge whose first and last vertices are the same. A simple cycle is a
 * cycle with no repeated edges or vertices (except the requisite repetition of
 * the first and last vertices). The length of a path or a cycle is its number
 * of edges.
 */
public class Digraph {

	private final int V;
	private int E;
	private Bag<Integer>[] adj;

	public Digraph(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < V; v++)
			adj[v] = new Bag<Integer>();
	}

	public Digraph(In in) {
		this(in.readInt());
		int E = in.readInt();
		for (int i = 0; i < E; i++) {
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v, w);
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
		E++;
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	public Digraph reverse() {
		Digraph R = new Digraph(V);
		for (int v = 0; v < V; v++)
			for (int w : adj(v))
				R.addEdge(w, v);
		return R;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		String NEWLINE = System.getProperty("line.separator");
		s.append(V + " vertices, " + E + " edges " + NEWLINE);
		for (int v = 0; v < V; v++) {
			s.append(v + ": ");
			for (int w : adj[v]) {
				s.append(w + " ");
			}
			s.append(NEWLINE);
		}
		return s.toString();
	}
}