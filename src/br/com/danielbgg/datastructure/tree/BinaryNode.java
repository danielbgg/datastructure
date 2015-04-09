package br.com.danielbgg.datastructure.tree;

public class BinaryNode extends Node {

	private BinaryNode leftChild;
	private BinaryNode rightChild;

	public BinaryNode(Integer value) {
		super(value);
	}

	public BinaryNode(Integer value, BinaryNode leftChild, BinaryNode rightChild) {
		super(value);
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	public BinaryNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinaryNode leftChild) {
		this.leftChild = leftChild;
	}

	public BinaryNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinaryNode rightChild) {
		this.rightChild = rightChild;
	}

	public String toString() {
		return "Binary Node: " + getValue();
	}

}
