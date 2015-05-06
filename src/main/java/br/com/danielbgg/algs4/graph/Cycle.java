package br.com.danielbgg.algs4.graph;

/**
 * cycle detection
 * 
 * Definition. A tree is an acyclic connected graph. A disjoint set of trees is
 * called a forest. A spanning tree of a connected graph is a subgraph that
 * contains all of that graph’s vertices and is a single tree. A spanning forest
 * of a graph is the union of spanning trees of its connected components.
 * 
 * Cycle detection. Support this query: Is a given graph acylic ?
 */
public class Cycle {

	private boolean[] marked;
	private boolean hasCycle;

	public Cycle(Graph G) {
		marked = new boolean[G.V()];
		for (int s = 0; s < G.V(); s++)
			if (!marked[s])
				dfs(G, s, s);
	}

	private void dfs(Graph G, int v, int u) {
		marked[v] = true;
		for (int w : G.adj(v))
			if (!marked[w])
				dfs(G, w, v);
			else if (w != u)
				hasCycle = true;
	}

	public boolean hasCycle() {
		return hasCycle;
	}
}