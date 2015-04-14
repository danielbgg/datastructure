package book1.chapter9.graphs;

public class MainSimpleGraphDFT {
	public static void main(String[] args) {
		SimpleGraphDFT flyUS = new SimpleGraphDFT(5);
		Listing2 v0 = new Listing2("V0");
		Listing2 v1 = new Listing2("V1");
		Listing2 v2 = new Listing2("V2");
		Listing2 v3 = new Listing2("V3");
		Listing2 v4 = new Listing2("V4");

		flyUS.insertVertex(0, v0);
		flyUS.insertVertex(1, v1);
		flyUS.insertVertex(2, v2);
		flyUS.insertVertex(3, v3);
		flyUS.insertVertex(4, v4);

		flyUS.insertEdge(0, 1);
		flyUS.insertEdge(0, 3);
		flyUS.insertEdge(0, 4);
		flyUS.insertEdge(1, 2);
		flyUS.insertEdge(1, 3);
		flyUS.insertEdge(2, 1);
		flyUS.insertEdge(3, 0);
		flyUS.insertEdge(3, 1);
		flyUS.insertEdge(3, 4);
		flyUS.insertEdge(4, 0);
		flyUS.insertEdge(4, 3);

		System.out.println("DFT of the graph in Figure 9.19 starting at Vertex 3, \"V3\"");
		flyUS.DFT(3);
	}// end of main
}// end class MainSimpleGraphDFT

