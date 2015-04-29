package br.com.danielbgg.graph.matrix;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class Graph {

	private final int V;
	private int E;
	private Bag<Integer>[] adj;

	public Graph(int V) {
		this.V = V;
		this.E = 0;
		this.adj = new Bag[V];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new Bag<Integer>();
		}
	}

	public Graph(In in) {
		this(in.readInt());
		int E = in.readInt();
		for (int i = 0; i < E; i++) {
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v, w);
		}
	}

	public int getV() {
		return V;
	}

	public int getE() {
		return E;
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}

	public Bag<Integer> adj(int v) {
		return adj[v];
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

	public static int degree(Graph G, int v) {
		int degree = 0;
		for (int w : G.adj(v)) {
			degree++;
		}
		return degree;
	}

	public static int maxDegree(Graph G) {
		int max = 0;
		for (int i = 0; i < G.getV(); i++) {
			int val = degree(G, i);
			if (val > max) {
				max = val;
			}
		}
		return max;
	}

	public static int avgDegree(Graph G) {
		return 2 * G.getE() / G.getV();
	}

	public static int numberOfSelfLoops(Graph G) {
		int count = 0;
		for (int v = 0; v < G.getV(); v++) {
			for (int w : G.adj(v)) {
				if (v == w) {
					count++;
				}
			}
		}
		return count / 2;
	}

}
