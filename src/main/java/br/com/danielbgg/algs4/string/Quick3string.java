package br.com.danielbgg.algs4.string;

/**
 * To sort an array a[] of strings, we 3-way partition them on their first
 * character, then (recursively) sort the three resulting subarrays: the strings
 * whose first character is less than the partitioning character, the strings
 * whose first character is equal to the partitioning character (excluding their
 * first character in the sort), and the strings whose first character is
 * greater than the partitioning character.
 * 
 * Proposition E. To sort an array of N random strings, 3-way string quicksort
 * uses ~ 2N ln N character compares, on the average.
 * 
 * Proof: There are two instructive ways to understand this result. First,
 * considering the method to be equivalent to quicksort partitioning on the
 * leading character, then (recursively) using the same method on the subarrays,
 * we should not be surprised that the total number of operations is about the
 * same as for normal quicksort—but they are single-character compares, not
 * full-key compares. Second, considering the method as replacing key-indexed
 * counting by quicksort, we expect that the N log R N running time from
 * Proposition D should be multiplied by a factor of 2 ln R because it takes
 * quicksort 2R ln R steps to sort R characters, as opposed to R steps for the
 * same characters in the MSD string sort. We omit the full proof.
 */
public class Quick3string {

	public Quick3string() {
	}

	private int charAt(String s, int d) {
		if (d < s.length())
			return s.charAt(d);
		else
			return -1;
	}

	public void sort(String[] a) {
		sort(a, 0, a.length - 1, 0);
	}

	private void sort(String[] a, int lo, int hi, int d) {
		if (hi <= lo)
			return;
		int lt = lo, gt = hi;
		int v = charAt(a[lo], d);
		int i = lo + 1;
		while (i <= gt) {
			int t = charAt(a[i], d);
			if (t < v)
				exch(a, lt++, i++);
			else if (t > v)
				exch(a, i, gt--);
			else
				i++;
		}
		// a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]
		sort(a, lo, lt - 1, d);
		if (v >= 0)
			sort(a, lt, gt, d + 1);
		sort(a, gt + 1, hi, d);
	}

	// exchange a[i] and a[j]
	private void exch(String[] a, int i, int j) {
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
