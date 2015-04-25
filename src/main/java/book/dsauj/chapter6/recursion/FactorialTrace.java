package book.dsauj.chapter6.recursion;

public class FactorialTrace {
	public static int count = 0;
	public static int time = 0;

	public static long nFactorialTrace(long n) {
		long value;
		count++;
		time++;
		System.out.println("at time " + time);
		System.out.println("\tnFactorial has been INVOKED for the " + count + "th time," + " with n = to " + n);
		if (n == 0) {
			time++;
			System.out.println("\nat time " + time);
			System.out.println("\tRETURNING 0! = 1" + " from the " + count-- + "th invocation of nFactorial");
			return 1;
		} else {
			System.out.println("\tnFractorial is INVOKING ITSELF with n = to " + (n - 1));
			value = n * nFactorialTrace(n - 1);
			time++;
			System.out.println("at time " + time);
			System.out.println("\tRETURNING " + n + "! = " + value + " from the " + count-- + "th invocation of nFactorial");
			return value;
		}
	}// end of the method nFactorialTrace
}// end of the class

