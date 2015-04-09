package book1.chapter9.graphs;

public class SimpleGraph // a directed graph
{
	Listing vertex[]; // the reference to the vertex array
	int edge[][]; // reference to the adjacency matrix array
	int max, numberOfVertices;

	public SimpleGraph(int n) {
		vertex = new Listing[n]; // allocation of the vertex array
		edge = new int[n][n]; // adjacency matrix with all elements set to 0
		max = n;
		numberOfVertices = 0;
	}

	public boolean insertVertex(int vertexNumber, Listing newListing) {
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
}// end of SimpleGraph class

