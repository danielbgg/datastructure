package br.com.danielbgg.algs4.string;

import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class MSDTest extends TestCase {

	public MSDTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(MSDTest.class);
	}

	public void test1() {
		MSD msd = new MSD();
		String[] a = new String[] { "she", "sells", "seashells", "by", "the", "seashore", "the", "shells", "she", "sells", "are", "surely", "seashells" };
		msd.sort(a);
		System.out.println(Arrays.toString(a));
	}

}
