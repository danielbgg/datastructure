package br.com.danielbgg.algs4.digraph.weight;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class ArbitrageTest extends TestCase {

	public ArbitrageTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(ArbitrageTest.class);
	}

	public void testTiny() {
		long startTime = System.currentTimeMillis();
		Arbitrage a = new Arbitrage();
		a.hasOpportunity(new In("C:/java/repositorios/data/algs4-data/rates.txt"));
		StdOut.println("Total time: " + (System.currentTimeMillis() - startTime) + " ms");
	}
}