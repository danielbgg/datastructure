package book.dsauj.chapter8.sorting;

public class MainSortingAlgorithms {
	public static void main(String args[]) {
		int[] items1 = { 6, 2, 3, 1, 7, 5, 8, 9, 10, 4 };
		int[] items2 = { 6, 2, 3, 1, 7, 5, 8, 9, 10, 4 };
		int[] temp = new int[10];

		MergeSort.mergeSort(items1, temp, 0, 9);
		System.out.println("Merge Sort results");
		for (int i = 0; i < 10; i++)
			System.out.print(items1[i] + " ");

		QuickSort.quickSort(items2, 0, 9);
		System.out.println("\n\nQuick Sort results");
		for (int i = 0; i < 10; i++)
			System.out.print(items2[i] + " ");

	}
}
