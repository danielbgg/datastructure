package br.com.danielbgg.algs4.graph.weight;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;

/**
 * Process the edges in order of their weight values (smallest to largest),
 * taking for the MST (coloring black) each edge that does not form a cycle with
 * edges previously added, stopping after adding V1 edges have been taken. The
 * black edges form a forest of trees that evolves gradually into a single tree,
 * the MST.
 *
 * Proposition O. Kruskal’s algorithm computes the MST of any edge-weighted
 * connected graph.
 * 
 * Proof: Immediate from Proposition K. If the next edge to be considered does
 * not form a cycle with black edges, it crosses a cut defined by the set of
 * vertices connected to one of the edge’s vertices by tree edges (and its
 * complement). Since the edge does not create a cycle, it is the only crossing
 * edge seen so far, and since we consider the edges in sorted order, it is a
 * crossing edge of minimum weight. Thus, the algorithm is successively taking a
 * minimal-weight crossing edge, in accordance with the greedy algorithm.
 * 
 * Proposition N (continued). Kruskal’s algorithm uses space proportional to E
 * and time proportional to E log E (in the worst case) to compute the MST of an
 * edgeweighted connected graph with E edges and V vertices.
 * 
 * Proof: The implementation uses the priority-queue constructor that
 * initializes the priority queue with all the edges, at a cost of at most E
 * compares (see Section 2.4). After the priority queue is built, the argument
 * is the same as for Prim’s algorithm. The number of edges on the priority
 * queue is at most E, which gives the space bound, and the cost per operation
 * is at most 2 lg E compares, which gives the time bound. Kruskal’s algorithm
 * also performs up to E find() and V union() operations, but that cost does not
 * contribute to the E log E order of growth of the total running time (see
 * Section 1.5).
 * 
 * This implementation of Kruskal’s algorithm uses a queue to hold MST edges, a
 * priority queue to hold edges not yet examined, and a union-find data
 * structure for identifying ineligible edges. The MST edges are returned to the
 * client in increasing order of their weights. The weight() method is left as
 * an exercise. 
 */
public class KruskalMST {

	// weight of MST
	private double weight;

	private Queue<Edge> mst;

	public KruskalMST(EdgeWeightedGraph G) {
		mst = new Queue<Edge>();
		MinPQ<Edge> pq = new MinPQ<Edge>();
		for (Edge e : G.edges()) {
			pq.insert(e);
		}
		UF uf = new UF(G.V());

		while (!pq.isEmpty() && mst.size() < G.V() - 1) {
			// get min weight edge on pq and its vertices
			Edge e = pq.delMin();
			int v = e.either();
			int w = e.other(v);
			// ignore ineligible edges
			if (uf.connected(v, w)) {
				continue;
			}
			// merge componentes
			uf.union(v, w);
			// add edge to mst
			mst.enqueue(e);
			weight += e.weight();

		}
	}

	public Iterable<Edge> edges() {
		return mst;
	}

	public double weight() {
		return weight;
	}

}
