package br.com.danielbgg.examples.sorting;

import java.util.Arrays;
import java.util.Date;

/*
 * A merge sort works recursively. First it divides a data set in half, and sorts each half separately. Next, the first elements from each of the two lists are compared. The lesser element is then removed from its list and added to the final result list.
 * Each recursive call has O(n) runtime, and a total of O(log n) recursions are required, thus the runtime of this algorithm is O(n * log n). A merge sort can also be modified for performance on lists that are nearly sorted to begin with. After sorting each half of the data, if the highest element in one list is less than the lowest element in the other half, then the merge step is unnecessary. (The Java API implements this particular optimization, for instance.) The data, as the process is called recursively, might look like this:
 * Apart from being fairly efficient, a merge sort has the advantage that it can be used to solve other problems, such as determining how “unsorted” a given list is.
 */
public class ExemploMergeSort {

	public static void main(String[] args) {
		int[] data = { 15, 23, 43, 57, 17, 0, 60, 39, 13, 155, 2, 3, 56 };
		System.out.println("Dados iniciais: " + Arrays.toString(data));
		long time1 = (new Date()).getTime();
		data = mergeSort(data);
		long time2 = (new Date()).getTime();
		System.out.println("Dados finais: " + Arrays.toString(data));
		System.out.println("Tempo: " + (time2 - time1));
	}

	public static int[] mergeSort(int[] data) {
		System.out.println("Tamanho do array: " + data.length);

		if (data.length == 1)
			return data;

		int middle = data.length / 2;

		int[] l1 = Arrays.copyOfRange(data, 0, middle);
		System.out.println("l1: " + Arrays.toString(l1));

		int[] left = mergeSort(l1);
		System.out.println("left: " + Arrays.toString(left));

		int[] r1 = Arrays.copyOfRange(data, middle, data.length);
		System.out.println("r1: " + Arrays.toString(r1));

		int[] right = mergeSort(r1);
		System.out.println("right: " + Arrays.toString(right));

		int[] result = new int[data.length];
		int dPtr = 0;
		int lPtr = 0;
		int rPtr = 0;
		while (dPtr < data.length) {
			if (lPtr == left.length) {
				result[dPtr] = right[rPtr];
				rPtr++;
			} else if (rPtr == right.length) {
				result[dPtr] = left[lPtr];
				lPtr++;
			} else if (left[lPtr] < right[rPtr]) {
				result[dPtr] = left[lPtr];
				lPtr++;
			} else {
				result[dPtr] = right[rPtr];
				rPtr++;
			}
			dPtr++;
		}
		return result;

	}

}
