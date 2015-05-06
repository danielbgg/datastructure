package br.com.danielbgg.algs4.digraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * depth-first vertex orders
 * 
 * This class enables clients to iterate through the vertices in various orders
 * defined by depth-first search. This ability is very useful in the development
 * of advanced digraph-processing algorithms, because the recursive nature of
 * the search enables us to prove properties of the computation (see, for
 * example, Proposition F).
 * 
 * Proposition E. A digraph has a topological order if and only if it is a DAG.
 * Proof: If the digraph has a directed cycle, it has no topological order.
 * Conversely, the algorithm that we are about to examine computes a topological
 * order for any given DAG.
 * 
 * Preorder : Put the vertex on a queue before the recursive calls.
 * 
 * Postorder : Put the vertex on a queue after the recursive calls.
 * 
 * Reverse postorder : Put the vertex on a stack after the recursive calls.
 */
public class DepthFirstOrder {

	private boolean[] marked;
	// vertices in preorder
	private Queue<Integer> pre;
	// vertices in postorder
	private Queue<Integer> post;
	// vertices in reverse postorder
	private Stack<Integer> reversePost;

	public DepthFirstOrder(Digraph G) {
		pre = new LinkedList<Integer>();
		post = new LinkedList<Integer>();
		reversePost = new Stack<Integer>();
		marked = new boolean[G.V()];
		for (int v = 0; v < G.V(); v++) {
			if (!marked[v]) {
				dfs(G, v);
			}
		}
	}

	private void dfs(Digraph G, int v) {
		pre.add(v);
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
		post.add(v);
		reversePost.add(v);
	}

	public Queue<Integer> pre() {
		return pre;
	}

	public Queue<Integer> post() {
		return post;
	}

	public Stack<Integer> reversePost() {
		return reversePost;
	}
}
