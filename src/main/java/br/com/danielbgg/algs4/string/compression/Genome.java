package br.com.danielbgg.algs4.string.compression;

import edu.princeton.cs.algs4.Alphabet;
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class Genome {

	public static void compress() {
		Alphabet DNA = new Alphabet("ACTG");
		String s = BinaryStdIn.readString();
		int N = s.length();
		BinaryStdOut.write(N);
		for (int i = 0; i < N; i++) { // Write two-bit code for char.
			int d = DNA.toIndex(s.charAt(i));
			BinaryStdOut.write(d, DNA.lgR());
		}
		BinaryStdOut.close();
	}

	public static void expand() {
		Alphabet DNA = new Alphabet("ACTG");
		int w = DNA.lgR();
		int N = BinaryStdIn.readInt();
		for (int i = 0; i < N; i++) { // Read 2 bits; write char.
			char c = BinaryStdIn.readChar(w);
			BinaryStdOut.write(DNA.toChar(c));
		}
		BinaryStdOut.close();
	}
}
