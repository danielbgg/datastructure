package br.com.danielbgg.algs4.graph.weight;

import edu.princeton.cs.algs4.IndexMinPQ;
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
 * Proposition N. The eager version of Prim’s algorithm uses extra space
 * proportional to V and time proportional to E log V (in the worst case) to
 * compute the MST of a connected edgeweighted graph with E edges and V
 * vertices.
 * 
 * Proof: The number of edges on the priority queue is at most V, and there are
 * three vertex-indexed arrays, which implies the space bound. The algorithm
 * uses V insert operations, V delete the minimum operations, and (in the worst
 * case) E change priority operations. These counts, coupled with the fact that
 * our heap-based implementation of the index priority queue implements all
 * these operations in time proportional to log V (see page 321), imply the time
 * bound.
 * 
 * This implementation (eager version) of Prim’s algorithm keeps eligible
 * crossing edges on an index priority queue.
 */
public class PrimMST {

	// shortest edge from tree vertes
	private Edge[] edgeTo;

	// distTo[w] = edgeTo[w].weight()
	private double[] distTo;

	// true if v on tree
	private boolean[] marked;

	// eligible crossing edges
	private IndexMinPQ<Double> pq;

	public PrimMST(EdgeWeightedGraph G) {
		edgeTo = new Edge[G.V()];
		distTo = new double[G.V()];
		marked = new boolean[G.V()];
		for (int v = 0; v < G.V(); v++) {
			distTo[v] = Double.POSITIVE_INFINITY;
		}
		pq = new IndexMinPQ<Double>(G.V());

		distTo[0] = 0.0;
		// initialize pq with 0, weight 0
		pq.insert(0, 0.0);
		while (!pq.isEmpty()) {
			// add closest vertex to tree
			visit(G, pq.delMin());
		}
	}

	private void visit(EdgeWeightedGraph G, int v) {
		// add v to tree; update data structures
		marked[v] = true;
		for (Edge e : G.adj(v)) {
			int w = e.other(v);
			// v-w is ineligible
			if (marked[w]) {
				continue;
			}
			if (e.weight() < distTo[w]) {
				// edge e is new best connection from tree to w
				edgeTo[w] = e;
				distTo[w] = e.weight();
				if (pq.contains(w)) {
					pq.change(w, distTo[w]);
				} else {
					pq.insert(w, distTo[w]);
				}
			}
		}
	}

	public Iterable<Edge> edges() {
		Queue<Edge> mst = new Queue<Edge>();
		for (int v = 0; v < edgeTo.length; v++) {
			Edge e = edgeTo[v];
			if (e != null) {
				mst.enqueue(e);
			}
		}
		return mst;
	}

	public double weight() {
		double weight = 0.0;
		for (Edge e : edges())
			weight += e.weight();
		return weight;
	}

}
