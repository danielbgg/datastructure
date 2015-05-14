package br.com.danielbgg.algs4.string;

/**
 * The constructor in this substring search algorithm builds a table giving the
 * rightmost occurrence in the pattern of each possible character. The search
 * method scans from right to left in the pattern, skipping to align any
 * character causing a mismatch with its rightmost occurrence in the pattern.
 * 
 * Property O. On typical inputs, substring search with the Boyer-Moore
 * mismatched character heuristic uses ~N M character compares to search for a
 * pattern of length M in a text of length N.
 * 
 * Discussion: This result can be proved for various random string models, but
 * such models tend to be unrealistic, so we shall skip the details. In many
 * practical situations it is true that all but a few of the alphabet characters
 * appear nowhere in the pattern, so nearly all compares lead to M characters
 * being skipped, which gives the stated result.
 */
public class BoyerMoore {

	private int[] right;
	private String pat;

	public BoyerMoore(String pat) { // Compute skip table.
		this.pat = pat;
		int M = pat.length();
		int R = 256;
		right = new int[R];
		for (int c = 0; c < R; c++)
			right[c] = -1; // -1 for chars not in pattern
		for (int j = 0; j < M; j++)
			// rightmost position for
			right[pat.charAt(j)] = j; // chars in pattern
	}

	public int search(String txt) { // Search for pattern in txt.
		int N = txt.length();
		int M = pat.length();
		int skip;
		for (int i = 0; i <= N - M; i += skip) { // Does the pattern match the
			                                     // text at position i ?
			skip = 0;
			for (int j = M - 1; j >= 0; j--)
				if (pat.charAt(j) != txt.charAt(i + j)) {
					skip = j - right[txt.charAt(i + j)];
					if (skip < 1)
						skip = 1;
					break;
				}
			if (skip == 0)
				return i; // found.
		}
		return N; // not found.
	}

}
