package br.com.danielbgg.algs4.string;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import edu.princeton.cs.algs4.StdOut;

public class KMPTest extends TestCase {

	public KMPTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(KMPTest.class);
	}

	public void test1() {
		String pat = "AACAA";
		String txt = "AABRAACADABRAACAADABRA";
		KMP kmp = new KMP(pat);
		StdOut.println("text:    " + txt);
		int offset = kmp.search(txt);
		StdOut.print("pattern: ");
		for (int i = 0; i < offset; i++)
			StdOut.print(" ");
		StdOut.println(pat);
	}

}
