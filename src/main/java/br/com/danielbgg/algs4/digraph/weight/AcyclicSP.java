package br.com.danielbgg.algs4.digraph.weight;

import edu.princeton.cs.algs4.EdgeWeightedDigraph;

/**
 * Proposition S. By relaxing vertices in topological order, we can solve the
 * singlesource shortest-paths problem for edge-weighted DAGs in time
 * proportional to E + V.
 * 
 * Proof: Every edge v->w is relaxed exactly once, when v is relaxed, leaving
 * distTo[w] <= distTo[v] + e.weight(). This inequality holds until the
 * algorithm completes, since distTo[v] never changes (because of the
 * topological order, no edge pointing to v will be processed after v is
 * relaxed) and distTo[w] can only decrease (any relaxation can only decrease a
 * distTo[] value). Thus, after all vertices reachable from s have been added to
 * the tree, the shortest-paths optimality conditions hold, and Proposition Q
 * applies. The time bound is immediate: Proposition G on page 583 tells us that
 * the topological sort takes time proportional to E + V, and the second
 * relaxation pass completes the job by relaxing each edge once, again in time
 * proportional to E + V.
 */
public class AcyclicSP extends edu.princeton.cs.algs4.AcyclicSP {

	public AcyclicSP(EdgeWeightedDigraph G, int s) {
		super(G, s);
	}

}
