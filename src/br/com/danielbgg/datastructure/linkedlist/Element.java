package br.com.danielbgg.datastructure.linkedlist;

/*
 * Single linked list
 */
public class Element<T> {

	private T data;

	private Element<T> next;

	public Element(T value) {
		this.data = value;
	}

	public T getValue() {
		return this.data;
	}

	public void setNext(Element<T> next) {
		this.next = next;
	}

	public void setValue(T value) {
		this.data = value;
	}
	
	public Element<T> getNext() {
		return this.next;
	}
}
