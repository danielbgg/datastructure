package br.com.danielbgg.algs4.string;

import java.math.BigInteger;
import java.util.Random;

/**
 * This substring search algorithm is based on hashing. It computes a hash value
 * for the pattern in the constructor, then searches through the text looking
 * for a hash match.
 * 
 * Property P. The Monte Carlo version of Rabin-Karp substring search is
 * linear-time and extremely likely to be correct, and the Las Vegas version of
 * Rabin-Karp substring search is correct and extremely likely to be
 * linear-time.
 * 
 * Discussion: The use of the very large value of Q, made possible by the fact
 * that we need not maintain an actual hash table, makes it extremely unlikely
 * that a collision will occur. Rabin and Karp showed that when Q is properly
 * chosen, we get a hash collision for random strings with probability 1/Q,
 * which implies that, for practical values of the variables, there are no hash
 * matches when there are no substring matches and only one hash match if there
 * is a substring match. Theoretically, a text position could lead to a hash
 * collision and not a substring match, but in practice it can be relied upon to
 * find a match.
 */
public class RabinKarp {
	private String pat; // pattern (only needed for Las Vegas)
	private long patHash; // pattern hash value
	private int M; // pattern length
	private long Q; // a large prime
	private int R = 256; // alphabet size
	private long RM; // R^(M-1) % Q

	public RabinKarp(String pat) {
		this.pat = pat; // save pattern (only needed for Las Vegas)
		this.M = pat.length();
		Q = longRandomPrime(); // See Exercise 5.3.33.
		RM = 1;
		for (int i = 1; i <= M - 1; i++)
			// Compute R^(M-1) % Q for use
			RM = (R * RM) % Q; // in removing leading digit.
		patHash = hash(pat, M);
	}

	public boolean check(int i) // Monte Carlo (See text.)
	{
		return true;
	} // For Las Vegas, check pat vs txt(i..i-M+1).

	private long hash(String key, int M) { // Compute hash for key[0..M-1].
		long h = 0;
		for (int j = 0; j < M; j++)
			h = (R * h + key.charAt(j)) % Q;
		return h;
	}

	// a random 31-bit prime
	private static long longRandomPrime() {
		BigInteger prime = BigInteger.probablePrime(31, new Random());
		return prime.longValue();
	}

	public int search(String txt) { // Search for hash match in text.
		int N = txt.length();
		long txtHash = hash(txt, M);
		if (patHash == txtHash)
			return 0; // Match at beginning.
		for (int i = M; i < N; i++) { // Remove leading digit, add trailing
			                          // digit, check for match.
			txtHash = (txtHash + Q - RM * txt.charAt(i - M) % Q) % Q;
			txtHash = (txtHash * R + txt.charAt(i)) % Q;
			if (patHash == txtHash)
				if (check(i - M + 1))
					return i - M + 1; // match
		}
		return N; // no match found
	}
}