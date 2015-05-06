package br.com.danielbgg.algs4.digraph;

/**
 * single- and multiple-source reachability
 * 
 * This implementation of depth-first search provides clients the ability to
 * test which vertices are reachable from a given vertex or a given set of
 * vertices.
 * 
 * Single-source reachability. Given a digraph and a source vertex s, support
 * queries of the form Is there a directed path from s to a given target vertex
 * v?
 * 
 * Multiple-source reachability. Given a digraph and a set of source vertices,
 * support queries of the form Is there a directed path from any vertex in the
 * set to a given target vertex v?
 * 
 * Proposition D. DFS marks all the vertices in a digraph reachable from a given
 * set of sources in time proportional to the sum of the outdegrees of the
 * vertices marked.
 */
public class DirectedDFS {

	private boolean[] marked;

	public DirectedDFS(Digraph G, int s) {
		marked = new boolean[G.V()];
		dfs(G, s);
	}

	public DirectedDFS(Digraph G, Iterable<Integer> sources) {
		marked = new boolean[G.V()];
		for (int s : sources)
			if (!marked[s])
				dfs(G, s);
	}

	private void dfs(Digraph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v))
			if (!marked[w])
				dfs(G, w);
	}

	public boolean marked(int v) {
		return marked[v];
	}

}