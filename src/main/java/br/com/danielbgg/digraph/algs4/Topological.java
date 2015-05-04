package br.com.danielbgg.digraph.algs4;

import java.util.Stack;

public class Topological {

	private Stack<Integer> order;

	public Topological(Digraph G) {
		DirectedCycle c = new DirectedCycle(G);
		if (!c.hasCycle()) {
			DepthFirstOrder dfs = new DepthFirstOrder(G);
			order = dfs.reversePost();
		}
	}

	public Stack<Integer> getOrder() {
		return order;
	}

	public boolean isDAG() {
		return order != null;
	}

}
