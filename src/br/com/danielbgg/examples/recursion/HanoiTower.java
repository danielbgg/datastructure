package br.com.danielbgg.examples.recursion;

public class HanoiTower {

	public static void main(String[] args) {
		hanoi(3, 1, 2, 3);
	}

	public static void hanoi(int n, int S, int D, int E) {
		if (n == 1) {
			// base case
			System.out.println("move 1 ring from tower: " + S + " to tower: " + D);
		} else {
			// general solution
			hanoi(n - 1, S, E, D);
			System.out.println("move 1 ring from tower: " + S + " to tower: " + D);
			// reduced problem
			hanoi(n - 1, E, D, S);
		}
	}

}
