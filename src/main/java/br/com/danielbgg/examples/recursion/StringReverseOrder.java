package br.com.danielbgg.examples.recursion;

public class StringReverseOrder {

	public static void main(String[] args) {
		String a = "Daniel";
		reverse(a, a.length());
	}

	public static void reverse(String s, int n) {
		if (n == 0) {
			return;
		} else {
			System.out.print(s.charAt(n - 1));
			reverse(s, n - 1);
		}
	}

}
