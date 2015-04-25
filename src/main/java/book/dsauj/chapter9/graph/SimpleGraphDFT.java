package book.dsauj.chapter9.graph;

import java.util.Stack;

class SimpleGraphDFT // adds a method DFT to the class presented in Figure 9.14
{
	Listing2 vertex[]; // the reference to the vertex array
	int edge[][]; // reference to the adjacency matrix array
	int max, numberOfVertices;

	public SimpleGraphDFT(int n) {
		vertex = new Listing2[n]; // allocation of the vertex array
		edge = new int[n][n]; // adjacency matrix with all elements set to 0
		max = n;
		numberOfVertices = 0;
	}

	public void DFT(int firstVertex) {
		int v;
		Stack<Integer> stack = new Stack(); // uses Java Stack class
		// initialize all vertices to not visited
		for (int i = 0; i < numberOfVertices; i++) {
			if (vertex[i] != null)
				vertex[i].setPushed(false); // mark all vertices unvisited
		}
		stack.push(firstVertex); // visit the first vertex
		vertex[firstVertex].setPushed(true);
		// visit all the decedents
		while (!stack.empty()) {
			v = stack.pop();
			vertex[v].visit(); // visit a vertex
			for (int column = 0; column < numberOfVertices; column++) {
				if (edge[v][column] == 1 && !vertex[column].getPushed()) {
					stack.push(column);
					vertex[column].setPushed(true);
				} // end if
			} // end for
		} // end while
	} // end DFT method

	public boolean insertVertex(int vertexNumber, Listing2 newListing) {
		if (vertexNumber >= max) // the graph is full
			return false;
		vertex[vertexNumber] = newListing.deepCopy();
		numberOfVertices++;
		return true;
	}

	public boolean insertEdge(int fromVertex, int toVertex) {
		if (vertex[fromVertex] == null || vertex[toVertex] == null) // non-existent
		                                                            // vertex
			return false;
		edge[fromVertex][toVertex] = 1;
		return true;
	}

	public void showVertex(int vertexNumber) {
		System.out.println(vertex[vertexNumber]);
	}

	public void showEdges(int vertexNumber) // edges emanating from vertexNumber
	{
		for (int column = 0; column < numberOfVertices; column++) {
			if (edge[vertexNumber][column] == 1) // there is an edge
				System.out.println(vertexNumber + "," + column);
		}
	}
} // end calss SimpleGraphDFT

