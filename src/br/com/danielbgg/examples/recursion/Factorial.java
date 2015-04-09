package br.com.danielbgg.examples.recursion;

public class Factorial {

	public static void main(String[] args) {
		System.out.println(nFactorial(10));
	}

	public static long nFactorial(long n) {
		System.out.println("fatorial de: " + n);
		long minus1;
		if (n == 0) {
			return 1;
		} else {
			minus1 = nFactorial(n - 1);
			long retorno = n * minus1;
			System.out.println("retorno: " + retorno);
			return retorno;
		}

	}

}
