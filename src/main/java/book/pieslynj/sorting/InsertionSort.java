package book.pieslynj.sorting;

//Insertion sort is another simple sorting algorithm. It builds a sorted array (or list) one element at a time by comparing each new element to the already-sorted elements and inserting the new element into the correct location, similar to the way you sort a hand of playing cards.
//Unlike selection sort, the best-case running time for insertion sort is O(n), which occurs when the list is already sorted. This means insertion sort is an efficient way to add new elements to a presorted list. The average and worst cases are both O(n2), however, so it’s not the best algorithm to use for large amounts of randomly ordered data.
//Insertion sort is a stable, in-place sorting algorithm especially suitable for sorting small data sets and is often used as a building block for other, more complicated sorting algorithms.
public class InsertionSort {

	// Sort an array using a simple insertion sort.
	public void insertionSort(int[] data) {
		for (int which = 1; which < data.length; ++which) {
			int val = data[which];
			for (int i = 0; i < which; ++i) {
				if (data[i] > val) {
					System.arraycopy(data, i, data, i + 1, which - i);
					data[i] = val;
					break;
				}
			}
		}
	}
}
