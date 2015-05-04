package br.com.danielbgg.graph.algs4;

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
