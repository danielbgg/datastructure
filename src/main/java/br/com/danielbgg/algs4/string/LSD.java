package br.com.danielbgg.algs4.string;

/**
 * To sort an array a[] of strings that each have exactly W characters, we do W
 * key-indexed counting sorts: one for each character position, proceeding from
 * right to left.
 * 
 * Proposition B. LSD string sort stably sorts fixed-length strings.
 * 
 * Proof: This fact depends crucially on the key-indexed counting implementation
 * being stable, as indicated in Proposition A. After sorting keys on their i
 * trailing characters (in a stable manner), we know that any two keys appear in
 * proper order in the array (considering just those characters) either because
 * the first of their i trailing characters is different, in which case the sort
 * on that character puts them in order, or because the first of their ith
 * trailing characters is the same, in which case they are in order because of
 * stability (and by induction, for i-1).
 * 
 * Proposition B (continued). LSD string sort uses ~7WN  3WR array accesses and
 * extra space proportional to N R to sort N items whose keys are W-character
 * strings taken from an R-character alphabet.
 * 
 * Proof: The method is W passes of key-indexed counting, except that the aux[]
 * array is initialized just once. The total is immediate from the code and
 * Proposition A.
 */
public class LSD {

	public LSD() {
	}

	// sort a[] on leading W characters
	public void sort(String[] a, int W) {
		int N = a.length;
		int R = 256;
		String[] aux = new String[N];

		// sort by key-indexed counting on dth char
		for (int d = W - 1; d >= 0; d--) {

			// compute frequency counts
			int[] count = new int[R + 1];
			for (int i = 0; i < N; i++) {
				count[a[i].charAt(d) + 1]++;
			}

			// transform counts to indices
			for (int r = 0; r < R; r++) {
				count[r + 1] += count[r];
			}

			// distribute
			for (int i = 0; i < N; i++) {
				aux[count[a[i].charAt(d)]++] = a[i];
			}

			// copy back
			for (int i = 0; i < N; i++) {
				a[i] = aux[i];
			}
		}
	}

}
