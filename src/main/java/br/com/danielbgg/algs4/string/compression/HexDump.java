package br.com.danielbgg.algs4.string.compression;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.StdOut;

public class HexDump {

	public void print(int width) {
		int BYTES_PER_LINE = width;
		int i;
		for (i = 0; !BinaryStdIn.isEmpty(); i++) {
			if (BYTES_PER_LINE == 0) {
				BinaryStdIn.readChar();
				continue;
			}
			if (i == 0)
				StdOut.printf("");
			else if (i % BYTES_PER_LINE == 0)
				StdOut.printf("\n", i);
			else
				StdOut.print(" ");
			char c = BinaryStdIn.readChar();
			StdOut.printf("%02x", c & 0xff);
		}
		if (BYTES_PER_LINE != 0)
			StdOut.println();
		StdOut.println((i * 8) + " bits");
	}
}
