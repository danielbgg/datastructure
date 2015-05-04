package br.com.danielbgg.digraph.algs4;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class DirectedDFSTest extends TestCase {

	public DirectedDFSTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(DirectedDFSTest.class);
	}

	public void testTiny() {
		Digraph G = new Digraph(new In("C:/java/repositorios/data/algs4-data/tinyDG.txt"));
		printData(G, "tinyDG");

		Bag<Integer> sources = new Bag<Integer>();
		sources.add(0);
		
		DirectedDFS reachable = new DirectedDFS(G, sources);
		printReachable(G, reachable);
	}

	private void printData(Digraph G, String desc) {
		StdOut.println("----------------" + desc);
		StdOut.println(G);
		StdOut.println();
	}
	
	private void printReachable(Digraph G, DirectedDFS reachable) {
		for (int v = 0; v < G.V(); v++)
			if (reachable.marked(v))
				StdOut.print(v + " ");
		StdOut.println();		
	}

}
