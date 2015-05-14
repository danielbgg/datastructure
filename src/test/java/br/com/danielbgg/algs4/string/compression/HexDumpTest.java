package br.com.danielbgg.algs4.string.compression;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class HexDumpTest extends TestCase {

	public HexDumpTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(HexDumpTest.class);
	}

	public void test1() {
		HexDump b = new HexDump();
		b.print(16);
	}

}
