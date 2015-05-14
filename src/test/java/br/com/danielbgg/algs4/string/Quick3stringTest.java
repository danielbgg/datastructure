package br.com.danielbgg.algs4.string;

import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Quick3stringTest extends TestCase {

	public Quick3stringTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(Quick3stringTest.class);
	}

	public void test1() {
		Quick3string msd = new Quick3string();
		String[] a = new String[] { "she", "sells", "seashells", "by", "the", "seashore", "the", "shells", "she", "sells", "are", "surely", "seashells" };
		msd.sort(a);
		System.out.println(Arrays.toString(a));
	}

}
