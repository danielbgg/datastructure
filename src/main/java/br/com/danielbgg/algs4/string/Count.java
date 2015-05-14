package br.com.danielbgg.algs4.string;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Count {

	public Count() {
	}

	public void print(String str, In in) {
		Alphabet alpha = new Alphabet(str);
		int R = alpha.R();
		int[] count = new int[R];

		String s = in.readAll();
		int N = s.length();
		for (int i = 0; i < N; i++) {
			if (alpha.contains(s.charAt(i))) {
				count[alpha.toIndex(s.charAt(i))]++;
			}
		}

		for (int c = 0; c < R; c++) {
			StdOut.println(alpha.toChar(c) + " " + count[c]);
		}
	}

}
