package br.com.danielbgg.graph.algs4;

import java.util.Iterator;
import java.util.Queue;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class DepthFirstSearchTest extends TestCase {

	public DepthFirstSearchTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(DepthFirstSearchTest.class);
	}

	public void testTiny() {
		Graph G = new Graph(new In("C:/java/repositorios/data/algs4-data/tinyCG.txt"));
		printData(G, "tinyCG");
		DepthFirstSearch dfs = new DepthFirstSearch(G, 0);
		StdOut.println(dfs.count());
		printQueue(dfs.getEventLogger().getQueue());
	}

	public void testAPI() {
		Graph G = new Graph(new In("C:/java/repositorios/data/algs4-data/tinyG.txt"));
		printData(G, "API");
		DepthFirstSearch search = new DepthFirstSearch(G, 0);
		for (int v = 0; v < G.V(); v++)
			if (search.marked(v))
				StdOut.print(v + " ");
		StdOut.println();
		if (search.count() != G.V())
			StdOut.print("NOT ");
		StdOut.println("connected");
	}

	private void printData(Graph G, String desc) {
		StdOut.println("----------------" + desc);
		StdOut.println(G);
	}

	private void printQueue(Queue<Event> q) {
		for (Iterator<Event> iterator = q.iterator(); iterator.hasNext();) {
			StdOut.println(iterator.next());
		}
	}
}
