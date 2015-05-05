package br.com.danielbgg.digraph.algs4;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class KosarajuSCCTest extends TestCase {

	public KosarajuSCCTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(KosarajuSCCTest.class);
	}

	public void testTiny() {
		Digraph G = new Digraph(new In("C:/java/repositorios/data/algs4-data/tinyDG.txt"));
		printData(G, "tinyDG");
		KosarajuSCC scc = new KosarajuSCC(G);
		printBag(scc.count(), scc.components());
	}

	public void testMedium() {
		Digraph G = new Digraph(new In("C:/java/repositorios/data/algs4-data/mediumDG.txt"));
		printData(G, "mediumDG");
		KosarajuSCC scc = new KosarajuSCC(G);
		printBag(scc.count(), scc.components());
	}
	
	private void printData(Digraph G, String desc) {
		StdOut.println("----------------" + desc);
		StdOut.println(G);
		StdOut.println();
	}

	private void printBag(int quantity, Bag<Integer>[] components) {
		StdOut.println(quantity + " components");
		for (int i = 0; i < components.length; i++) {
			for (int v : components[i])
				StdOut.print(v + " ");
			StdOut.println();
		}
	}

}
