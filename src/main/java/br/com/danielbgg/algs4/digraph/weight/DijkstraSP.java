package br.com.danielbgg.algs4.digraph.weight;

import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;

/**
 * Single-source shortest paths in undirected graphs. Given an edge-weighted
 * undirected graph and a source vertex s, support queries of the form Is there
 * a path from s to a given target vertex v? If so, find a shortest such path
 * (one whose total weight is minimal).
 * 
 * We begin by initializing dist[s] to 0 and all other distTo[] entries to
 * positive infinity, then we relax and add to the tree a non-tree vertex with
 * the lowest distTo[] value, continuing until all vertices are on the tree or
 * no non-tree vertex has a finite distTo[] value.
 * 
 * Proposition R. Dijkstra’s algorithm solves the single-source shortest-paths
 * problem in edge-weighted digraphs with nonnegative weights.
 * 
 * Proof: If v is reachable from the source, every edge v->w is relaxed exactly
 * once, when v is relaxed, leaving distTo[w] <= distTo[v] + e.weight(). This
 * inequality holds until the algorithm completes, since distTo[w] can only
 * decrease (any relaxation can only decrease a distTo[] value) and distTo[v]
 * never changes (because edge weights are nonnegative and we choose the lowest
 * distTo[] value at each step, no subsequent relaxation can set any distTo[]
 * entry to a lower value than distTo[v]). Thus, after all vertices reachable
 * from s have been added to the tree, the shortest-paths optimality conditions
 * hold, and Proposition P applies.
 * 
 * Proposition R (continued). Dijkstra’s algorithm uses extra space proportional
 * to V and time proportional to E log V (in the worst case) to compute the SPT
 * rooted at a given source in an edge-weighted digraph with E edges and V
 * vertices.
 * 
 * Proof: Same as for Prim’s algorithm (see Proposition N).
 * 
 * Source-sink shortest paths. Given an edge-weighted digraph, a source vertex
 * s, and a target vertex t, find the shortest path from s to t.
 * 
 * To solve this problem, use Dijkstra’s algorithm, but terminate the search as
 * soon as t comes off the priority queue.
 * 
 * Shortest paths in Euclidean graphs. Solve the single-source, source-sink, and
 * all-pairs shortest-paths problems in graphs where vertices are points in the
 * plane and edge weights are proportional to Euclidean distances between
 * vertices.
 * 
 * A simple modification considerably speeds up Dijkstra’s algorithm in this
 * case (see Exercise 4.4.27).
 * 
 * This implementation of Dijkstra’s algorithm grows the SPT by adding an edge
 * at a time, always choosing the edge from a tree vertex to a non-tree vertex
 * whose destination w is closest to s.
 */
public class DijkstraSP {

	private DirectedEdge[] edgeTo;
	private double[] distTo;
	private IndexMinPQ<Double> pq;

	public DijkstraSP(EdgeWeightedDigraph G, int s) {
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];
		pq = new IndexMinPQ<Double>(G.V());

		for (int v = 0; v < G.V(); v++) {
			distTo[v] = Double.POSITIVE_INFINITY;
		}

		distTo[s] = 0.0;

		pq.insert(s, 0.0);
		while (!pq.isEmpty()) {
			relax(G, pq.delMin());
		}
	}

	private void relax(EdgeWeightedDigraph G, int v) {
		for (DirectedEdge e : G.adj(v)) {
			int w = e.to();
			if (distTo[w] > distTo[v] + e.weight()) {
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				if (pq.contains(w)) {
					pq.change(w, distTo[w]);
				} else {
					pq.insert(w, distTo[w]);
				}
			}
		}
	}

	public double distTo(int v) {
		return distTo[v];
	}

	public boolean hasPathTo(int v) {
		return distTo[v] < Double.POSITIVE_INFINITY;
	}

	public Iterable<DirectedEdge> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
			path.push(e);
		return path;
	}

}
