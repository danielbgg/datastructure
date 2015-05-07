package br.com.danielbgg.algs4.digraph.weight;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class CPMTest extends TestCase {

	public CPMTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(CPMTest.class);
	}

	public void testTiny() {
		long startTime = System.currentTimeMillis();
		new CPM(new In("C:/java/repositorios/data/algs4-data/jobsPC.txt"));
		StdOut.println("Total time: " + (System.currentTimeMillis() - startTime) + " ms");
	}
}