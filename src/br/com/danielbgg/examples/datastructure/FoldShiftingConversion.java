package br.com.danielbgg.examples.datastructure;

/*
 * Hash
 * Fold-Shifting Non-Numeric Key Conversion Method
 */
public class FoldShiftingConversion {

	public static void main(String[] args) {
		System.out.println(stringToInt("MaryLynnTodd"));
	}

	public static int stringToInt(String aKey) {
		int pseudoKey = 0;
		int n = 1;
		int cn = 0;
		char c[] = aKey.toCharArray();
		int grouping = 0;
		while (cn < aKey.length()) {
			System.out.println("Iteracao: " + (cn + 1) + " - caracter: " + c[cn] + " - code: " + (0 + c[cn]));
			grouping = grouping << 8; // pack next 4 characters
			System.out.println("   - grouping a: " + grouping);
			grouping = grouping + c[cn];
			System.out.println("   - grouping b: " + grouping);
			cn = cn + 1;
			if (n == 4 || cn == aKey.length()) { // 4 characters are processed
												 // or no more characters
				pseudoKey = pseudoKey + grouping; // add grouping to pseudoKey
				System.out.println("       - pseudoKey: " + pseudoKey);
				n = 0;
				grouping = 0;
			}
			n = n + 1;
		}
		return Math.abs(pseudoKey);
	}

}
