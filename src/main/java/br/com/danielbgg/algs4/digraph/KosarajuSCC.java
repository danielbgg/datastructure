package br.com.danielbgg.algs4.digraph;

import edu.princeton.cs.algs4.Bag;

/**
 * strong connectivity
 * 
 * This implementation differs from CC (Algorithm 4.3) only in the highlighted
 * code (and in the implementation of main() where we use the code on page 543,
 * with Graph changed to Digraph,, and CC changed to KosarajuSCC). To find
 * strong components, it does a depth-first search in the reverse digraph to
 * produce a vertex order (reverse postorder of that search) for use in a
 * depth-first search of the given digraph.
 * 
 * Definition. Two vertices v and w are strongly connected if they are mutually
 * reachable: that is, if there is a directed path from v to w and a directed
 * path from w to v. A digraph is strongly connected if all its vertices are
 * strongly connected to one another.
 * 
 * Reflexive : Every vertex v is strongly connected to itself.
 * 
 * Symmetric : If v is strongly connected to w, then w is strongly connected to
 * v.
 * 
 * Transitive : If v is strongly connected to w and w is strongly connected to
 * x, then v is also strongly connected to x.
 * 
 * Strong connectivity. Given a digraph, support queries of the form: Are two
 * given vertices strongly connected ? and How many strong components does the
 * digraph have ?
 */
public class KosarajuSCC {

	private Digraph G;

	// reached vertices
	private boolean[] marked;

	// component identifiers
	private int[] id;

	// number of strong components
	private int count;

	public KosarajuSCC(Digraph G) {
		this.G = G;
		marked = new boolean[G.V()];
		id = new int[G.V()];
		DepthFirstOrder order = new DepthFirstOrder(G.reverse());
		for (int s : order.reversePost()) {
			if (!marked[s]) {
				dfs(G, s);
				count++;
			}
		}
	}

	private void dfs(Digraph G, int v) {
		marked[v] = true;
		id[v] = count;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
	}

	public boolean stronglyConnected(int v, int w) {
		return id[v] == id[w];
	}

	public int id(int v) {
		return id[v];
	}

	public int count() {
		return count;
	}

	public Bag<Integer>[] components() {
		Bag<Integer>[] components = new Bag[count];
		for (int i = 0; i < count; i++)
			components[i] = new Bag<Integer>();
		for (int v = 0; v < G.V(); v++)
			components[id(v)].add(v);
		return components;
	}

}
