package br.com.danielbgg.datastructure.sorting;

//Merge sort is another divide-and-conquer algorithm that works by splitting a data set into two or more subsets, sorting the subsets, and then merging them together into the final sorted set.
//Most of the work is done in the merge method, which combines two sorted arrays into a larger sorted array.
//A hybrid merge sort occurs when a different sorting algorithm is used to sort subsets below a specified minimum size. For example, you can transform the mergeSortSimple method into a hybrid algorithm by replacing the termination condition:
//if( data.length < 2 ){
//    return data;
//}
//with an insertion sort:
//if( data.length < 10 ){ // some small empirically determined value
//    insertionSort( data );
//    return data;
//}
//This is a common optimization because insertion sort has lower overhead than merge sort and typically has better performance on very small data sets.
//Unlike most other sorting algorithms, merge sort is a good choice for data sets that are too large to fit into memory. In a typical scenario, the contents of a large file are split into multiple smaller files. Each of the smaller files is read into memory, sorted using an appropriate algorithm, and written back out. A merge operation is then performed using the sorted files as input and the sorted data is written directly to the final output file.
//The best, average, and worst-case running times for merge sort are all O(n log(n)), which is great when you need a guaranteed upper bound on the sorting time. However, merge sort requires O(n) additional memory — substantially more than many other algorithms.
//Typical (maximally efficient) merge sort implementations are stable but not in-place.
public class MergeSort {

	// Sort an array using a simple but inefficient merge sort.
	public int[] mergeSortSimple(int[] data) {

		if (data.length < 2) {
			return data;
		}

		// Split the array into two subarrays of approx equal size.

		int mid = data.length / 2;
		int[] left = new int[mid];
		int[] right = new int[data.length - mid];

		System.arraycopy(data, 0, left, 0, left.length);
		System.arraycopy(data, mid, right, 0, right.length);

		// Sort each subarray, then merge the result.

		mergeSortSimple(left);
		mergeSortSimple(right);

		return merge(data, left, right);
	}

	// Merge two smaller arrays into a larger array.
	private int[] merge(int[] dest, int[] left, int[] right) {
		int dind = 0;
		int lind = 0;
		int rind = 0;

		// Merge arrays while there are elements in both
		while (lind < left.length && rind < right.length) {
			if (left[lind] <= right[rind]) {
				dest[dind++] = left[lind++];
			} else {
				dest[dind++] = right[rind++];
			}
		}

		// Copy rest of whichever array remains
		while (lind < left.length)
			dest[dind++] = left[lind++];

		while (rind < right.length)
			dest[dind++] = right[rind++];

		return dest;
	}
}
