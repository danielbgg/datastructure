package br.com.danielbgg.algs4.string;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import edu.princeton.cs.algs4.StdOut;

public class RabinKarpTest extends TestCase {

	public RabinKarpTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(RabinKarpTest.class);
	}

	public void test1() {
		String pat = "AACAA";
		String txt = "AABRAACADABRAACAADABRA";
		RabinKarp rk = new RabinKarp(pat);
		StdOut.println("text:    " + txt);
		int offset = rk.search(txt);
		StdOut.print("pattern: ");
		for (int i = 0; i < offset; i++)
			StdOut.print(" ");
		StdOut.println(pat);
	}

}
