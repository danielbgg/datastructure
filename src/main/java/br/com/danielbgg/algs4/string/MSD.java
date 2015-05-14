package br.com.danielbgg.algs4.string;

/**
 * To sort an array a[] of strings, we sort them on their first character using
 * key-indexed counting, then (recursively) sort the subarrays corresponding to
 * each first-character value.
 *
 * Proposition C. To sort N random strings from an R-character alphabet, MSD
 * string sort examines about N log R N characters, on average.
 * 
 * Proof sketch: We expect the subarrays to be all about the same size, so the
 * recurrence C N = RCN/R + N approximately describes the performance, which
 * leads to the stated result, generalizing our argument for quicksort in
 * Chapter 2. Again, this description of the situation is not entirely accurate,
 * because N/R is not necessarily an integer, and the subarrays are the same
 * size only on the average (and because the number of characters in real keys
 * is finite). These effects turn out to be less significant for MSD string sort
 * than for standard quicksort, so the leading term of the running time is the
 * solution to this recurrence. The detailed analysis that proves this fact is a
 * classical example in the analysis of algorithms, first done by Knuth in the
 * early 1970s.
 * 
 * Proposition D. MSD string sort uses between 8N + 3R and ~7wN + 3WR array
 * accesses to sort N strings taken from an R-character alphabet, where w is the
 * average string length.
 * 
 * Proof: Immediate from the code, Proposition A, and Proposition B. In the best
 * case MSD sort uses just one pass; in the worst case, it performs like LSD
 * string sort.
 * 
 * Proposition D (continued). To sort N strings taken from an R-character
 * alphabet, the amount of space needed by MSD string sort is proportional to R
 * times the length of the longest string (plus N ), in the worst case.
 * 
 * Proof: The count[] array must be created within sort(), so the total amount
 * of space needed is proportional to R times the depth of recursion (plus N for
 * the auxiliary array). Precisely, the depth of the recursion is the length of
 * the longest string that is a prefix of two or more of the strings to be
 * sorted.
 */
public class MSD {

	// radix
	private static int R = 256;

	// cutoff for small subarrays
	private static final int M = 15;

	// auxiliary array for distribution
	private static String[] aux;

	public MSD() {
	}

	private static int charAt(String s, int d) {
		if (d < s.length())
			return s.charAt(d);
		else
			return -1;
	}

	public void sort(String[] a) {
		int N = a.length;
		aux = new String[N];
		sort(a, 0, N - 1, 0);
	}

	// Sort from a[lo] to a[hi], starting at the dth character.
	private void sort(String[] a, int lo, int hi, int d) {
		if (hi <= lo + M) {
			insertion(a, lo, hi, d);
			return;
		}
		int[] count = new int[R + 2]; // Compute frequency counts.
		for (int i = lo; i <= hi; i++)
			count[charAt(a[i], d) + 2]++;
		for (int r = 0; r < R + 1; r++)
			// Transform counts to indices.
			count[r + 1] += count[r];
		for (int i = lo; i <= hi; i++)
			// Distribute.
			aux[count[charAt(a[i], d) + 1]++] = a[i];
		for (int i = lo; i <= hi; i++)
			// Copy back.
			a[i] = aux[i - lo];
		// Recursively sort for each character value.
		for (int r = 0; r < R; r++)
			sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);
	}

	// insertion sort a[lo..hi], starting at dth character
	private void insertion(String[] a, int lo, int hi, int d) {
		for (int i = lo; i <= hi; i++)
			for (int j = i; j > lo && less(a[j], a[j - 1], d); j--)
				exch(a, j, j - 1);
	}

	// exchange a[i] and a[j]
	private void exch(String[] a, int i, int j) {
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// is v less than w, starting at character d
	private boolean less(String v, String w, int d) {
		// assert v.substring(0, d).equals(w.substring(0, d));
		for (int i = d; i < Math.min(v.length(), w.length()); i++) {
			if (v.charAt(i) < w.charAt(i))
				return true;
			if (v.charAt(i) > w.charAt(i))
				return false;
		}
		return v.length() < w.length();
	}

}
