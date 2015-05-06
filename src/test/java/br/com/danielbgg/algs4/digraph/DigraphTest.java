package br.com.danielbgg.algs4.digraph;

import br.com.danielbgg.algs4.digraph.Digraph;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class DigraphTest extends TestCase {

	public DigraphTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(DigraphTest.class);
	}

	public void testTiny() {
		Digraph G = new Digraph(new In("C:/java/repositorios/data/algs4-data/tinyDG.txt"));
		printData(G, "tinyDG");
	}

	private void printData(Digraph G, String desc) {
		StdOut.println("----------------" + desc);
		StdOut.println(G);
		StdOut.println();
	}

}
