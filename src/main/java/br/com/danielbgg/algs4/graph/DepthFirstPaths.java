package br.com.danielbgg.algs4.graph;

import java.util.Stack;

/**
 * single-source paths
 * 
 * This Graph client uses depth-first search to find paths to all the vertices
 * in a graph that are connected to a given start vertex s. Code from
 * DepthFirstSearch (page 531) is printed in gray. To save known paths to each
 * vertex, this code maintains a vertex-indexed array edgeTo[] such that
 * edgeTo[w] = v means that v-w was the edge used to access w for the first
 * time. The edgeTo[] array is a parent-link representation of a tree rooted at
 * s that contains all the vertices connected to s.
 * 
 * Proposition A (continued). DFS allows us to provide clients with a path from
 * a given source to any marked vertex in time proportional its length.
 * 
 * Proof: By induction on the number of vertices visited, it follows that the
 * edgeTo[] array in DepthFirstPaths represents a tree rooted at the source. The
 * pathTo() method builds the path in time proportional to its length.
 */
public class DepthFirstPaths {

	// has dfs been called for this vertex?
	private boolean[] marked;

	// last vertex known path to this vertex
	private int[] edgeTo;

	// source
	private final int s;

	public DepthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G, s);
	}

	private void dfs(Graph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				edgeTo[w] = v;
				dfs(G, w);
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
