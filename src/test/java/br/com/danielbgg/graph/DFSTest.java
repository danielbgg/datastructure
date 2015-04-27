package br.com.danielbgg.graph;

import java.util.Iterator;
import java.util.LinkedList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class DFSTest extends TestCase {

	public DFSTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(DFSTest.class);
	}

	public void testApp() {
		ListGraph g = new ListGraph();

		Vertex s = new Vertex("s");
		Vertex t = new Vertex("t");
		Vertex u = new Vertex("u");
		Vertex v = new Vertex("v");
		Vertex w = new Vertex("w");
		Vertex x = new Vertex("x");
		Vertex z = new Vertex("z");
		Vertex y = new Vertex("y");

		g.addVertex(s);
		g.addVertex(t);
		g.addVertex(u);
		g.addVertex(v);
		g.addVertex(w);
		g.addVertex(x);
		g.addVertex(z);
		g.addVertex(y);

		g.addEdge(new Edge(y, x));
		g.addEdge(new Edge(x, z));
		g.addEdge(new Edge(z, y));
		g.addEdge(new Edge(z, w));
		g.addEdge(new Edge(w, x));
		g.addEdge(new Edge(s, z));
		g.addEdge(new Edge(s, w));
		g.addEdge(new Edge(v, s));
		g.addEdge(new Edge(v, w));
		g.addEdge(new Edge(t, u));
		g.addEdge(new Edge(t, v));
		g.addEdge(new Edge(u, v));
		g.addEdge(new Edge(u, t));

		DFS dfs = new DFS(g);
		dfs.dfs();
	}
	
	public void testTopologicalSort() {
		ListGraph g = new ListGraph();

		Vertex undershorts = new Vertex("undershorts");
		Vertex pants = new Vertex("pants");
		Vertex belt = new Vertex("belt");
		Vertex shirt = new Vertex("shirt");
		Vertex tie = new Vertex("tie");
		Vertex jacket = new Vertex("jacket");
		Vertex socks = new Vertex("socks");
		Vertex shoes = new Vertex("shoes");
		Vertex watch = new Vertex("watch");

		g.addVertex(undershorts);
		g.addVertex(pants);
		g.addVertex(belt);
		g.addVertex(shirt);
		g.addVertex(tie);
		g.addVertex(jacket);
		g.addVertex(socks);
		g.addVertex(shoes);
		g.addVertex(watch);

		g.addEdge(new Edge(undershorts, pants));
		g.addEdge(new Edge(undershorts, shoes));
		g.addEdge(new Edge(socks, shoes));
		g.addEdge(new Edge(pants, belt));
		g.addEdge(new Edge(belt, jacket));
		g.addEdge(new Edge(shirt, belt));
		g.addEdge(new Edge(shirt, tie));
		g.addEdge(new Edge(tie, jacket));
		g.addEdge(new Edge(pants, shoes));

		DFS dfs = new DFS(g);
		dfs.dfs();
		System.out.println("----------------------- Topological Sort");
		LinkedList<DFSVertex> ll = dfs.getTopologicalSort();
		for (Iterator iterator = ll.iterator(); iterator.hasNext();) {
	        DFSVertex v = (DFSVertex) iterator.next();
	        System.out.println(v);
        }
	}

}
