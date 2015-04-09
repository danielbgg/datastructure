package book1.chapter9.graphs;

public class Listing2 {
	private String name;
	boolean pushed;

	public Listing2(String n) {
		name = n;
	}

	public String toString() {
		return ("Name is " + name);
	}

	public Listing2 deepCopy() {
		Listing2 clone = new Listing2(name);
		return clone;
	}

	public boolean getPushed() {
		return pushed;
	}

	public void setPushed(boolean value) {
		pushed = value;
	}

	public void visit() {
		System.out.println(this);
	}
}
