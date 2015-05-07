package br.com.danielbgg.algs4.digraph.weight;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class DijkstraAllPairsSPTest extends TestCase {

	public DijkstraAllPairsSPTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(DijkstraAllPairsSPTest.class);
	}

	public void testTiny() {
		long startTime = System.currentTimeMillis();
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In("C:/java/repositorios/data/algs4-data/tinyEWD.txt"));
		printData(G, "tinyEWD");
		DijkstraAllPairsSP spt = new DijkstraAllPairsSP(G);
		printData(G, spt, 5);
		StdOut.println("Total time: " + (System.currentTimeMillis() - startTime) + " ms");
	}

	private void printData(EdgeWeightedDigraph G, String desc) {
		StdOut.println("----------------" + desc);
		StdOut.println(G);
	}

	private void printData(EdgeWeightedDigraph G, DijkstraAllPairsSP spt, int s) {
		for (int t = 0; t < G.V(); t++) {
			StdOut.print(s + " to " + t);
			StdOut.printf(" (%4.2f): ", spt.dist(s, t));
			for (DirectedEdge e : spt.path(s, t))
				StdOut.print(e + " ");
			StdOut.println();
		}
	}

}