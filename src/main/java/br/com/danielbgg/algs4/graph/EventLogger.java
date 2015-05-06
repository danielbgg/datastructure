package br.com.danielbgg.algs4.graph;

import java.util.LinkedList;
import java.util.Queue;

public class EventLogger {

	private Queue<Event> q;

	public EventLogger() {
		q = new LinkedList<Event>();
	}

	public void add(int v, String desc) {
		q.add(new Event(v, desc));
	}

	public Queue<Event> getQueue() {
		return q;
	}

}
