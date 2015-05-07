package br.com.danielbgg.algs4.digraph.weight;

import edu.princeton.cs.algs4.EdgeWeightedDigraph;

/**
 * Longest paths. Consider the problem of finding the longest path in an
 * edge-weighted DAG with edge weights that may be positive or negative.
 * Single-source longest paths in edge-weighted DAGs. Given an edge-weighted DAG
 * (with negative weights allowed) and a source vertex s, support queries of the
 * form: Is there a directed path from s to a given target vertex v? If so, find
 * a longest such path (one whose total weight is maximal).
 */
public class AcyclicLP extends edu.princeton.cs.algs4.AcyclicLP {

	public AcyclicLP(EdgeWeightedDigraph G, int s) {
		super(G, s);
	}

}
