package br.com.danielbgg.algs4.graph.weight;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class KruskalMSTTest extends TestCase {

	public KruskalMSTTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(KruskalMSTTest.class);
	}

	public void testTiny() {
		long startTime = System.currentTimeMillis();		
		EdgeWeightedGraph G = new EdgeWeightedGraph(new In("C:/java/repositorios/data/algs4-data/tinyEWG.txt"));
		printData(G, "tinyEWG");
		KruskalMST mst = new KruskalMST(G);
		printData(mst);
		StdOut.println("Total time: " + (System.currentTimeMillis() - startTime) + " ms");		
	}

	public void testMedium() {
		long startTime = System.currentTimeMillis();		
		EdgeWeightedGraph G = new EdgeWeightedGraph(new In("C:/java/repositorios/data/algs4-data/mediumEWG.txt"));
		printData(G, "mediumEWG");
		KruskalMST mst = new KruskalMST(G);
		printData(mst);
		StdOut.println("Total time: " + (System.currentTimeMillis() - startTime) + " ms");		
	}

	public void testLarge() {
		long startTime = System.currentTimeMillis();		
		EdgeWeightedGraph G = new EdgeWeightedGraph(new In("C:/java/repositorios/data/algs4-data/largeEWG.txt"));
		printData(G, "largeEWG");
		KruskalMST mst = new KruskalMST(G);
		printData(mst);
		StdOut.println("Total time: " + (System.currentTimeMillis() - startTime) + " ms");		
	}
	
	private void printData(EdgeWeightedGraph G, String desc) {
		StdOut.println("----------------" + desc);
	}

	private void printData(KruskalMST mst) {
		StdOut.println("Minimum spanning tree");
//		for (Edge e : mst.edges()) {
//			StdOut.println(e);
//		}
		StdOut.println("Total weight: " + mst.weight());
	}

}
