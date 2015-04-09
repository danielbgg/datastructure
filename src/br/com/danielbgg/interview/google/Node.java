package br.com.danielbgg.interview.google;

public class Node {

	int id;
	int parent_id;
	int weight;

	public Node(int id, int parent_id, int weight) {
		super();
		this.id = id;
		this.parent_id = parent_id;
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
