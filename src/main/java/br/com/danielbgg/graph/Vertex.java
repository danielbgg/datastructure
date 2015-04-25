package br.com.danielbgg.graph;

public class Vertex {

	public static int COLOR_WHITE = 10;
	public static int COLOR_GRAY = 20;
	public static int COLOR_BLACK = 30;

	private String description;
	private int color;
	private int d;
	private Vertex parent;

	public Vertex(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public Vertex getParent() {
		return parent;
	}

	public void setParent(Vertex parent) {
		this.parent = parent;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("- This is vertex: " + description + "\n");
		sb.append("  - Color: " + color + "\n");
		sb.append("  - Dimension: " + d + "\n");
		sb.append("  - Parent: " + (parent == null ? null : parent.getDescription()) + "\n");
		return sb.toString();
	}

}
