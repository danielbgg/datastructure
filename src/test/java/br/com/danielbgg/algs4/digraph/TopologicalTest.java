package br.com.danielbgg.algs4.digraph;

import java.util.Stack;

import br.com.danielbgg.algs4.digraph.Digraph;
import br.com.danielbgg.algs4.digraph.SymbolDigraph;
import br.com.danielbgg.algs4.digraph.Topological;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import edu.princeton.cs.algs4.StdOut;

public class TopologicalTest extends TestCase {

	public TopologicalTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(TopologicalTest.class);
	}

	public void testTinyDAG() {
		SymbolDigraph sg = new SymbolDigraph("C:/java/repositorios/data/algs4-data/jobs.txt", "/");
		printData(sg.G(), "jobs");
		Topological top = new Topological(sg.G());
		printIterable(sg, "reverse post order: ", top.getOrder());
	}

	private void printData(Digraph G, String desc) {
		StdOut.println("----------------" + desc);
		StdOut.println(G);
		StdOut.println();
	}

	private void printIterable(SymbolDigraph sg, String description, Stack<Integer> i) {
		StdOut.println(description);
		while (!i.isEmpty()) {
			int num = i.pop();
			StdOut.println(" -- (" + num + ") " + sg.name(num));
		}
	}
}
