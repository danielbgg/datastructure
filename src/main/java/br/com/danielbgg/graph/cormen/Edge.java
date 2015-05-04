package br.com.danielbgg.graph.cormen;

public class Edge {

	private Vertex u;
	private Vertex v;
	private double weight;

	public Edge(Vertex u, Vertex v) {
		this.u = u;
		this.v = v;
	}

	public Edge(Vertex u, Vertex v, double weight) {
		this.u = u;
		this.v = v;
		this.weight = weight;
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
