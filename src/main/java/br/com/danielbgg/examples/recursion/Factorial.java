package br.com.danielbgg.examples.recursion;

import java.util.Arrays;

public class Factorial {

	public static long nFactorial(long n) {
		System.out.println("fatorial de: " + n);
		if (n == 0) {
			return 1;
		} else {
			long retorno = n * (nFactorial(n - 1));
			System.out.println("retorno: " + retorno);
			return retorno;
		}
	}

	public static int[] allFactorials(int n) { /* Wrapper function */
		int[] results = new int[n == 0 ? 1 : n];
		doAllFactorials(n, results, 0);
		return results;
	}

	private static int doAllFactorials(int n, int[] results, int level) {
		if (n > 1) { /* Recursive case */
			results[level] = n * doAllFactorials(n - 1, results, level + 1);
			return results[level];
		} else { /* Base case */
			results[level] = 1;
			return 1;
		}
	}

	public int iterateFactorial(int n) {
		int i, val = 1;
		for (i = n; i > 1; i--)
			/* n = 0 or 1 falls through */
			val *= i;
		return val;
	}

	public static void main(String[] args) {
		System.out.println(nFactorial(5));
		//System.out.println(Arrays.toString(allFactorials(10)));
	}

}
