package br.com.danielbgg.examples.sorting;

import java.util.Arrays;
import java.util.Date;

/*
 * The idea is to pass through the data from one end to the other, and swap two adjacent elements whenever the first is greater than the last. Thus, the smallest elements will “bubble” to the surface. This is O(n^2) runtime, and hence is very slow for large data sets. The single best advantage of a bubble sort, however, is that it is very simple to understand and code from memory. Additionally, it is a stable sort that requires no additional memory, since all swaps are made in place.
 */
public class ExemploBubbleSort {

	public static void main(String[] args) {
		int[] data = { 15, 23, 43, 57, 17, 0, 60, 39, 13, 155, 2, 3, 56 };
		System.out.println("Dados iniciais: " + Arrays.toString(data));
		long time1 = (new Date()).getTime();
		data = bubbleSort(data);
		long time2 = (new Date()).getTime();
		System.out.println("Dados finais: " + Arrays.toString(data));
		System.out.println("Tempo: " + (time2 - time1));
	}

	public static int[] bubbleSort(int[] data) {
		System.out.println("Tamanho do array: " + data.length);
		for (int i = 0; i < data.length; i++) {
			System.out.println("Dados intermediarios [" + i + "]: " + Arrays.toString(data));
			for (int j = 0; j < data.length - 1; j++) {
				if (data[j] > data[j + 1]) {
					System.out.println("data[j] > data[j + 1]: " + data[j] + " > " + data[j + 1]);
					int tmp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = tmp;
				}
			}
		}
		return data;
	}

}
