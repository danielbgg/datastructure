package br.com.danielbgg.algs4.digraph;

import java.util.Stack;

/**
 * single-source directed paths
 * 
 * Single-source directed paths. Given a digraph and a source vertex s, support
 * queries of the form Is there a directed path from s to a given target vertex
 * v? If so, find such a path.
 */
public class DepthFirstDirectedPaths {

	// has dfs been called for this vertex?
	private boolean[] marked;

	// last vertex known path to this vertex
	private int[] edgeTo;

	// source
	private final int s;

	public DepthFirstDirectedPaths(Digraph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G, s);
	}

	private void dfs(Digraph G, int v) {
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
