package br.com.danielbgg.algs4.digraph.weight;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class DijkstraSPTest extends TestCase {

	public DijkstraSPTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(DijkstraSPTest.class);
	}

	public void testTiny() {
		long startTime = System.currentTimeMillis();
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In("C:/java/repositorios/data/algs4-data/tinyEWD.txt"));
		printData(G, "tinyEWD");
		DijkstraSP spt = new DijkstraSP(G, 0);
		printData(G, spt, 0);
		StdOut.println("Total time: " + (System.currentTimeMillis() - startTime) + " ms");
	}

	public void testMedium() {
		long startTime = System.currentTimeMillis();
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In("C:/java/repositorios/data/algs4-data/mediumEWD.txt"));
		printData(G, "mediumEWD");
		DijkstraSP spt = new DijkstraSP(G, 0);
		printData(G, spt, 0);
		StdOut.println("Total time: " + (System.currentTimeMillis() - startTime) + " ms");
	}
	
	private void printData(EdgeWeightedDigraph G, String desc) {
		StdOut.println("----------------" + desc);
		StdOut.println(G);
	}

	private void printData(EdgeWeightedDigraph G, DijkstraSP spt, int s) {
		for (int t = 0; t < G.V(); t++) {
			StdOut.print(s + " to " + t);
			StdOut.printf(" (%4.2f): ", spt.distTo(t));
			if (spt.hasPathTo(t))
				for (DirectedEdge e : spt.pathTo(t))
					StdOut.print(e + " ");
			StdOut.println();
		}
	}

}