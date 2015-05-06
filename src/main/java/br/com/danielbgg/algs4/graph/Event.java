package br.com.danielbgg.algs4.graph;

public class Event {

	private int vertex;
	private String description;

	public Event(int vertex, String description) {
		super();
		this.vertex = vertex;
		this.description = description;
	}

	public int getVertex() {
		return vertex;
	}

	public void setVertex(int vertex) {
		this.vertex = vertex;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Event [vertex: " + vertex + ", description: " + description + "]";
	}

}
