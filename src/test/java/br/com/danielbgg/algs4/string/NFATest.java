package br.com.danielbgg.algs4.string;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class NFATest extends TestCase {

	public NFATest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(NFATest.class);
	}

	public void test1() {
		NFA n = new NFA("((A*B|AC)D)");
		System.out.println(n.recognizes("AABD"));
	}

}
