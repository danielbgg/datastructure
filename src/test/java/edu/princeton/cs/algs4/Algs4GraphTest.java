package edu.princeton.cs.algs4;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Algs4GraphTest extends TestCase {

	public Algs4GraphTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(Algs4GraphTest.class);
	}

	public void testTiny() {
		Graph G = new Graph(new In("C:/java/repositorios/data/algs4-data/tinyG.txt"));
		StdOut.println(G);
	}

	public void testMedium() {
		Graph G = new Graph(new In("C:/java/repositorios/data/algs4-data/mediumG.txt"));
		StdOut.println(G);
	}

}
