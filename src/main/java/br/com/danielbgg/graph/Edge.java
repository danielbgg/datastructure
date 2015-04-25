package br.com.danielbgg.graph;

public class Edge {

	private Vertex u;
	private Vertex v;
	private double weight;

	public Edge(Vertex u, Vertex v) {
		this.u = u;
		this.v = v;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Vertex getU() {
		return u;
	}

	public Vertex getV() {
		return v;
	}

}
