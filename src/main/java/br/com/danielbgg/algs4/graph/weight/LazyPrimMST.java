package br.com.danielbgg.algs4.graph.weight;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

/**
 * Which is the minimal-weight crossing edge?
 * 
 * Attach a new edge to a single growing tree at each step. Start with any
 * vertex as a single-vertex tree; then add V-1 edges to it, always taking next
 * (coloring black) the minimumweight edge that connects a vertex on the tree to
 * a vertex not yet on the tree (a crossing edge for the cut defined by tree
 * vertices).
 * 
 * Proposition M. The lazy version of Prim’s algorithm uses space proportional
 * to E and time proportional to E log E (in the worst case) to compute the MST
 * of a connected edge-weighted graph with E edges and V vertices.
 * 
 * Proof: The bottleneck in the algorithm is the number of edge-weight
 * comparisons in the priority-queue methods insert() and delMin(). The number
 * of edges on the priority queue is at most E, which gives the space bound. In
 * the worst case, the cost of an insertion is ~lg E and the cost to delete the
 * minimum is ~2 lg E (see Proposition O in Chapter 2). Since at most E edges
 * are inserted and at most E are deleted, the time bound follows.
 * 
 * This implementation of Prim’s algorithm uses a priority queue to hold
 * crossing edges, a vertex-indexed arrays to mark tree vertices, and a queue to
 * hold MST edges. This implementation is a lazy approach where we leave
 * ineligible edges in the priority queue.
 */
public class LazyPrimMST {

	private double weight;

	// MST vertices
	private boolean[] marked;

	// MST edges
	private Queue<Edge> mst;

	// crossing (and ineligible) edges
	private MinPQ<Edge> pq;

	public LazyPrimMST(EdgeWeightedGraph G) {
		weight = 0.0;
		pq = new MinPQ<Edge>();
		marked = new boolean[G.V()];
		mst = new Queue<Edge>();
		// assumes G is connected
		visit(G, 0);
		while (!pq.isEmpty()) {
			// get lowest-weight edge from pq
			Edge e = pq.delMin();
			int v = e.either();
			int w = e.other(v);
			// skip if ineligible
			if (marked[v] && marked[w]) {
				continue;
			}
			// add edge to tree
			mst.enqueue(e);
			weight += e.weight();
			// add vertex to tree (either v or w)
			if (!marked[v]) {
				visit(G, v);
			}
			if (!marked[w]) {
				visit(G, w);
			}
		}
	}

	private void visit(EdgeWeightedGraph G, int v) {
		// mark v and add to pq all edges from v to umarked vertices
		marked[v] = true;
		for (Edge e : G.adj(v)) {
			if (!marked[e.other(v)]) {
				pq.insert(e);
			}
		}
	}

	public Iterable<Edge> edges() {
		return mst;
	}

	public double weight() {
		return weight;
	}

}
