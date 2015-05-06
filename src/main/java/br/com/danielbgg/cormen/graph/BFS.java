package br.com.danielbgg.cormen.graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * BreadthFirstSearch
 */
public class BFS {

	private ListGraph g;
	private Queue<BFSVertex> q;
	private HashMap<Vertex, BFSVertex> map;

	public BFS(ListGraph g) {
		this.g = g;
		this.q = new LinkedList<BFSVertex>();
		this.map = new HashMap<Vertex, BFSVertex>();
	}

	private void resetVertices() {
		Set<Vertex> s = g.getAllVertices();
		for (Iterator<Vertex> iterator = s.iterator(); iterator.hasNext();) {
			Vertex v = (Vertex) iterator.next();
			BFSVertex bv = map.get(v);
			if (bv == null) {
				bv = new BFSVertex(v);
				map.put(v, bv);
			}
			bv.setColor(BFSVertex.COLOR_WHITE);
			bv.setD(Integer.MAX_VALUE);
			bv.setParent(null);
		}
	}
		
	/**
	 * Returns the dimension of a Graph from a starting Vertex
	 * 
	 * @param s
	 *            starting Vertex
	 * @return Graph dimension
	 */
	public int bfs(Vertex s) {
		BFSVertex v = bfs(s, null);
		if (v != null) {
			return v.getD();
		}
		return Integer.MIN_VALUE;
	}

	/**
	 * Traverses the Graph from the starting Vertex to the final Vertex
	 * 
	 * @param s starting Vertex
	 * @param v final Vertex
	 * 
	 * @return a BFSVertex if a path is found. Returns null otherwise.
	 */
	public BFSVertex bfs(Vertex s, Vertex v) {
		resetVertices();
		BFSVertex bs = map.get(s);
		if (bs == null) {
			return null;
		}
		bs.setColor(BFSVertex.COLOR_GRAY);
		bs.setD(0);
		bs.setParent(null);
		q.clear();
		q.add(bs);

		BFSVertex u = bfsVisit(v);
		if (v != null && !v.equals(u.getVertex())) {
			return null;
		}
		return u;
	}

	/**
	 * Perform the Breadth First Search to a final Vertex
	 * @param v
	 * @return
	 */
	private BFSVertex bfsVisit(Vertex v) {
	    BFSVertex u = null;
		while (!q.isEmpty()) {
			u = q.poll();
			if (v != null && v.equals(u.getVertex())) {
				break;
			}
			List<Vertex> ll = g.getAdjacencyList(u.getVertex());
			for (Iterator<Vertex> iterator = ll.iterator(); iterator.hasNext();) {
				BFSVertex bv = map.get(iterator.next());
				if (bv.getColor() == BFSVertex.COLOR_WHITE) {
					bv.setColor(BFSVertex.COLOR_GRAY);
					bv.setD(u.getD() + 1);
					bv.setParent(u);
					q.add(bv);
				}
			}
			u.setColor(BFSVertex.COLOR_BLACK);
		}
	    return u;
    }

	public void printTraverse(BFSVertex s) {
		System.out.println(s);
		if (s.getParent() != null) {
			printTraverse(s.getParent());
		}
	}

}
