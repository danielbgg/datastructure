package br.com.danielbgg.graph.matrix;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class GraphTest extends TestCase {

	public GraphTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(GraphTest.class);
	}

	public void testTiny() {
		Graph G = new Graph(new In("C:/java/repositorios/data/algs4-data/tinyG.txt"));
		StdOut.println(G);
		StdOut.println(G.degree(G, 1));
		StdOut.println(G.maxDegree(G));
		StdOut.println(G.avgDegree(G));
		StdOut.println(G.numberOfSelfLoops(G));
	}

	public void testMedium() {
		Graph G = new Graph(new In("C:/java/repositorios/data/algs4-data/mediumG.txt"));
		StdOut.println(G);
		StdOut.println(G.degree(G, 1));
		StdOut.println(G.maxDegree(G));
		StdOut.println(G.avgDegree(G));
		StdOut.println(G.numberOfSelfLoops(G));
	}

}
