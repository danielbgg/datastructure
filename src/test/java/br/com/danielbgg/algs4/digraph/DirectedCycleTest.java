package br.com.danielbgg.algs4.digraph;

import br.com.danielbgg.algs4.digraph.Digraph;
import br.com.danielbgg.algs4.digraph.DirectedCycle;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class DirectedCycleTest extends TestCase {

	public DirectedCycleTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(DirectedCycleTest.class);
	}

	public void testTinyDG() {
		Digraph G = new Digraph(new In("C:/java/repositorios/data/algs4-data/tinyDG.txt"));
		printData(G, "tinyDG");
		DirectedCycle dc = new DirectedCycle(G);
		StdOut.println("Has cycle? " + dc.hasCycle());
	}

	public void testTinyDAG() {
		Digraph G = new Digraph(new In("C:/java/repositorios/data/algs4-data/tinyDAG.txt"));
		printData(G, "tinyDAG");
		DirectedCycle dc = new DirectedCycle(G);
		StdOut.println("Has cycle? " + dc.hasCycle());
	}
	
	private void printData(Digraph G, String desc) {
		StdOut.println("----------------" + desc);
		StdOut.println(G);
		StdOut.println();
	}

}
