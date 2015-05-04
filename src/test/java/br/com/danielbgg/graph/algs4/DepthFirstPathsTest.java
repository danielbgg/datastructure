package br.com.danielbgg.graph.algs4;

import java.util.Stack;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class DepthFirstPathsTest extends TestCase {

	public DepthFirstPathsTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(DepthFirstPathsTest.class);
	}

	public void testTiny() {
		Graph G = new Graph(new In("C:/java/repositorios/data/algs4-data/tinyCG.txt"));
		printData(G, "tinyCG");
		DepthFirstPaths dfs = new DepthFirstPaths(G, 0);
		for (int i = 0; i <= 5; i++) {
			printIterable(0, i, dfs.pathTo(i));
		}
	}

	private void printData(Graph G, String desc) {
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
