package br.com.danielbgg.examples.sorting;

import java.util.Arrays;
import java.util.Date;

/*
 */
public class ExemploQuickSort {

	public static void main(String[] args) {
		int[] data = { 15, 23, 43, 57, 17, 0, 60, 39, 13, 155, 2, 3, 56 };
		System.out.println("Dados iniciais: " + Arrays.toString(data));
		long time1 = (new Date()).getTime();
		data = quickSort(data);
		long time2 = (new Date()).getTime();
		System.out.println("Dados finais: " + Arrays.toString(data));
		System.out.println("Tempo: " + (time2 - time1));
	}

	public static int[] quickSort(int[] data) {
		System.out.println("Tamanho do array: " + data.length);
		quickSort(data, 0, data.length-1);
		return data;
	}

	private static void quickSort(int[] items, int leftIndex, int rightIndex) {
		int i, j, temp, pivotValue, partitionSize;
		partitionSize = rightIndex - leftIndex + 1;
		if (partitionSize <= 1) {
			return;
		}
		pivotValue = items[(leftIndex + rightIndex) / 2];
		i = leftIndex;
		j = rightIndex;
		do {
			while (items[i] < pivotValue) {
				i++;
			}
			while (items[j] > pivotValue) {
				j--;
			}
			if (i <= j) {
				temp = items[i];
				items[i] = items[j];
				items[j] = temp;
				i++;
				j--;
			}
		} while (i <= j);
		quickSort(items, leftIndex, j);
		quickSort(items, i, rightIndex);
	}

}
