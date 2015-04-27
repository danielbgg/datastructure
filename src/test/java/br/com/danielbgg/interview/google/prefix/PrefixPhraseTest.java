package br.com.danielbgg.interview.google.prefix;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PrefixPhraseTest extends TestCase {

	public PrefixPhraseTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(PrefixPhraseTest.class);
	}

	public void test1() {
		PrefixPhrase st = new PrefixPhrase();
		assertEquals(st.analyse(new String[] { "this is a long phrase", "this is a short one", "this is also a phrase" }), "this is");
	}

	public void test2() {
		PrefixPhrase st = new PrefixPhrase();
		assertEquals(st.analyse(new String[] { "this is a long phrase", "short one", "this is also a phrase" }), "");
	}

	public void test3() {
		PrefixPhrase st = new PrefixPhrase();
		assertEquals(st.analyse(new String[] {}), "");
	}

	public void test4() {
		PrefixPhrase st = new PrefixPhrase();
		assertEquals(st.analyse(new String[] { "this is a long phrase", "this is a long phrase", "this is a long phrase" }), "this is a long phrase");
	}

}
