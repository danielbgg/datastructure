package br.com.danielbgg.algs4.digraph.weight;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * This BellmanFordSP client finds an arbitrage opportunity in a currency
 * exchange table by constructing a complete-graph representation of the
 * exchange table and then using the Bellman-Ford algorithm to find a negative
 * cycle in the graph.
 * 
 * Proposition Z. The arbitrage problem is a negative-cycle-detection problem in
 * edge-weighted digraphs.
 * 
 * Proof: Replace each weight by its logarithm, negated. With this change,
 * computing path weights by multiplying edge weights in the original problem
 * corresponds to adding them in the transformed problem. Specifically, any
 * product w1w2 . . . wk corresponds to a sum ln(w1)  ln(w2)  . . .  ln(wk).
 * The transformed edge weights might be negative or positive, a path from v to
 * w gives a way of converting from currency v to currency w, and any negative
 * cycle is an arbitrage opportunity.
 */
public class Arbitrage {

	public Arbitrage() {
	}

	public void hasOpportunity(In in) {
		int V = in.readInt();
		String[] name = new String[V];
		edu.princeton.cs.algs4.EdgeWeightedDigraph G = new edu.princeton.cs.algs4.EdgeWeightedDigraph(V);
		for (int v = 0; v < V; v++) {
			name[v] = in.readString();
			for (int w = 0; w < V; w++) {
				double rate = in.readDouble();
				edu.princeton.cs.algs4.DirectedEdge e = new edu.princeton.cs.algs4.DirectedEdge(v, w, -Math.log(rate));
				G.addEdge(e);
			}
		}
		BellmanFordSP spt = new BellmanFordSP(G, 0);
		if (spt.hasNegativeCycle()) {
			double stake = 1000.0;
			for (edu.princeton.cs.algs4.DirectedEdge e : spt.negativeCycle()) {
				StdOut.printf("%10.5f %s ", stake, name[e.from()]);
				stake *= Math.exp(-e.weight());
				StdOut.printf("= %10.5f %s\n", stake, name[e.to()]);
			}
		} else
			StdOut.println("No arbitrage opportunity");
	}

}
