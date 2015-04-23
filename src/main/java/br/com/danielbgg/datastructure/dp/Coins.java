package br.com.danielbgg.datastructure.dp;

import java.util.Arrays;

public class Coins {

	public static void dynamicProgrammingCoins(int sum) {
		int[] values = { 1, 3, 5 };
		int[] min = new int[sum+1];
		String[] description = new String[sum+1];
		for (int i = 0; i < min.length; i++) {
			min[i] = Integer.MAX_VALUE;
		}
		min[0] = 0;
		for (int i = 1; i <= sum; i++) {
			for (int j = 0; j < values.length; j++) {
				if (values[j] <= i) {
					int b = min[i - values[j]] + 1;
					int c = min[i];
					if (b < c) {
						min[i] = b;
						description[i] = description[i] + " - " + values[j];
					}
				}
			}
		}
		for (int i = 0; i <= sum; i++) {
	        System.out.println("Sum: " + i + " - Min # coins: " + min[i]);
        }
	}

	public static void main(String[] args) {
		Coins.dynamicProgrammingCoins(11);
	}

}
