package br.com.danielbgg.algs4.graph;

import java.util.List;

import br.com.danielbgg.algs4.graph.DegreesOfSeparation;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import edu.princeton.cs.algs4.StdOut;

public class DegreesOfSeparationTest extends TestCase {

	public DegreesOfSeparationTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(DegreesOfSeparationTest.class);
	}

	public void testRoutes() {
		DegreesOfSeparation d = new DegreesOfSeparation("C:/java/repositorios/data/algs4-data/routes.txt", " ");
		print(d.search("JFK", "LAS"));
		print(d.search("JFK", "JFK"));
		print(d.search("JFK", "DFW"));

	}

	public void testMovies() {
		DegreesOfSeparation d = new DegreesOfSeparation("C:/java/repositorios/data/algs4-data/movies.txt", "/");
		print(d.search("Animal House (1978)", "Titanic (1997)"));
		print(d.search("Animal House (1978)", "To Catch a Thief (1955)"));
		print(d.search("Bacon, Kevin", "Kidman, Nicole"));
		print(d.search("Bacon, Kevin", "Cruise, Tom"));
		print(d.search("Bacon, Kevin", "Grant, Cary"));
	}

	private void print(List<String> l) {
		for (String string : l) {
			StdOut.println(string);
		}
	}

}
