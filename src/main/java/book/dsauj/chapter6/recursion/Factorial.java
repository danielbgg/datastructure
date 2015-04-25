package book.dsauj.chapter6.recursion;

public class Factorial {
	public static long nFactorial(long n) {
		long nMinus1Factorial;
		if (n == 0)
			return (1);
		else {
			nMinus1Factorial = nFactorial(n - 1);
			return (n * nMinus1Factorial);
		}
	}
}
