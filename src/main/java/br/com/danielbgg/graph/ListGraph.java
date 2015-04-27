package br.com.danielbgg.graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Adjacency List Graph
 */
public class ListGraph {

	private HashMap<Vertex, LinkedList<Vertex>> map;

	public ListGraph() {
		this.map = new HashMap<Vertex, LinkedList<Vertex>>();
	}

	public void addVertex(Vertex v) {
		if (!map.containsKey(v.getDescription())) {
			LinkedList<Vertex> ll = new LinkedList<Vertex>();
			ll.add(v);
			map.put(v, ll);
		}
	}

	public void addEdge(Edge e) {
		LinkedList<Vertex> ll = (LinkedList<Vertex>) map.get(e.getU());
		ll.add(e.getV());
	}

	public List<Vertex> getAdjacencyList(Vertex v) {
		return (LinkedList<Vertex>) map.get(v);
	}

	public Set<Vertex> getAllVertices() {
		return map.keySet();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("---- Graph ---- \n");
		Set<Vertex> s = map.keySet();
		for (Iterator<Vertex> iterator = s.iterator(); iterator.hasNext();) {
			Vertex vv = (Vertex) iterator.next();
			String description = vv.getDescription();
			sb.append("  ---- Vertex: " + description + "\n");
			LinkedList<?> ll = map.get(vv);
			sb.append("     ");
			for (Iterator<?> iterator2 = ll.iterator(); iterator2.hasNext();) {
				Vertex v = (Vertex) iterator2.next();
				sb.append(v.getDescription() + " -> ");
			}
			sb.append("/\n");
		}
		return sb.toString();
	}

}
