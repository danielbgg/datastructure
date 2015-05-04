package br.com.danielbgg.graph.algs4;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class CycleTest extends TestCase {

	public CycleTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(CycleTest.class);
	}

	public void testTiny() {
		Graph G = new Graph(new In("C:/java/repositorios/data/algs4-data/tinyG.txt"));
		printData(G, "tinyG");
		Cycle cycle = new Cycle(G);
		StdOut.println("Has cycle? " + cycle.hasCycle());
	}

	private void printData(Graph G, String desc) {
		StdOut.println("----------------" + desc);
		StdOut.println(G);
	}
}
