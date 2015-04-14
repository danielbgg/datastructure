package br.com.danielbgg.examples.search;

import java.util.Arrays;
import java.util.Date;

public class ExemploBinarySearch {

	public static void main(String[] args) {
		int[] data = { 0, 2, 3, 13, 15, 17, 23, 39, 43, 56, 57, 60, 155 };
		System.out.println("Dados iniciais: " + Arrays.toString(data));

		long time1 = (new Date()).getTime();
		int position = binarySearch(data, 60);
		long time2 = (new Date()).getTime();
		System.out.println("Posicao no array: " + position);
		System.out.println("Tempo: " + (time2 - time1));
	}

	public static int binarySearch(int[] data, int searchValue) {
		int low = 0;
		int high = data.length - 1;
		int i = (high + low) / 2;
		int iteracoes = 1;
		while (searchValue != data[i] && high != low) {
			System.out.println("Iteracao: " + iteracoes++ + " - meio: " + (i + 1) + " [" + data[i] + "]");
			if (searchValue < data[i]) {
				System.out.println("Valor esta na parte low..." + Arrays.toString(Arrays.copyOfRange(data, low, i)));
				high = i - 1;
			} else {
				System.out.println("Valor esta na parte high... " + Arrays.toString(Arrays.copyOfRange(data, i+1, high+1)));
				low = i + 1;
			}
			i = (high + low) / 2;
		}
		System.out.println("Valor encontrado na iteracao: " + iteracoes);
		return (i + 1);
	}
}
