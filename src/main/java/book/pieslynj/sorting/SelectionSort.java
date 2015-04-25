package book.pieslynj.sorting;

//Selection sort is one of the simplest sorting algorithms. It starts with the first element in the array (or list) and scans through the array to find the element with the smallest key, which it swaps with the first element. The process is then repeated with each subsequent element until the last element is reached.
//This implementation could be optimized by transforming this tail-recursive procedure into an iterative implementation and inlining the two helper functions.
//How efficient is selection sort? The first swap requires n – 1 comparisons, the second n – 2, the third n – 3, and so on. This is the series (n – 1) + (n – 2) + ... + 1, which simplifies to n(n – 1)/2. This means that the algorithm is O(n2) in the best, average, and worst cases — the initial order of the data has no effect on the number of comparisons. As you’ll see later in this chapter, other sorting algorithms have more efficient running times than this.
//Selection sort does have the advantage that it requires at most n – 1 swaps. In situations in which moving data elements is more expensive than comparing them, selection sort may perform better than other algorithms. The efficiency of an algorithm depends on what you’re optimizing for.
//Selection sort is an in-place algorithm. Typical implementations of selection sort, such as the one shown here, are not stable.
public class SelectionSort {

	// Sort an array using a recursive selection sort.
	public void selectionSortRecursive(int[] data) {
		selectionSortRecursive(data, 0);
	}

	// Sort a subset of the array starting at the given index.
	private void selectionSortRecursive(int[] data, int start) {
		if (start < data.length - 1) {
			swap(data, start, findMinimumIndex(data, start));
			selectionSortRecursive(data, start + 1);
		}
	}

	// Find the position of the minimum value starting at the given index.
	private int findMinimumIndex(int[] data, int start) {
		int minPos = start;

		for (int i = start + 1; i < data.length; ++i) {
			if (data[i] < data[minPos]) {
				minPos = i;
			}
		}

		return minPos;
	}

	// Swap two elements in an array.
	private void swap(int[] data, int index1, int index2) {
		if (index1 != index2) {
			int tmp = data[index1];
			data[index1] = data[index2];
			data[index2] = tmp;
		}
	}
}
