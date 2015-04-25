package br.com.danielbgg.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

	private AdjacencyListGraph g;
	private Queue q;

	public BreadthFirstSearch(AdjacencyListGraph g) {
		this.g = g;
		this.q = new LinkedList();
	}
	
	public void execute(Vertex s) {
		g.resetVertices();
		s.setColor(Vertex.COLOR_GRAY);
		s.setD(0);
		s.setParent(null);
		q = new LinkedList();
		q.add(s);
		
		System.out.println(s);
		
		while(!q.isEmpty()) {
			Vertex u = (Vertex) q.poll();
			List<Vertex> ll = g.getAdjacencyList(u);
			for (Iterator iterator = ll.iterator(); iterator.hasNext();) {
	            Vertex v = (Vertex) iterator.next();
	            if (v.getColor() == Vertex.COLOR_WHITE) {
	            	v.setColor(Vertex.COLOR_GRAY);
	            	v.setD(u.getD() + 1);
	            	v.setParent(u);
	            	q.add(v);
	            	
	        		System.out.println(v);
	            }
            }
			u.setColor(Vertex.COLOR_BLACK);
		}
	}

}
