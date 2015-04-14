package book1.chapter6.recursion;

public class MainPracticeProblems {
	public static void main(String[] args) {
		System.out.println(xToN(12.3, 3));
		System.out.println(fibonacci(5));
		stringReverse("a", 1);
		hanoi(3, 1, 2, 3);
	}

	public static double xToN(double x, int n) {
		if (n == 0) // base case
			return 1;
		else {
			double rp = xToN(x, n - 1); // calculate the reduced problem
										// (recursion)
			double gs = x * rp; // calculate the general solution
			return gs; // return the general solution
		}
	}

	public static long fibonacci(int n) {
		if (n == 1 || n == 2) // one of 2 base cases
			return 1;
		else {
			long rp1 = fibonacci(n - 1); // first reduced problem
			long rp2 = fibonacci(n - 2); // second reduced problem
			long gs = rp1 + rp2; // general solution
			return gs;
		}
	}

	public static void stringReverse(String s, int n) {
		if (n == 0) // base case
			return;
		else // general solution
		{
			System.out.print(s.charAt(n - 1)); // output the last character
			stringReverse(s, n - 1); // reduced problem (recursion)
		}
	}

	public static void hanoi(int n, int S, int D, int E) {
		if (n == 1) // base case
			System.out.println("move 1 ring from tower " + S + " to tower " + D);
		else // general solution
		{
			hanoi(n - 1, S, E, D); // reduced problem
			System.out.println("move 1 ring from tower " + S + " to tower " + D);
			hanoi(n - 1, E, D, S); // reduced problem
		}
	}

}
