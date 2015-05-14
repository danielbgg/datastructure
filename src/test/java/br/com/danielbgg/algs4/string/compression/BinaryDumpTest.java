package br.com.danielbgg.algs4.string.compression;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class BinaryDumpTest extends TestCase {

	public BinaryDumpTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(BinaryDumpTest.class);
	}

	public void test1() {
		BinaryDump b = new BinaryDump();
		b.print(16);
	}

}
