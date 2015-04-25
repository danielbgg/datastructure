package book.dsauj.chapter9.graph;

public class MainSimpleGraph {
	public static void main(String[] args) {
		SimpleGraph flyUS = new SimpleGraph(5);
		Listing v0 = new Listing("Philadelphia");
		Listing v1 = new Listing("New York");
		Listing v2 = new Listing("Boston");
		Listing v3 = new Listing("Los Angeles");
		Listing v4 = new Listing("Huston");
		// add the hub cities to the graph as vertices
		flyUS.insertVertex(0, v0);
		flyUS.insertVertex(1, v1);
		flyUS.insertVertex(2, v2);
		flyUS.insertVertex(3, v3);
		flyUS.insertVertex(4, v4);
		// add the routes to the graph as edges
		flyUS.insertEdge(0, 1);
		flyUS.insertEdge(0, 3);
		flyUS.insertEdge(1, 2);
		flyUS.insertEdge(1, 3);
		flyUS.insertEdge(2, 1);
		flyUS.insertEdge(3, 4);
		flyUS.insertEdge(4, 0);
		flyUS.insertEdge(4, 3);
		// output the hubs and the routes stored in the graph
		for (int i = 0; i < 5; i++) {
			System.out.print("hub " + i + "\'s ");
			flyUS.showVertex(i);
			System.out.println("its routes are: ");
			flyUS.showEdges(i);
		} // end the output loop
	} // end the method main
} // end the application

