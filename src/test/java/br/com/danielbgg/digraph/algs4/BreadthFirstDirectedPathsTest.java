package br.com.danielbgg.digraph.algs4;

import java.util.Stack;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class BreadthFirstDirectedPathsTest extends TestCase {

	public BreadthFirstDirectedPathsTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(BreadthFirstDirectedPathsTest.class);
	}

	public void testTiny() {
		Digraph G = new Digraph(new In("C:/java/repositorios/data/algs4-data/tinyDG.txt"));
		printData(G, "tinyDG");
		BreadthFirstDirectedPaths bfs = new BreadthFirstDirectedPaths(G, 0);
		for (int i = 0; i <= 12; i++) {
			printIterable(0, i, bfs.pathTo(i));
		}
	}

	private void printData(Digraph G, String desc) {
		StdOut.println("----------------" + desc);
		StdOut.println(G);
	}

	private void printIterable(int start, int end, Stack<Integer> i) {
		StdOut.printf("Path from: %d to: %d -> ", start, end);
		while (!i.isEmpty()) {
			int integer = i.pop();
			if (end == integer) {
				StdOut.print(integer);
			} else {
				StdOut.print(integer + "-");
			}
		}
		StdOut.print("\n");
	}
}
