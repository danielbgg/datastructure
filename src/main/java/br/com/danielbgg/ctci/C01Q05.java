package br.com.danielbgg.ctci;

/**
 * Write a method to replace all spaces in a string with ‘%20’
 */
public class C01Q05 {

	public static String replaceSpaces(String s) {
		char[] c = s.toCharArray();
		int number = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == ' ') {
				number++;
			}
		}

		char[] nc = new char[c.length + 2 * number];
		int offset = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == ' ') {
				nc[i + offset++] = '%';
				nc[i + offset++] = '2';
				nc[i + offset] = '0';
			} else {
				nc[i + offset] = c[i];
			}
		}

		return new String(nc);
	}

	public static void main(String[] args) {
		System.out.println(C01Q05.replaceSpaces("ab cd ef"));
		System.out.println(C01Q05.replaceSpaces(" ab cd ef "));
	}

}
