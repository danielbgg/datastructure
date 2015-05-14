package br.com.danielbgg.algs4.string;

import edu.princeton.cs.algs4.Queue;

/**
 * A data structure built from the characters of the string keys that allows us
 * to use the characters of the search key to guide the search. The name “trie”
 * is a bit of wordplay introduced by E. Fredkin in 1960 because the data
 * structure is used for retrieval, but we pronounce it “try” to avoid confusion
 * with “tree.”
 * 
 * This code uses an R-way trie to implement a symbol table. Additional methods
 * in the string symboltable API of page 730 are presented in the next several
 * pages. Modifying this code to handle keys from specialized alphabets is
 * straighforward (see page 740). The value in Node has to be an Object because
 * Java does not support arrays of generics; we cast values back to Value in
 * get().
 * 
 * Proposition F. The linked structure (shape) of a trie is independent of the
 * key insertion/deletion order: there is a unique trie for any given set of
 * keys.
 * 
 * Proof: Immediate, by induction on the subtries.
 * 
 * Proposition G. The number of array accesses when searching in a trie or
 * inserting a key into a trie is at most 1 plus the length of the key.
 * 
 * Proof: Immediate from the code. The recursive get() and put() implementations
 * carry an argument d that starts at 0, increments for each call, and is used
 * to stop the recursion when it reaches the key length.
 * 
 * Proposition H. The average number of nodes examined for search miss in a trie
 * built from N random keys over an alphabet of size R is ~log R N .
 * 
 * Proposition I. The number of links in a trie is between RN and RNw, where w
 * is the average key length.
 * 
 * Proof: Every key in the trie has a node containing its associated value that
 * also has R links, so the number of links is at least RN. If the first
 * characters of all the keys are different, then there is a node with R links
 * for every key character, so the number of links is R times the total number
 * of key characters, or RNw.
 */
public class TrieST<Value> {

	// radix
	private static int R = 256;

	// root of trie
	private Node root;

	private static class Node {
		private Object val;
		private Node[] next = new Node[R];
	}

	public Value get(String key) {
		Node x = get(root, key, 0);
		if (x == null)
			return null;
		return (Value) x.val;
	}

	// Return value associated with key in the subtrie rooted at x.
	private Node get(Node x, String key, int d) {
		if (x == null)
			return null;
		if (d == key.length())
			return x;
		// Use dth key char to identify subtrie.
		char c = key.charAt(d);
		return get(x.next[c], key, d + 1);
	}

	public void put(String key, Value val) {
		root = put(root, key, val, 0);
	}

	// Change value associated with key if in subtrie rooted at x.
	private Node put(Node x, String key, Value val, int d) {
		if (x == null)
			x = new Node();
		if (d == key.length()) {
			x.val = val;
			return x;
		}
		// Use dth key char to identify subtrie.
		char c = key.charAt(d);
		x.next[c] = put(x.next[c], key, val, d + 1);
		return x;
	}

	public Iterable<String> keys() {
		return keysWithPrefix("");
	}

	public Iterable<String> keysWithPrefix(String pre) {
		Queue<String> q = new Queue<String>();
		collect(get(root, pre, 0), pre, q);
		return q;
	}

	private void collect(Node x, String pre, Queue<String> q) {
		if (x == null)
			return;
		if (x.val != null)
			q.enqueue(pre);
		for (char c = 0; c < R; c++)
			collect(x.next[c], pre + c, q);
	}

	public Iterable<String> keysThatMatch(String pat) {
		Queue<String> q = new Queue<String>();
		collect(root, "", pat, q);
		return q;
	}

	public void collect(Node x, String pre, String pat, Queue<String> q) {
		int d = pre.length();
		if (x == null)
			return;
		if (d == pat.length() && x.val != null)
			q.enqueue(pre);
		if (d == pat.length())
			return;
		char next = pat.charAt(d);
		for (char c = 0; c < R; c++)
			if (next == '.' || next == c)
				collect(x.next[c], pre + c, pat, q);
	}

	public String longestPrefixOf(String s) {
		int length = search(root, s, 0, 0);
		return s.substring(0, length);
	}

	private int search(Node x, String s, int d, int length) {
		if (x == null)
			return length;
		if (x.val != null)
			length = d;
		if (d == s.length())
			return length;
		char c = s.charAt(d);
		return search(x.next[c], s, d + 1, length);
	}

	public void delete(String key) {
		root = delete(root, key, 0);
	}

	private Node delete(Node x, String key, int d) {
		if (x == null)
			return null;
		if (d == key.length())
			x.val = null;
		else {
			char c = key.charAt(d);
			x.next[c] = delete(x.next[c], key, d + 1);
		}
		if (x.val != null)
			return x;
		for (char c = 0; c < R; c++)
			if (x.next[c] != null)
				return x;
		return null;
	}
}
