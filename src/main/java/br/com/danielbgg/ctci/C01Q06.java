package br.com.danielbgg.ctci;

import java.util.Arrays;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is
 * 4 bytes, write a method to rotate the image by 90 degrees Can you do this in
 * place?
 */
public class C01Q06 {

	public static void rotate(int[][] matrix) {
		rotate(matrix, 0, 0);
		rotate(matrix, 0, 1);
	}

	private static void rotate(int[][] matrix, int linha, int coluna) {
		int[] coordenadas = novasCoordenadas(linha, coluna, matrix[0].length);
		rotate(matrix, matrix[linha][coluna], coordenadas[0], coordenadas[1], matrix[coordenadas[0]][coordenadas[1]], coordenadas);
	}

	private static void rotate(int[][] matrix, int novoValor, int linhaFinal, int colunaFinal, int proximoValor, int[] coordenadasIniciais) {
		matrix[linhaFinal][colunaFinal] = novoValor;

		int[] coordenadas = novasCoordenadas(linhaFinal, colunaFinal, matrix[0].length);
		if (coordenadas[0] == coordenadasIniciais[0] && coordenadas[1] == coordenadasIniciais[1]) {
			return;
		}

		rotate(matrix, proximoValor, coordenadas[0], coordenadas[1], matrix[coordenadas[0]][coordenadas[1]], coordenadasIniciais);
	}

	private static int[] novasCoordenadas(int linha, int coluna, int n) {
		int shift = n - linha - 1;
		int a = coluna;
		int b = shift;
		return new int[] { a, b };
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println("Before");
		print(matrix);
		C01Q06.rotate(matrix);
		System.out.println("After");
		print(matrix);
	}

	private static void print(int[][] matrix) {
		System.out.println(Arrays.toString(matrix[0]));
		System.out.println(Arrays.toString(matrix[1]));
		System.out.println(Arrays.toString(matrix[2]));
	}

}
