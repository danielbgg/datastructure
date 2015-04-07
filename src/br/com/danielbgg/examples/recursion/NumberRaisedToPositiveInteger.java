package br.com.danielbgg.examples.recursion;

public class NumberRaisedToPositiveInteger {

	public static void main(String[] args) {
		System.out.println(raise(10, 0));
	}

	public static long raise(long base, long expoent) {
		System.out.println(base + "^" + expoent);
		long minus1;
		if (expoent == 0) {
			return 1;
		} else {
			minus1 = raise(base, expoent - 1);
			long retorno = base * minus1;
			System.out.println("retorno: " + retorno);
			return retorno;
		}

	}
}
