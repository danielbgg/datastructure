package br.com.danielbgg.digraph.algs4;

import java.util.Queue;
import java.util.Stack;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class DepthFirstOrderTest extends TestCase {

	public DepthFirstOrderTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(DepthFirstOrderTest.class);
	}

	public void testTinyDAG() {
		Digraph G = new Digraph(new In("C:/java/repositorios/data/algs4-data/tinyDAG.txt"));
		printData(G, "tinyDAG");
		DepthFirstOrder order = new DepthFirstOrder(G);
		printIterable("pre order:", order.pre());
		printIterable("post order:", order.post());
		printIterable("reverse post order:", order.reversePost());
	}

	private void printData(Digraph G, String desc) {
		StdOut.println("----------------" + desc);
		StdOut.println(G);
		StdOut.println();
	}

	private void printIterable(String description, Stack<Integer> i) {
		StdOut.printf(description);
		while (!i.isEmpty()) {
			StdOut.print(" " + i.pop());
		}
		StdOut.print("\n");
	}

	private void printIterable(String description, Queue<Integer> i) {
		StdOut.printf(description);
		while (!i.isEmpty()) {
			StdOut.print(" " + i.poll());
		}
		StdOut.print("\n");
	}

}
