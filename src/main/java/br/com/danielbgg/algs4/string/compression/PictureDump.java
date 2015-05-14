package br.com.danielbgg.algs4.string.compression;

import java.awt.Color;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.Picture;
import edu.princeton.cs.algs4.StdOut;

public class PictureDump {

	public void print(int width, int height) {
		Picture pic = new Picture(width, height);
		int count = 0;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				pic.set(j, i, Color.RED);
				if (!BinaryStdIn.isEmpty()) {
					count++;
					boolean bit = BinaryStdIn.readBoolean();
					if (bit)
						pic.set(j, i, Color.BLACK);
					else
						pic.set(j, i, Color.WHITE);
				}
			}
		}
		pic.show();
		StdOut.println(count + " bits");
	}
}