package br.com.danielbgg.algs4.string;

import edu.princeton.cs.algs4.In;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CountTest extends TestCase {

	public CountTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(CountTest.class);
	}

	public void test1() {
		Count c = new Count();
		c.print("ABCDRZ", new In("C:/java/repositorios/data/algs4-data/abra.txt"));
	}

	public void test2() {
		Count c = new Count();
		c.print("0123456789", new In("C:/java/repositorios/data/algs4-data/pi.txt"));
	}
	
}
