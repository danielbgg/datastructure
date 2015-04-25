package book.dsauj.chapter8.sorting;

public class MergeSort {
	public static void mergeSort(int items[], int temp[], int leftIndex, int rightIndex) {
		int midIndex, nItems;
		nItems = rightIndex - leftIndex + 1;
		if (nItems == 1) // base case
			return;
		midIndex = (rightIndex + leftIndex) / 2;
		mergeSort(items, temp, leftIndex, midIndex); // first reduced problem
		mergeSort(items, temp, midIndex + 1, rightIndex); // second reduced
														  // problem
		merge(items, temp, leftIndex, midIndex + 1, rightIndex); // general
																 // solution
		return;
	} // end of mergeSort method

	public static void merge(int items[], int temp[], int leftIndex, int midIndex, int rightIndex) {
		int leftEnd, nItems, tempsIndex;
		leftEnd = midIndex - 1;
		tempsIndex = leftIndex;
		nItems = rightIndex - leftIndex + 1;
		while ((leftIndex <= leftEnd) && (midIndex <= rightIndex)) // move items
																   // into temp
		{
			if (items[leftIndex] <= items[midIndex]) // move item from left
													 // sublist
			{
				temp[tempsIndex] = items[leftIndex];
				tempsIndex = tempsIndex + 1;
				leftIndex = leftIndex + 1;
			} else // move item from right sublist into temp
			{
				temp[tempsIndex] = items[midIndex];
				tempsIndex = tempsIndex + 1;
				midIndex = midIndex + 1;
			}
		}
		if (leftIndex <= leftEnd) // left sublist is not empty
		{
			while (leftIndex <= leftEnd) // copy remainder of left sublist to
										 // temp
			{
				temp[tempsIndex] = items[leftIndex];
				leftIndex = leftIndex + 1;
				tempsIndex = tempsIndex + 1;
			}
		} else // right sublist is not empty
		{
			while (midIndex <= rightIndex) // copy reminder of right sublist
										   // into temp
			{
				temp[tempsIndex] = items[midIndex];
				midIndex = midIndex + 1;
				tempsIndex = tempsIndex + 1;
			}
		}
		for (int i = 0; i < nItems; i++) // copy temp into items
		{
			items[rightIndex] = temp[rightIndex];
			rightIndex = rightIndex - 1;
		}
	}// end merge method
}// end of class
