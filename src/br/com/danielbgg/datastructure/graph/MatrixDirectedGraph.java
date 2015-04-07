package br.com.danielbgg.datastructure.graph;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class MatrixDirectedGraph {

	public enum TraversalType {
		DEPTH_FIRST_TRAVERSAL, BREADTH_FIRST_TRAVERSAL
	};

	// vertex array
	Element<?> vertex[];
	// adjacency matrix array
	int edge[][];
	int max;
	int numberOfVertices;

	public MatrixDirectedGraph(int n) {
		vertex = new Element[n];
		edge = new int[n][n];
		max = n;
		numberOfVertices = 0;
	}

	public boolean insertVertex(int vertexNumber, Element<String> data) {
		if (vertexNumber >= max) {
			return false;
		}
		vertex[vertexNumber] = data;
		numberOfVertices++;
		return true;
	}

	public boolean insertEdge(int fromVertex, int toVertex) {
		if (vertex[fromVertex] == null || vertex[toVertex] == null) {
			return false;
		}
		edge[fromVertex][toVertex] = 1;
		return true;
	}

	public Object getVertex(int vertexNumber) {
		if (vertexNumber >= max) {
			return null;
		}
		return vertex[vertexNumber];
	}

	public void showVertex(int vertexNumber) {
		if (vertexNumber >= max) {
			return;
		}
		System.out.println(vertex[vertexNumber]);
	}

	public void showEdges(int vertexNumber) {
		if (vertexNumber >= max) {
			return;
		}
		for (int i = 0; i < numberOfVertices; i++) {
			if (edge[vertexNumber][i] == 1) {
				System.out.println("-- " + vertex[i]);
			}
		}
	}

	public void showAll(TraversalType type, int firstVertex) {
		if (type == null) {
			return;
		} else if (type == TraversalType.DEPTH_FIRST_TRAVERSAL) {
			System.out.println("DFT (DEPTH FIRST TRAVERSAL) - Show All");
			showAllDFT(firstVertex);
		} else if (type == TraversalType.BREADTH_FIRST_TRAVERSAL) {
			System.out.println("BFT (BREADTH FIRST TRAVERSAL) - Show All");
			showAllBFT(firstVertex);
		}
	}

	private void visit(Element<?> value) {
		System.out.println("Found: " + value);
	}

	private void showAllDFT(int firstVertex) {
		int v;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < numberOfVertices; i++) {
			if (vertex[i] != null) {
				vertex[i].setPushed(false);
			}
		}
		stack.push(firstVertex);
		vertex[firstVertex].setPushed(true);
		while (!stack.empty()) {
			v = stack.pop();
			visit(vertex[v]);
			for (int j = 0; j < numberOfVertices; j++) {
				if (edge[v][j] == 1 && !vertex[j].getPushed()) {
					stack.push(j);
					vertex[j].setPushed(true);
				}
			}
		}
	}

	private void showAllBFT(int firstVertex) {
		int v;
		Queue<Integer> queue = new LinkedBlockingQueue<Integer>();
		for (int i = 0; i < numberOfVertices; i++) {
			if (vertex[i] != null) {
				vertex[i].setPushed(false);
			}
		}
		queue.add(firstVertex);
		vertex[firstVertex].setPushed(true);
		while (!queue.isEmpty()) {
			v = queue.poll();
			visit(vertex[v]);
			for (int j = 0; j < numberOfVertices; j++) {
				if (edge[v][j] == 1 && !vertex[j].getPushed()) {
					queue.add(j);
					vertex[j].setPushed(true);
				}
			}
		}
	}

	public static void main(String[] args) {
		MatrixDirectedGraph flyUS = new MatrixDirectedGraph(5);
		flyUS.insertVertex(0, new Element<String>("Philadelphia"));
		flyUS.insertVertex(1, new Element<String>("New York"));
		flyUS.insertVertex(2, new Element<String>("Boston"));
		flyUS.insertVertex(3, new Element<String>("Los Angeles"));
		flyUS.insertVertex(4, new Element<String>("Huston"));
		flyUS.insertEdge(0, 1);
		flyUS.insertEdge(0, 3);
		flyUS.insertEdge(1, 2);
		flyUS.insertEdge(1, 3);
		flyUS.insertEdge(2, 1);
		flyUS.insertEdge(3, 4);
		flyUS.insertEdge(4, 0);
		flyUS.insertEdge(4, 3);

		for (int i = 0; i < 5; i++) {
			System.out.print("hub " + i + ": ");
			flyUS.showVertex(i);
			System.out.println("Routes: ");
			flyUS.showEdges(i);
		}

		flyUS.showAll(TraversalType.DEPTH_FIRST_TRAVERSAL, 0);
		flyUS.showAll(TraversalType.BREADTH_FIRST_TRAVERSAL, 0);
	}

}
