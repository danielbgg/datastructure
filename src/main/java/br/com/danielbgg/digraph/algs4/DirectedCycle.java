package br.com.danielbgg.digraph.algs4;

import java.util.Stack;

/**
 * directed cycle detection
 * 
 * This class adds to our standard recursive dfs() a boolean array onStack[] to
 * keep track of the vertices for which the recursive call has not completed.
 * When it finds an edge v->w to a vertex w that is on the stack, it has
 * discovered a directed cycle, which it can recover by following edgeTo[]
 * links.
 * 
 * Directed cycle detection. Does a given digraph have a directed cycle? If so,
 * find the vertices on some such cycle, in order from some vertex back to
 * itself.
 */
public class DirectedCycle {

	private boolean[] marked;

	private int[] edgeTo;

	// vertices on a cycle (if one exists)
	private Stack<Integer> cycle;

	// vertices on recursive call stack
	private boolean[] onStack;

	public DirectedCycle(Digraph G) {
		onStack = new boolean[G.V()];
		edgeTo = new int[G.V()];
		marked = new boolean[G.V()];
		for (int v = 0; v < G.V(); v++)
			if (!marked[v])
				dfs(G, v);
	}

	private void dfs(Digraph G, int v) {
		onStack[v] = true;
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (this.hasCycle()) {
				return;
			} else if (!marked[w]) {
				edgeTo[w] = v;
				dfs(G, w);
			} else if (onStack[w]) {
				cycle = new Stack<Integer>();
				for (int x = v; x != w; x = edgeTo[x]) {
					cycle.push(x);
				}
				cycle.push(w);
				cycle.push(v);
			}
		}
		onStack[v] = false;
	}

	public boolean hasCycle() {
		return cycle != null;
	}

	public Iterable<Integer> cycle() {
		return cycle;
	}
}
