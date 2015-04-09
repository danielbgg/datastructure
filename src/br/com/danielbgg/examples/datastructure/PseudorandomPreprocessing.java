package br.com.danielbgg.examples.datastructure;

/*
 * Hash
 * Pseudorandom Preprocessing
 */
public class PseudorandomPreprocessing {

	public static void main(String[] args) {
		System.out.println(pseudo(FoldShiftingConversion.stringToInt("MaryLynnTodd")));
		System.out.println(pseudo(89351));
	}

	public static long pseudo(int aKey) {
		return 13l * (aKey + 53);
	}

}
