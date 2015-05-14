package br.com.danielbgg.algs4.string;

import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class LSDTest extends TestCase {

	public LSDTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(LSDTest.class);
	}

	public void test1() {
		LSD lsd = new LSD();
		String[] a = new String[] { "4PGC938", "2IYE230", "3CIO720", "1ICK750", "1OHV845", "4JZY524", "1ICK750", "3CIO720", "1OHV845", "1OHV845", "2RLA629",
		        "2RLA629", "3ATW723" };
		lsd.sort(a, 7);
		System.out.println(Arrays.toString(a));
	}

}
