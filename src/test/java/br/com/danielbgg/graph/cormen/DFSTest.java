package br.com.danielbgg.graph.cormen;

import java.util.Iterator;
import java.util.List;

import br.com.danielbgg.cormen.graph.DFS;
import br.com.danielbgg.cormen.graph.Edge;
import br.com.danielbgg.cormen.graph.ListGraph;
import br.com.danielbgg.cormen.graph.Vertex;
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

	public void testDFS() {
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

		System.out.println("\n----------------------- DFS G");
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

		g.addVertex(shirt);
		g.addVertex(tie);
		g.addVertex(jacket);
		g.addVertex(belt);
		g.addVertex(watch);
		g.addVertex(undershorts);
		g.addVertex(pants);
		g.addVertex(shoes);
		g.addVertex(socks);

		g.addEdge(new Edge(undershorts, pants));
		g.addEdge(new Edge(undershorts, shoes));
		g.addEdge(new Edge(socks, shoes));
		g.addEdge(new Edge(pants, belt));
		g.addEdge(new Edge(belt, jacket));
		g.addEdge(new Edge(shirt, belt));
		g.addEdge(new Edge(shirt, tie));
		g.addEdge(new Edge(tie, jacket));
		g.addEdge(new Edge(pants, shoes));

		System.out.println("\n----------------------- DFS G");
		DFS dfs = new DFS(g);
		dfs.dfs();

		System.out.println("\n----------------------- Topological Sort G");
		printList(dfs.getTopologicalSort());
	}

	public void testStronglyConnectedComponents() {
		ListGraph g = new ListGraph();

		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		Vertex c = new Vertex("c");
		Vertex d = new Vertex("d");
		Vertex e = new Vertex("e");
		Vertex f = new Vertex("f");
		Vertex gg = new Vertex("g");
		Vertex h = new Vertex("h");

		g.addVertex(a);
		g.addVertex(b);
		g.addVertex(c);
		g.addVertex(d);
		g.addVertex(e);
		g.addVertex(f);
		g.addVertex(gg);
		g.addVertex(h);

		g.addEdge(new Edge(a, b));
		g.addEdge(new Edge(b, e));
		g.addEdge(new Edge(e, a));
		g.addEdge(new Edge(e, f));
		g.addEdge(new Edge(b, f));
		g.addEdge(new Edge(b, c));
		g.addEdge(new Edge(f, gg));
		g.addEdge(new Edge(gg, f));
		g.addEdge(new Edge(c, gg));
		g.addEdge(new Edge(c, d));
		g.addEdge(new Edge(d, c));
		g.addEdge(new Edge(d, h));
		g.addEdge(new Edge(gg, h));
		g.addEdge(new Edge(h, h));

		System.out.println("\n----------------------- DFS G");
		DFS dfs = new DFS(g);
		dfs.dfs();

		System.out.println("\n----------------------- Map G");
		System.out.println(g);

		System.out.println("\n----------------------- Map G Transposed");
		ListGraph gT = g.transpose();
		System.out.println(gT);
		
		System.out.println("\n----------------------- DFS G Transposed");
		DFS dfsGT = new DFS(gT);
		dfsGT.dfs(dfs.getListOfDecreasingF());
		
	}

	
	private void printList(List<?> l) {
		for (Iterator<?> iterator = l.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
	}

}
