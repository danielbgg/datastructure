package br.com.danielbgg.algs4.digraph;

import java.util.Stack;

/**
 * precedence-constrained scheduling
 * 
 * topological sort
 * 
 * This DepthFirstOrder and DirectedCycle client returns a topological order for
 * a DAG. The test client solves the precedence-constrained scheduling problem
 * for a SymbolDigraph. The instance method order() returns null if the given
 * digraph is not a DAG and an iterator giving the vertices in topological order
 * otherwise. The code for SymbolDigraph is omitted because it is precisely the
 * same as for SymbolGraph (page 552), with Digraph replacing Graph everywhere.
 * 
 * Precedence-constrained scheduling. Given a set of jobs to be completed, with
 * precedence constraints that specify that certain jobs have to be completed
 * before certain other jobs are begun, how can we schedule the jobs such that
 * they are all completed while still respecting the constraints? For any such
 * problem, a digraph model is immediate, with vertices corresponding to jobs
 * and directed edges corresponding to precedence constraints. For economy, we
 * switch the example to our standard model with vertices labeled as integers,
 * as shown at left. In digraphs, precedence-constrained scheduling amounts to
 * the following fundamental problem:
 * 
 * Topological sort. Given a digraph, put the vertices in order such that all
 * its directed edges point from a vertex earlier in the order to a vertex later
 * in the order (or report that doing so is not possible).
 */
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
