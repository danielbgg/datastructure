package br.com.danielbgg.examples.bits;

/**
 * Calcular o menor número inteiro sem utilizar sinais de comparação
 */
public class MenorNumeroInteiro {
	
	public static void main(String[] args) {
		int[] intList = { 2, 0, 10, 50, -3 };
		int menor = intList[0];
		int[] pos = new int[2];
		for (int i : intList) {
			pos[0] = menor;
			pos[1] = i;
			int result = menor - i;
			int posResult = (result >> 31) + 1;
			menor = pos[posResult];
		}
		System.out.println(menor);
	}
}