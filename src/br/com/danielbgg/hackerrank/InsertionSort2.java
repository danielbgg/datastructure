package br.com.danielbgg.hackerrank;

import java.util.Arrays;

public class InsertionSort2 {

	public static void insertionSortPart2(int[] ar) {
		System.out.println("New insert sort: " + Arrays.toString(ar));
		for (int i = 0; i < ar.length; i++) {
			insertIntoSorted(ar, i + 1);
			if (i > 0) {
				printArray(ar);
			}
		}
	}

	public static void insertIntoSorted(int[] ar, int lenght) {
		if (ar.length == 1) {
			return;
		}

		int target = ar[lenght - 1];
		for (int i = lenght - 2; i >= 0; i--) {
			int value = ar[i];
			if (target < value) {
				ar[i + 1] = value;
			} else {
				ar[i + 1] = target;
				return;
			}
		}

		if (target < ar[0]) {
			ar[0] = target;
		}
	}

	/* Tail starts here */
	public static void main(String[] args) {
		insertionSortPart2(new int[] { 1, 4, 3, 5, 6, 2 });
		insertionSortPart2(new int[] { 3 });
		insertionSortPart2(new int[] { 3, 1 });
		insertionSortPart2(new int[] { 9, 1, 3, 8, 7, 5 });
	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

}
