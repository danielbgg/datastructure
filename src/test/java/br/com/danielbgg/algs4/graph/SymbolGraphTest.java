package br.com.danielbgg.algs4.graph;

import br.com.danielbgg.algs4.graph.Graph;
import br.com.danielbgg.algs4.graph.SymbolGraph;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import edu.princeton.cs.algs4.StdOut;

public class SymbolGraphTest extends TestCase {

	public SymbolGraphTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(SymbolGraphTest.class);
	}

	public void testRoutes() {
		SymbolGraph sg = new SymbolGraph("C:/java/repositorios/data/algs4-data/routes.txt", " ");
		printData(sg, "routes");
		Graph G = sg.G();
		printData(G, "routes");
		printSource(sg, "JFK");
		printSource(sg, "ORD");
		printSource(sg, "DEN");
	}

	public void testMovies() {
		StdOut.println("----------------movies");
		SymbolGraph sg = new SymbolGraph("C:/java/repositorios/data/algs4-data/movies.txt", "/");
		printSource(sg, "Tin Men (1987)");
		printSource(sg, "Bacon, Kevin");
	}
	
	
	private void printData(SymbolGraph G, String desc) {
		StdOut.println("----------------" + desc);
		StdOut.println(G);
	}

	private void printData(Graph G, String desc) {
		StdOut.println("----------------" + desc);
		StdOut.println(G);
	}

	private void printSource(SymbolGraph sg, String source) {
		StdOut.println(source);
		for (int w : sg.G().adj(sg.index(source)))
			StdOut.println("   " + sg.name(w));
		StdOut.println();
	}

}
