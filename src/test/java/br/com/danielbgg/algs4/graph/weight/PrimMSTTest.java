package br.com.danielbgg.algs4.graph.weight;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class PrimMSTTest extends TestCase {

	public PrimMSTTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(PrimMSTTest.class);
	}

	public void testTiny() {
		long startTime = System.currentTimeMillis();		
		EdgeWeightedGraph G = new EdgeWeightedGraph(new In("C:/java/repositorios/data/algs4-data/tinyEWG.txt"));
		printData(G, "tinyEWG");
		PrimMST mst = new PrimMST(G);
		printData(mst);
		StdOut.println("Total time: " + (System.currentTimeMillis() - startTime) + " ms");		
	}

	public void testMedium() {
		long startTime = System.currentTimeMillis();		
		EdgeWeightedGraph G = new EdgeWeightedGraph(new In("C:/java/repositorios/data/algs4-data/mediumEWG.txt"));
		printData(G, "mediumEWG");
		PrimMST mst = new PrimMST(G);
		printData(mst);
		StdOut.println("Total time: " + (System.currentTimeMillis() - startTime) + " ms");		
	}

	public void testLarge() {
		long startTime = System.currentTimeMillis();		
		EdgeWeightedGraph G = new EdgeWeightedGraph(new In("C:/java/repositorios/data/algs4-data/largeEWG.txt"));
		printData(G, "largeEWG");
		PrimMST mst = new PrimMST(G);
		printData(mst);
		StdOut.println("Total time: " + (System.currentTimeMillis() - startTime) + " ms");		
	}
	
	private void printData(EdgeWeightedGraph G, String desc) {
		StdOut.println("----------------" + desc);
	}
	
	private void printData(PrimMST mst) {
		StdOut.println("Minimum spanning tree");
//		for (Edge e : mst.edges()) {
//			StdOut.println(e);
//		}
		StdOut.println("Total weight: " + mst.weight());
	}

}
