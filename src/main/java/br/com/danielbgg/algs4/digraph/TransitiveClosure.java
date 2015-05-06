package br.com.danielbgg.algs4.digraph;

/**
 * all-pairs reachability
 * 
 * All-pairs reachability. Given a digraph, support queries of the form Is there
 * a directed path from a given vertex v to another given vertex w?
 * 
 * Definition. The transitive closure of a digraph G is another digraph with the
 * same set of vertices, but with an edge from v to w in the transitive closure
 * if and only if w is reachable from v in G.
 */
public class TransitiveClosure {

	private DirectedDFS[] all;

	public TransitiveClosure(Digraph G) {
		all = new DirectedDFS[G.V()];
		for (int v = 0; v < G.V(); v++) {
			all[v] = new DirectedDFS(G, v);
		}
	}

	public boolean reachable(int v, int w) {
		return all[v].marked(w);
	}

}
