package br.com.danielbgg.datastructure.sorting;

//PROBLEM Implement an efficient, in-place version of the quicksort algorithm.
//Select a pivot
//Start the current position at the first element
//Start the head of G at the last element
//While current position < head of G
//    If the current element <= pivot
//        Swap current element with head of G and advance head of G
//    Else
//        Advance current position
//Recursively call the routine on the L and G segments of the array
public class QuickSortOtimized {

	public void quicksortOptimized(int[] data) {
		quicksortOptimized(data, 0, data.length - 1);
	}

	public void quicksortOptimized(int[] data, int left, int right) {
		int pivotValue = data[(left + right) / 2];
		int i = left;
		int j = right;

		while (i <= j) {
			// Find leftmost value greater than or equal to the pivot.
			while (data[i] < pivotValue)
				i++;

			// Find rightmost value less than or equal to the pivot.
			while (data[j] > pivotValue)
				j--;

			// If the values are in the wrong order, swap them.
			if (i <= j) {
				swap(data, i, j);
				i++;
				j--;
			}
		}

		// Apply the algorithm to the partitions we made, if any.

		if (left < j) {
			quicksortOptimized(data, left, j);
		}

		if (i < right) {
			quicksortOptimized(data, i, right);
		}
	}

	private void swap(int[] data, int i, int j) {
		int old = data[i];
		data[i] = data[j];
		data[j] = old;
	}
}
