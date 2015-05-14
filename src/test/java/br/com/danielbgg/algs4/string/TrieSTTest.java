package br.com.danielbgg.algs4.string;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import edu.princeton.cs.algs4.StdOut;

public class TrieSTTest extends TestCase {

	public TrieSTTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(TrieSTTest.class);
	}

	public void test1() {
		TrieST t = new TrieST();
		t.put("she", 0);
		t.put("sells", 1);
		t.put("sea", 2);
		t.put("shells", 3);
		t.put("by", 4);
		t.put("the", 5);
		t.put("sea", 6);
		t.put("shore", 7);

		print("all keys", t.keys());
		print("keys with prefix: space", t.keysWithPrefix(""));
		print("keys with prefix: sh", t.keysWithPrefix("sh"));

		print("keys that match: sh.", t.keysThatMatch("sh."));

		print("longest prefix of: shellsort", t.longestPrefixOf("shellsort"));
		print("longest prefix of: moon", t.longestPrefixOf("moon"));

	}

	private void print(String desc, Iterable<String> i) {
		StdOut.println("Description: " + desc);
		for (String string : i) {
			StdOut.println("Key: " + string);
		}
		StdOut.println();
	}

	private void print(String desc, String i) {
		StdOut.println("Description: " + desc);
		StdOut.println("Key: " + i);
		StdOut.println();
	}

}
