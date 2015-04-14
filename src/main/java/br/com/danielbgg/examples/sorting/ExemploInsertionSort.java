package br.com.danielbgg.examples.sorting;

import java.util.Arrays;
import java.util.Date;

/*
 * Insertion sort is an algorithm that seeks to sort a list one element at a time. With each iteration, it takes the next element waiting to be sorted, and adds it, in proper location, to those elements that have already been sorted.
 * One of the principal advantages of the insertion sort is that it works very efficiently for lists that are nearly sorted initially. Furthermore, it can also work on data sets that are constantly being added to. For instance, if one wanted to maintain a sorted list of the highest scores achieved in a game, an insertion sort would work well, since new elements would be added to the data as the game was played.
 */
public class ExemploInsertionSort {

	public static void main(String[] args) {
		int[] data = { 15, 23, 43, 57, 17, 0, 60, 39, 13, 155, 2, 3, 56 };
		System.out.println("Dados iniciais: " + Arrays.toString(data));
		long time1 = (new Date()).getTime();
		data = insertionSort(data);
		long time2 = (new Date()).getTime();
		System.out.println("Dados finais: " + Arrays.toString(data));
		System.out.println("Tempo: " + (time2 - time1));
	}

	public static int[] insertionSort(int[] data) {
		System.out.println("Tamanho do array: " + data.length);
		
		for (int i = 0; i < data.length; i++) {
			
			System.out.println("Dados intermediarios [" + i + "]: "+ Arrays.toString(data));

			int j = i;
			
			while (j > 0 && data[i] < data[j - 1]) {
				System.out.println("data[i] < data[j - 1]: " + data[i] + " < " + data[j - 1] + " J: " +j);
				j--;
			}
			
			int tmp = data[i];
			for (int k = i; k > j; k--) {
				System.out.println("k: " + k + " data[k]: " + data[k] + " data[k - 1]: " + data[k - 1]);
				data[k] = data[k - 1];
			}
			
			data[j] = tmp;
		}
		return data;

	}

}
