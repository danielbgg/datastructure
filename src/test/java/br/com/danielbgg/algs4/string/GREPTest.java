package br.com.danielbgg.algs4.string;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import edu.princeton.cs.algs4.In;

public class GREPTest extends TestCase {

	public GREPTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(GREPTest.class);
	}

	public void test1() {
		GREP g = new GREP();
		g.search(new In("C:/java/repositorios/data/algs4-data/tinyL.txt"), "(A*B|AC)D");
	}

}
