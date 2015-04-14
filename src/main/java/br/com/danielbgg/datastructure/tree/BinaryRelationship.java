package br.com.danielbgg.datastructure.tree;

public class BinaryRelationship {

	private BinaryNode parent;
	private BinaryNode child;

	public BinaryRelationship() {
	}

	public BinaryRelationship(BinaryNode parent, BinaryNode child) {
		this.parent = parent;
		this.child = child;
	}

	public BinaryNode getParent() {
		return parent;
	}

	public void setParent(BinaryNode parent) {
		this.parent = parent;
	}

	public BinaryNode getChild() {
		return child;
	}

	public void setChild(BinaryNode child) {
		this.child = child;
	}

	public String toString() {
		return "Binary Relationship between parent: " + getParent() + " and child: " + getChild();
	}

}
