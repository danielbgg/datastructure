package br.com.danielbgg.algs4.string;

/**
 * Proposition M. Brute-force substring search requires ~NM character compares
 * to search for a pattern of length M in a text of length N, in the worst case.
 * 
 * Proof: A worst-case input is when both pattern and text are all As followed
 * by a B. Then for each of the N- M + 1 possible match positions, all the
 * characters in the pattern are checked against the text, for a total cost of
 * M(N- M + 1). Normally M is very small compared to N, so the total is ~NM.
 */
public class BruteForceSubstring {

	public static int search(String pat, String txt) {
		int M = pat.length();
		int N = txt.length();
		for (int i = 0; i <= N - M; i++) {
			int j;
			for (j = 0; j < M; j++)
				if (txt.charAt(i + j) != pat.charAt(j))
					break;
			if (j == M)
				return i; // found
		}
		return N; // not found
	}

	public static int searchWithBackup(String pat, String txt) {
		int j, M = pat.length();
		int i, N = txt.length();
		for (i = 0, j = 0; i < N && j < M; i++) {
			if (txt.charAt(i) == pat.charAt(j))
				j++;
			else {
				i -= j;
				j = 0;
			}
		}
		if (j == M)
			return i - M; // found
		else
			return N; // not found
	}
}
