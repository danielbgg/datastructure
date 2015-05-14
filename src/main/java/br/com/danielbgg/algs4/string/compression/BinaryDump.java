package br.com.danielbgg.algs4.string.compression;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.StdOut;

public class BinaryDump {

	public void print(int width) {
		int cnt;
		for (cnt = 0; !BinaryStdIn.isEmpty(); cnt++) {
			if (width == 0)
				continue;
			if (cnt != 0 && cnt % width == 0)
				StdOut.println();
			if (BinaryStdIn.readBoolean())
				StdOut.print("1");
			else
				StdOut.print("0");
		}
		StdOut.println();
		StdOut.println(cnt + " bits");
	}

}