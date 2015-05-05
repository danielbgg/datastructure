package br.com.danielbgg.digraph.algs4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * single-source shortest directed paths
 * 
 * Single-source shortest directed paths. Given a digraph and a source vertex s,
 * support queries of the form Is there a directed path from s to a given target
 * vertex v? If so, find a shortest such path (one with a minimal number of
 * edges).
 */
public class BreadthFirstDirectedPaths {

	// is a shortest path to this vertex known?
	private boolean[] marked;

	// last vertex on known path to this vertex
	private int[] edgeTo;

	// source
	private final int s;

	public BreadthFirstDirectedPaths(Digraph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G, s);
	}

	private void bfs(Digraph G, int s) {
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
