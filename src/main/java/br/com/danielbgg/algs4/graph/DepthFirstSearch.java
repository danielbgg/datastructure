package br.com.danielbgg.algs4.graph;

/**
 * single-source connectivity
 * 
 * Proposition A. DFS marks all the vertices connected to a given source in time
 * proportional to the sum of their degrees.
 * 
 * Proof: First, we prove that the algorithm marks all the vertices connected to
 * the source s (and no others). Every marked vertex is connected to s, since
 * the algorithm finds vertices only by following edges. Now, suppose that some
 * unmarked vertex w is connected to s. Since s itself is marked, any path from
 * s to w must have at least one edge from the set of marked vertices to the set
 * of unmarked vertices, say v-x. But the algorithm would have discovered x
 * after marking v, so no such edge can exist, a contradiction. The time bound
 * follows because marking ensures that each vertex is visited once (taking time
 * proportional to its degree to check marks).
 * 
 * Connectivity. Given a graph, support queries of the form Are two given
 * vertices connected ? and How many connected components does the graph have ?
 * 
 * Single-source paths. Given a graph and a source vertex s, support queries of
 * the form Is there a path from s to a given target vertex v? If so, find such
 * a path.
 */
public class DepthFirstSearch {

	private boolean[] marked;
	private int count;
	private EventLogger logger;

	public DepthFirstSearch(Graph G, int s) {
		logger = new EventLogger();
		marked = new boolean[G.V()];
		dfs(G, s);
	}

	private void dfs(Graph G, int v) {
		logger.add(v, "visiting vertex");
		marked[v] = true;
		count++;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
		logger.add(v, "done");
	}

	public EventLogger getEventLogger() {
		return logger;
	}

	public boolean marked(int w) {
		return marked[w];
	}

	public int count() {
		return count;
	}

}
