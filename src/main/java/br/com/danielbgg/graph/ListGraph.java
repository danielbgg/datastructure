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

	private ListGraph(HashMap<Vertex, LinkedList<Vertex>> map) {
		this.map = map;
	}

	public void addVertex(Vertex v) {
		if (!map.containsKey(v.getDescription())) {
			map.put(v, new LinkedList<Vertex>());
		}
	}

	public void addEdge(Edge e) {
		map.get(e.getU()).add(e.getV());
	}

	public List<Vertex> getAdjacencyList(Vertex v) {
		return map.get(v);
	}

	public Set<Vertex> getAllVertices() {
		return map.keySet();
	}

	public HashMap<Vertex, LinkedList<Vertex>> getMap() {
		return map;
	}

	public ListGraph transpose() {
		HashMap<Vertex, LinkedList<Vertex>> transposeMap = new HashMap<Vertex, LinkedList<Vertex>>();
		Set<Vertex> s = getAllVertices();
		for (Iterator<Vertex> iterator = s.iterator(); iterator.hasNext();) {
			Vertex v = (Vertex) iterator.next();
			transposeMap.put(v, new LinkedList<Vertex>());
		}
		for (Iterator<Vertex> iterator = s.iterator(); iterator.hasNext();) {
			Vertex v = iterator.next();
			List<Vertex> ll = getAdjacencyList(v);
			for (Iterator<Vertex> iterator2 = ll.iterator(); iterator2.hasNext();) {
				Vertex vv = (Vertex) iterator2.next();
				transposeMap.get(vv).add(v);
			}
		}
		return new ListGraph(transposeMap);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("---- Graph ---- \n");
		Set<Vertex> s = map.keySet();
		for (Iterator<Vertex> iterator = s.iterator(); iterator.hasNext();) {
			Vertex vv = iterator.next();
			sb.append("  ---- Vertex: " + vv.getDescription());
			LinkedList<Vertex> ll = map.get(vv);
			sb.append(" -> ");
			for (Iterator<Vertex> iterator2 = ll.iterator(); iterator2.hasNext();) {
				sb.append(iterator2.next().getDescription() + " -> ");
			}
			sb.append("/\n");
		}
		return sb.toString();
	}

}
