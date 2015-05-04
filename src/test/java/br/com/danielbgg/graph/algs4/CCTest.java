package br.com.danielbgg.graph.algs4;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class CCTest extends TestCase {

	public CCTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(CCTest.class);
	}

	public void testTiny() {
		Graph G = new Graph(new In("C:/java/repositorios/data/algs4-data/tinyG.txt"));
		printData(G, "tinyG");
		CC cc = new CC(G);
		int M = cc.count();
		StdOut.println(M + " components");
		Bag<Integer>[] components = new Bag[M];
		for (int i = 0; i < M; i++)
			components[i] = new Bag<Integer>();
		for (int v = 0; v < G.V(); v++)
			components[cc.id(v)].add(v);
		for (int i = 0; i < M; i++) {
			for (int v : components[i])
				StdOut.print(v + " ");
			StdOut.println();
		}
	}

	private void printData(Graph G, String desc) {
		StdOut.println("----------------" + desc);
		StdOut.println(G);
	}

}
