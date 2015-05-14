package br.com.danielbgg.algs4.string;

/**
 * This implementation uses a char value c and three links per node to build
 * string search tries where subtries have keys whose first character is less
 * than c (left), equal to c (middle), and greater than c (right).
 * 
 * Proposition J. The number of links in a TST built from N string keys of
 * average length w is between 3N and 3Nw.
 * 
 * Proof. Immediate, by the same argument as for Proposition I.
 * 
 * Proposition K. A search miss in a TST built from N random string keys
 * requires ~ln N character compares, on the average. A search hit or an
 * insertion in a TST uses a character compare for each character in the search
 * key.
 * 
 * Proof: The search hit/insertion cost is immediate from the code. The search
 * miss cost is a consequence of the same arguments discussed in the proof
 * sketch of Proposition H. We assume that all but a constant number of the
 * nodes on the search path (a few at the top) act as random BSTs on R character
 * values with average path length ln R, so we multiply the time cost logR N =
 * ln N / ln R by ln R.
 * 
 * Proposition L. A search or an insertion in a TST built from N random string
 * keys with no external one-way branching and R t-way branching at the root
 * requires roughly ln N - t ln R character compares, on the average.
 * 
 * Proof: These rough estimates follow from the same argument we used to prove
 * Proposition K. We assume that all but a constant number of the nodes on the
 * search path (a few at the top) act as random BSTs on R character values, so
 * we multiply the time cost by ln R.
 */
public class TST<Value> {

	// root of trie
	private Node root;

	private class Node {
		// character
		char c;
		// left, middle, and right subtries
		Node left, mid, right;
		// value associated with string
		Value val;
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
		char c = key.charAt(d);
		if (c < x.c)
			return get(x.left, key, d);
		else if (c > x.c)
			return get(x.right, key, d);
		else if (d < key.length() - 1)
			return get(x.mid, key, d + 1);
		else
			return x;
	}

	public void put(String key, Value val) {
		root = put(root, key, val, 0);
	}

	private Node put(Node x, String key, Value val, int d) {
		char c = key.charAt(d);
		if (x == null) {
			x = new Node();
			x.c = c;
		}
		if (c < x.c)
			x.left = put(x.left, key, val, d);
		else if (c > x.c)
			x.right = put(x.right, key, val, d);
		else if (d < key.length() - 1)
			x.mid = put(x.mid, key, val, d + 1);
		else
			x.val = val;
		return x;
	}
}
