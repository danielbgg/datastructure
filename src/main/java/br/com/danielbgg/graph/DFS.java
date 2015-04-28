package br.com.danielbgg.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * DepthFirstSearch
 */
public class DFS {

	private ListGraph g;
	private HashMap<Vertex, DFSVertex> map;
	private int time;
	private LinkedList<DFSVertex> topologicalSort;

	public DFS(ListGraph g) {
		this.g = g;
		this.map = new HashMap<Vertex, DFSVertex>();
		this.topologicalSort = new LinkedList<DFSVertex>();
	}

	private void resetVertices() {
		Set<Vertex> s = g.getAllVertices();
		for (Iterator<Vertex> iterator = s.iterator(); iterator.hasNext();) {
			Vertex v = (Vertex) iterator.next();
			DFSVertex dv = map.get(v);
			if (dv == null) {
				dv = new DFSVertex(v);
				map.put(v, dv);
			}
			dv.setColor(DFSVertex.COLOR_WHITE);
			dv.setParent(null);
		}
	}

	public List<Vertex> getListOfDecreasingF() {
		List<DFSVertex> l = new ArrayList<DFSVertex>(map.values());
		Collections.sort(l, new Comparator<DFSVertex>() {
			public int compare(DFSVertex o1, DFSVertex o2) {
				return new Integer(o2.getF()).compareTo(new Integer(o1.getF()));
			}
		});
		List<Vertex> ll = new ArrayList<Vertex>();
		for (Iterator<DFSVertex> iterator = l.iterator(); iterator.hasNext();) {
			ll.add(iterator.next().getVertex());
		}
		return ll;
	}

	public void dfs() {
		dfs(null);
	}

	public void dfs(Collection<Vertex> decreasingF) {
		resetVertices();
		time = 0;
		Collection<Vertex> s = (decreasingF != null ? decreasingF : g.getAllVertices());
		for (Iterator<Vertex> iterator = s.iterator(); iterator.hasNext();) {
			Vertex v = (Vertex) iterator.next();
			DFSVertex du = map.get(v);
			if (du.getColor() == DFSVertex.COLOR_WHITE) {
				dfsVisit(du);
			}
		}
	}

	public LinkedList<DFSVertex> getTopologicalSort() {
		return topologicalSort;
	}

	private void dfsVisit(DFSVertex du) {
		System.out.println("Visiting: " + du.getVertex().getDescription());
		du.setD(++time);
		du.setColor(DFSVertex.COLOR_GRAY);
		List<Vertex> ll = g.getAdjacencyList(du.getVertex());
		for (Iterator<Vertex> iterator = ll.iterator(); iterator.hasNext();) {
			DFSVertex dv = map.get(iterator.next());
			if (dv.getColor() == DFSVertex.COLOR_WHITE) {
				dv.setParent(du);
				dfsVisit(dv);
			}
		}
		du.setColor(DFSVertex.COLOR_BLACK);
		du.setF(++time);
		topologicalSort.add(0, du);
		System.out.println("Finished visiting: " + du);
	}

}
