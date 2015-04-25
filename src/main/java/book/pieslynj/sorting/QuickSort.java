package book.pieslynj.sorting;

//Quicksort is a divide-and-conquer algorithm that involves choosing a pivot value from a data set and splitting the set into two subsets: a set that contains all values less than the pivot and a set that contains all values greater than or equal to the pivot. The pivot/split process is recursively applied to each subset until there are no more subsets to split. The results are combined to form the final sorted set.
//The preceding code illustrates the principles of quicksort, but it’s not a particularly efficient implementation due to scanning the starting array twice, allocating new arrays, and copying results from the new arrays to the original.
//Quicksort’s performance is dependent on the choice of pivot value. The ideal pivot value is one that splits the original data set into two subsets of identical (or nearly identical) size. Every time you do a pivot-and-split, you perform constant-time operations on each of the elements involved. How many times do you do this for each element? In the best case, the size of a sublist is halved on each successive recursive call, and the recursion terminates when the sublist size is 1. This means the number of times you operate on an element is equal to the number of times you can divide n by 2 before reaching one: log(n). Performing log(n) operations on each of n elements yields a combined best case complexity of O(n log(n)).
//On the other hand, what if your pivot choice is poor? In the worst case, the pivot is the minimum value in the data set, which means that one subset is empty and the other subset contains n – 1 items (all the items except for the pivot). The number of recursive calls is then O(n) (analogous to a completely unbalanced tree degrading to a linked list), which gives a combined worst-case complexity of O(n2). This is the same as selection sort or insertion sort.
//On average almost any pivot value will split a data set into two non-empty subsets, making the number of recursive calls fall somewhere between O(log(n)) and O(n). A bit of mathematical work (omitted here) is enough to show that in most cases the number of times you operate on an element is still O(log(n)), so the average case complexity of quicksort is also O(n log(n)).
//For truly randomly ordered data, the value of the pivot is unrelated to its location, so you can choose a pivot from any location because they’re all equally likely to be good choices. But if the data is already sorted (or mostly sorted), choosing the value located in the middle of the data set ensures that each subset contains approximately half the data, which gives guaranteed O(n log(n)) complexity for sorted data. Because the value in the middle location is the best choice for ordered data and no worse than any other for unordered data, most quicksort implementations use it as the pivot.
//Like the preceding implementation, most implementations of quicksort are not stable.
public class QuickSort {

	// Sort an array using a simple but inefficient quicksort.
	public int[] quicksortSimple(int[] data) {

		if (data.length < 2) {
			return data;
		}

		int pivotIndex = data.length / 2;
		int pivotValue = data[pivotIndex];

		int leftCount = 0;

		// Count how many are less than the pivot

		for (int i = 0; i < data.length; ++i) {
			if (data[i] < pivotValue)
				++leftCount;
		}

		// Allocate the arrays and create the subsets

		int[] left = new int[leftCount];
		int[] right = new int[data.length - leftCount - 1];

		int l = 0;
		int r = 0;

		for (int i = 0; i < data.length; ++i) {
			if (i == pivotIndex)
				continue;

			int val = data[i];

			if (val < pivotValue) {
				left[l++] = val;
			} else {
				right[r++] = val;
			}
		}

		// Sort the subsets

		left = quicksortSimple(left);
		right = quicksortSimple(right);

		// Combine the sorted arrays and the pivot back into the original array

		System.arraycopy(left, 0, data, 0, left.length);
		data[left.length] = pivotValue;
		System.arraycopy(right, 0, data, left.length + 1, right.length);

		return data;
	}
}
