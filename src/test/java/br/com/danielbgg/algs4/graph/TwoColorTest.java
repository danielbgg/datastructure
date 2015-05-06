package br.com.danielbgg.algs4.graph;

import br.com.danielbgg.algs4.graph.Graph;
import br.com.danielbgg.algs4.graph.TwoColor;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class TwoColorTest extends TestCase {

	public TwoColorTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(TwoColorTest.class);
	}

	public void testTiny() {
		Graph G = new Graph(new In("C:/java/repositorios/data/algs4-data/tinyG.txt"));
		printData(G, "tinyG");
		TwoColor color = new TwoColor(G);
		StdOut.println("Is bipartite? " + color.isBipartite());
	}

	private void printData(Graph G, String desc) {
		StdOut.println("----------------" + desc);
		StdOut.println(G);
	}
}
