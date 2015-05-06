package br.com.danielbgg.algs4.digraph;

import java.util.Stack;

import br.com.danielbgg.algs4.digraph.DepthFirstDirectedPaths;
import br.com.danielbgg.algs4.digraph.Digraph;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class DepthFirstDirectedPathsTest extends TestCase {

	public DepthFirstDirectedPathsTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(DepthFirstDirectedPathsTest.class);
	}

	public void testTiny() {
		Digraph G = new Digraph(new In("C:/java/repositorios/data/algs4-data/tinyDG.txt"));
		printData(G, "tinyDG");
		DepthFirstDirectedPaths dfs = new DepthFirstDirectedPaths(G, 0);
		for (int i = 0; i <= 12; i++) {
			printIterable(0, i, dfs.pathTo(i));
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
