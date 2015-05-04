package br.com.danielbgg.graph.algs4;

import br.com.danielbgg.graph.algs4.Graph;
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
		printData(G, "tinyG");
	}

	public void testMedium() {
		Graph G = new Graph(new In("C:/java/repositorios/data/algs4-data/mediumG.txt"));
		printData(G, "mediumG");
	}
	
	private void printData(Graph G, String desc) {
		StdOut.println("----------------" + desc);
		StdOut.println(G);
		StdOut.println("Degree of node 1: " + G.degree(G, 1));
		StdOut.println("Max degree: " + G.maxDegree(G));
		StdOut.println("AVG degree: " + G.avgDegree(G));
		StdOut.println("Self loops: " + G.numberOfSelfLoops(G));
		StdOut.println();
	}

}
