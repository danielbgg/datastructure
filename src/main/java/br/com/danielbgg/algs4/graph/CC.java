package br.com.danielbgg.algs4.graph;

/**
 * connectivity
 * 
 * connected compontents in a graph
 * 
 * This Graph client provides its clients with the ability to independently
 * process a graph’s connected components. Code from DepthFirstSearch (page 531)
 * is left in gray. The computation is based on a vertex-indexed array id[] such
 * that id[v] is set to i if v is in the ith connected component processed. The
 * constructor finds an unmarked vertex and calls the recursive dfs() to mark
 * and identify all the vertices connected to it, continuing until all vertices
 * have been marked and identified. Implementations of the instance methods
 * connected(), id(), and count() are immediate.
 * 
 * Proposition C. DFS uses preprocessing time and space proportional to V+E to
 * support constant-time connectivity queries in a graph.
 * 
 * Proof: Immediate from the code. Each adjacency-list entry is examined exactly
 * once, and there are 2E such entries (two for each edge). Instance methods
 * examine or return one or two instance variables.
 */
public class CC {

	private boolean[] marked;
	private int[] id;
	private int count;

	public CC(Graph G) {
		marked = new boolean[G.V()];
		id = new int[G.V()];
		for (int s = 0; s < G.V(); s++) {
			if (!marked[s]) {
				dfs(G, s);
				count++;
			}
		}
	}

	private void dfs(Graph G, int v) {
		marked[v] = true;
		id[v] = count;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
	}

	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}

	public int id(int v) {
		return id[v];
	}

	public int count() {
		return count;
	}

}
