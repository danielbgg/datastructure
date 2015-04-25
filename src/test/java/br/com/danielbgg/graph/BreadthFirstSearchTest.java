package br.com.danielbgg.graph;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class BreadthFirstSearchTest extends TestCase {

	public BreadthFirstSearchTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(BreadthFirstSearchTest.class);
	}

	public void testApp() {
		AdjacencyListGraph g = new AdjacencyListGraph();

		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");

		g.addVertex(v1);
		g.addVertex(v2);
		g.addVertex(v3);
		g.addVertex(v4);
		g.addVertex(v5);

		g.addEdge(new Edge(v1, v2));
		g.addEdge(new Edge(v1, v5));
		g.addEdge(new Edge(v2, v1));
		g.addEdge(new Edge(v2, v3));
		g.addEdge(new Edge(v2, v4));
		g.addEdge(new Edge(v2, v5));
		g.addEdge(new Edge(v3, v2));
		g.addEdge(new Edge(v3, v4));
		g.addEdge(new Edge(v4, v2));
		g.addEdge(new Edge(v4, v3));
		g.addEdge(new Edge(v4, v5));
		g.addEdge(new Edge(v5, v1));
		g.addEdge(new Edge(v5, v2));
		g.addEdge(new Edge(v5, v4));

		System.out.println(g);
		
		BreadthFirstSearch bfs = new BreadthFirstSearch(g);
		bfs.execute(v1);
	}

}
