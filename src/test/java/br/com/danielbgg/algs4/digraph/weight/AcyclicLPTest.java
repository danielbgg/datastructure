package br.com.danielbgg.algs4.digraph.weight;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class AcyclicLPTest extends TestCase {

	public AcyclicLPTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(AcyclicLPTest.class);
	}

	public void testTiny() {
		long startTime = System.currentTimeMillis();
		edu.princeton.cs.algs4.EdgeWeightedDigraph G = new edu.princeton.cs.algs4.EdgeWeightedDigraph(new In(
		        "C:/java/repositorios/data/algs4-data/tinyEWDAG.txt"));
		printData(G, "tinyEWDAG");
		AcyclicLP spt = new AcyclicLP(G, 5);
		printData(G, spt, 5);
		StdOut.println("Total time: " + (System.currentTimeMillis() - startTime) + " ms");
	}

	private void printData(edu.princeton.cs.algs4.EdgeWeightedDigraph G, String desc) {
		StdOut.println("----------------" + desc);
		StdOut.println(G);
	}

	private void printData(edu.princeton.cs.algs4.EdgeWeightedDigraph G, AcyclicLP spt, int s) {
		for (int t = 0; t < G.V(); t++) {
			StdOut.print(s + " to " + t);
			StdOut.printf(" (%4.2f): ", spt.distTo(t));
			if (spt.hasPathTo(t))
				for (edu.princeton.cs.algs4.DirectedEdge e : spt.pathTo(t))
					StdOut.print(e + " ");
			StdOut.println();
		}
	}

}