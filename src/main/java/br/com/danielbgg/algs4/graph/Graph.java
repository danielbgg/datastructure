package br.com.danielbgg.algs4.graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * Definition. A graph is a set of vertices and a collection of edges that each
 * connect a pair of vertices.
 * 
 * Definition. A path in a graph is a sequence of vertices connected by edges. A
 * simple path is one with no repeated vertices. A cycle is a path with at least
 * one edge whose first and last vertices are the same. A simple cycle is a
 * cycle with no repeated edges or vertices (except the requisite repetition of
 * the first and last vertices). The length of a path or a cycle is its number
 * of edges.
 * 
 * Definition. A graph is connected if there is a path from every vertex to
 * every other vertex in the graph. A graph that is not connected consists of a
 * set of connected components, which are maximal connected subgraphs.
 * 
 * This Graph implementation maintains a vertex-indexed array of lists of
 * integers. Every edge appears twice: if an edge connects v and w, then w
 * appears in v’s list and v appears in w's list. The second constructor reads a
 * graph from an input stream, in the format V followed by E followed by a list
 * of pairs of int values between 0 and V-1.
 */
public class Graph {

	private final int V;
	private int E;

	// adjacent list of integers
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

	public int V() {
		return V;
	}

	public int E() {
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
		for (int i = 0; i < G.V(); i++) {
			int val = degree(G, i);
			if (val > max) {
				max = val;
			}
		}
		return max;
	}

	public static int avgDegree(Graph G) {
		return 2 * G.E() / G.V();
	}

	public static int numberOfSelfLoops(Graph G) {
		int count = 0;
		for (int v = 0; v < G.V(); v++) {
			for (int w : G.adj(v)) {
				if (v == w) {
					count++;
				}
			}
		}
		return count / 2;
	}

}
