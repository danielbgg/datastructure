package br.com.danielbgg.algs4.digraph.weight;

import edu.princeton.cs.algs4.EdgeWeightedDigraph;

/**
 * This implementation of the Bellman-Ford algorithm uses a version of relax()
 * that puts vertices pointed to by edges that successfully relax on a FIFO
 * queue (avoiding duplicates) and periodically checks for a negative cycle in
 * edgeTo[] (see text).
 * 
 * Proposition X. ( Bellman-Ford algorithm) The following method solves the
 * singlesource shortest-paths problem from a given source s for any
 * edge-weighted digraph with V vertices and no negative cycles reachable from
 * s: Initialize distTo[s] to 0 and all other distTo[] values to infinity. Then,
 * considering the digraph’s edges in any order, relax all edges. Make V such
 * passes.
 * 
 * Proof: For any vertex t that is reachable from s consider a specific shortest
 * path from s to t: v 0->v1->...->vk, where v0 is s and vk is t. Since there
 * are no negative cycles, such a path exists and k can be no larger than V1.
 * We show by induction on i that after the ith pass the algorithm computes a
 * shortest path from s to vi. The base case (i = 0) is trivial. Assuming the
 * claim to be true for i, v0->v1->...->vi is a shortest path from s to vi, and
 * distTo[vi] is its length. Now, we relax every vertex in the ith pass,
 * including vi, so distTo[vi+1] is no greater than distTo[vi] plus the weight
 * of vi->vi+1. Now, after the ith pass, distTo[vi+1] must be equal to
 * distTo[vi] plus the weight of vi->vi+1. It cannot be greater because we relax
 * every vertex in the ith pass, in particular vi, and it cannot be less because
 * that is the length of v0->v1->...->vi+1, a shortest path. Thus the algorithm
 * computes a shortest path from s to vi+1 after the (i+1)st pass.
 * 
 * Proposition W (continued). The Bellman-Ford algorithm takes time proportional
 * to EV and extra space proportional to V.
 * 
 * Proof: Each of the V passes relaxes E edges.
 * 
 * Proposition Y. The queue-based implementation of the Bellman-Ford algorithm
 * solves the shortest-paths problem from a given source s (or finds a negative
 * cycle reachable from s) for any edge-weighted digraph with V vertices, in
 * time proportional to EV and extra space proportional to V, in the worst case.
 * 
 * Proof: If there is no negative cycle reachable from s, the algorithm
 * terminates after relaxations corresponding to the (V–1)st pass of the generic
 * algorithm described in Proposition X (since all shortest paths have fewer
 * than V–1 edges). If there does exist a negative cycle reachable from s, the
 * queue never empties. After relaxations corresponding to the Vth pass of the
 * generic algorithm described in Proposition X the edgeTo[] array has a path
 * with a cycle (connects some vertex w to itself) and that cycle must be
 * negative, since the path from s to the second occurrence of w must be shorter
 * that the path from s to the first occurrence of w for w to be included on the
 * path the second time. In the worst case, the algorithm mimics the general
 * algorithm and relaxes all E edges in each of V passes.
 * 
 */
public class BellmanFordSP extends edu.princeton.cs.algs4.BellmanFordSP {

	public BellmanFordSP(EdgeWeightedDigraph G, int s) {
		super(G, s);
	}
}
