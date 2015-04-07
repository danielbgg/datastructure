package br.com.danielbgg.examples.recursion;

import java.util.Date;

/*
 * Problem: calculate the nth term of the Fibonnacci sequence, fn
 * 
 * Base case: f1 = 1; f2 = 1;
 * 
 * Reduced problem: fn-1 and fn-2
 * 
 * General solution: fn = fn-1 + fn-2
 */
public class FibonacciSequence {

	public static void main(String[] args) {
		long time1 = (new Date()).getTime();
		System.out.println(fibonnaci(45));
		long time2 = (new Date()).getTime();
		System.out.println("Tempo: " + (time2 - time1) + " ms");
	}

	public static long fibonnaci(int n) {
		long[] cache = new long[45];
		long ret = fibonnaciInternal(n, cache);
		for (int i = 0; i < cache.length; i++) {
			System.out.println("cache[" + i + "] = " + cache[i]);
		}
		return ret;
	}

	private static long fibonnaciInternal(int n, long[] cache) {
		// System.out.println("fibonnaci de f(" + n + ")");
		if (n == 1 || n == 2) {
			return 1;
		} else {
			long rp1 = 0;
			long rp2 = 0;
			if (cache[n - 1] == 0) {
				rp1 = fibonnaciInternal(n - 1, cache);
				cache[n - 1] = rp1;
			} else {
				rp1 = cache[n - 1];
			}
			if (cache[n - 2] == 0) {
				rp2 = fibonnaciInternal(n - 2, cache);
				cache[n - 2] = rp2;
			} else {
				rp2 = cache[n - 2];
			}
			long gs = rp1 + rp2;
			// System.out.println("retorno: " + gs);
			return gs;
		}
	}

}
