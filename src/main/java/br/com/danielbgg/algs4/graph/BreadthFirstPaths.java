package br.com.danielbgg.algs4.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * single-source shortest paths
 * 
 * Single-source shortest paths. Given a graph and a source vertex s, support
 * queries of the form Is there a path from s to a given target vertex v? If so,
 * find a shortest such path (one with a minimal number of edges).
 * 
 * This Graph client uses breadth-first search to find paths in a graph with the
 * fewest number of edges from the source s given in the constructor. The bfs()
 * method marks all vertices connected to s, so clients can use hasPathTo() to
 * determine whether a given vertex v is connected to s and pathTo() to get a
 * path from s to v with the property that no other such path from s to v has
 * fewer edges.
 * 
 * Proposition B. For any vertex v reachable from s, BFS computes a shortest
 * path from s to v (no path from s to v has fewer edges).
 * 
 * Proof: It is easy to prove by induction that the queue always consists of
 * zero or more vertices of distance k from the source, followed by zero or more
 * vertices of distance k+1 from the source, for some integer k, starting with k
 * equal to 0. This property implies, in particular, that vertices enter and
 * leave the queue in order of their distance from s. When a vertex v enters the
 * queue, no shorter path to v will be found before it comes off the queue, and
 * no path to v that is discovered after it comes off the queue can be shorter
 * than v’s tree path length.
 * 
 * Proposition B (continued). BFS takes time proportional to VE in the worst
 * case. Proof: As for Proposition A (page 531), BFS marks all the vertices
 * connected to s in time proportional to the sum of their degrees. If the graph
 * is connected, this sum is the sum of the degrees of all the vertices, or 2E.
 */
public class BreadthFirstPaths {

	// is a shortest path to this vertex known?
	private boolean[] marked;

	// last vertex on known path to this vertex
	private int[] edgeTo;

	// source
	private final int s;

	public BreadthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G, s);
	}

	private void bfs(Graph G, int s) {
		Queue<Integer> queue = new LinkedList<Integer>();
		marked[s] = true;
		queue.add(s);
		while (!queue.isEmpty()) {
			int v = queue.poll();
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					edgeTo[w] = v;
					marked[w] = true;
					queue.add(w);
				}
			}
		}
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public Stack<Integer> pathTo(int v) {
		if (!hasPathTo(v)) {
			return null;
		}
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x]) {
			path.push(x);
		}
		path.push(s);
		return path;
	}

}
