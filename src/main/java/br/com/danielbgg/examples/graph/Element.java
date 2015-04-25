package br.com.danielbgg.examples.graph;

public class Element<T> {

	private T data;
	boolean pushed;

	public Element(T value) {
		this.data = value;
	}

	public T getValue() {
		return this.data;
	}

	public void setValue(T value) {
		this.data = value;
	}

	public boolean getPushed() {
		return pushed;
	}

	public void setPushed(boolean value) {
		pushed = value;
	}

	public String toString() {
		if (data == null) {
			return null;
		} else {
			return data.toString();
		}
	}

}
