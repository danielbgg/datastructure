package br.com.danielbgg.graph;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class BFSTest extends TestCase {

	public BFSTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(BFSTest.class);
	}

	public void testApp() {
		ListGraph g = new ListGraph();

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

		BFS bfs = new BFS(g);
		assertEquals(2, bfs.bfs(v1));
		assertEquals(v1, bfs.bfs(v1, v1).getVertex());
		assertEquals(v4, bfs.bfs(v1, v4).getVertex());
		assertNull(bfs.bfs(v1, new Vertex("Test 1")));
		assertNotSame(v3, bfs.bfs(v1, v4).getVertex());
	}

}
