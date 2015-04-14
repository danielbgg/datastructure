package br.com.danielbgg.hackerrank;

import java.util.Arrays;

public class InsertionSort1 {

	public static void insertIntoSorted(int[] ar) {
		System.out.println("New insert sort: " + Arrays.toString(ar));
		
		if (ar.length == 1) {
			printArray(ar);
			return;
		}

		int target = ar[ar.length - 1];
		for (int i = ar.length - 2; i >= 0; i--) {
			int value = ar[i];
			if (target < value) {
				ar[i + 1] = value;
				printArray(ar);
			} else {
				ar[i + 1] = target;
				printArray(ar);
				return;
			}
		}

		if (target < ar[0]) {
			ar[0] = target;
			printArray(ar);
		}

		// Fill up this function
	}

	/* Tail starts here */
	public static void main(String[] args) {
		insertIntoSorted(new int[] { 2, 4, 6, 8, 12 });
		insertIntoSorted(new int[] { 2, 4, 6, 8, 7 });
		insertIntoSorted(new int[] { 2, 4, 6, 8, 5 });
		insertIntoSorted(new int[] { 2, 4, 6, 8, 1 });
		insertIntoSorted(new int[] { 2, 4, 6, 8, 3 });
		insertIntoSorted(new int[] { 5, 3 });
		insertIntoSorted(new int[] { 3, 5 });
	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

}
