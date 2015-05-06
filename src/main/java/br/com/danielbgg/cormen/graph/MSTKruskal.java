package br.com.danielbgg.cormen.graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * MST - Kruskal
 */
public class MSTKruskal {

	private ListGraph g;
	private HashMap<Vertex, DisjointSet<Vertex>> map;

	public MSTKruskal(ListGraph g) {
		this.g = g;
		this.map = new HashMap<Vertex, DisjointSet<Vertex>>();
	}

	private void resetVertices() {
		map.clear();
		Set<Vertex> s = g.getAllVertices();
		for (Iterator<Vertex> iterator = s.iterator(); iterator.hasNext();) {
			Vertex v = iterator.next();
			DisjointSet<Vertex> ds = new DisjointSet<Vertex>();
			ds.makeSet(v);
			map.put(v, ds);
		}
	}

}
