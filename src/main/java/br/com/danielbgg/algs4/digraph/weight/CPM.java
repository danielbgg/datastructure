package br.com.danielbgg.algs4.digraph.weight;

import edu.princeton.cs.algs4.AcyclicLP;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Parallel precedence-constrained scheduling. Given a set of jobs of specified
 * duration to be completed, with precedence constraints that specify that
 * certain jobs have to be completed before certain other jobs are begun, how
 * can we schedule the jobs on identical processors (as many as needed ) such
 * that they are all completed in the minimum amount of time while still
 * respecting the constraints?
 * 
 * This implementation of the critical path method for job scheduling reduces
 * the problem directly to the longest-paths problem in edgeweighted DAGs. It
 * builds an edge-weighted digraph (which must be a DAG) from the job-scheduling
 * problem specification, as prescribed by the critical path method, then uses
 * AcyclicLP (see Proposition T) to find the longest-paths tree and to print the
 * longest-paths lengths, which are precisely the start times for each job.
 */
public class CPM {

	public CPM(In in) {

		// number of jobs
		int N = in.readInt();

		// source and sink
		int source = 2 * N;
		int sink = 2 * N + 1;

		// build network
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(2 * N + 2);
		for (int i = 0; i < N; i++) {
			double duration = in.readDouble();
			G.addEdge(new DirectedEdge(source, i, 0.0));
			G.addEdge(new DirectedEdge(i + N, sink, 0.0));
			G.addEdge(new DirectedEdge(i, i + N, duration));

			// precedence constraints
			int M = in.readInt();
			for (int j = 0; j < M; j++) {
				int precedent = in.readInt();
				G.addEdge(new DirectedEdge(N + i, precedent, 0.0));
			}
		}

		// compute longest path
		AcyclicLP lp = new AcyclicLP(G, source);

		// print results
		StdOut.println(" job   start  finish");
		StdOut.println("--------------------");
		for (int i = 0; i < N; i++) {
			StdOut.printf("%4d %7.1f %7.1f\n", i, lp.distTo(i), lp.distTo(i + N));
		}
		StdOut.printf("Finish time: %7.1f\n", lp.distTo(sink));
	}

}
