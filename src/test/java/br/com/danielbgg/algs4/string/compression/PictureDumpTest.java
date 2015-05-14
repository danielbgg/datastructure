package br.com.danielbgg.algs4.string.compression;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PictureDumpTest extends TestCase {

	public PictureDumpTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(PictureDumpTest.class);
	}

	public void test1() {
		PictureDump b = new PictureDump();
		b.print(16, 6);
	}

}
