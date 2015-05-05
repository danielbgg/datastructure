package br.com.danielbgg.digraph.algs4;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class TransitiveClosureTest extends TestCase {

	public TransitiveClosureTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(TransitiveClosureTest.class);
	}

	public void testTiny() {
		Digraph G = new Digraph(new In("C:/java/repositorios/data/algs4-data/tinyDG.txt"));
		printData(G, "tinyDG");
		TransitiveClosure tc = new TransitiveClosure(G);
		printData(tc, 0, 1);
		printData(tc, 2, 3);
		printData(tc, 9, 6);
		printData(tc, 6, 9);
	}

	private void printData(Digraph G, String desc) {
		StdOut.println("----------------" + desc);
		StdOut.println(G);
		StdOut.println();
	}

	private void printData(TransitiveClosure tc, int v, int w) {
		StdOut.println("Is v(" + v + ") reachable from w(" + w + ")? -->" + tc.reachable(v, w));
	}

}
