package book1.chapter9.graphs;

public class MainTransitiveClosure {
	public static void main(String[] args) {
		int a[][] = new int[5][5]; // adjacency matrix
		int t[][] = new int[5][5]; // transitive closure matrix
		a[0][1] = 1; // set the adjacency matrix to the matrix shown in Figure
		             // 9.27
		a[0][3] = 1;
		a[1][2] = 1;
		a[1][3] = 1;
		a[3][4] = 1;
		a[4][0] = 1;
		a[4][3] = 1;
		t = TransitiveClosure.transitiveClosure(5, a); // compute the transitive
		                                               // closure matrix
		for (int row = 0; row < 5; row++) // output the transitive closure
		                                  // matrix, t
		{
			System.out.println();
			for (int col = 0; col < 5; col++)
				System.out.print(t[row][col] + " ");
		}
	}// end main method
}// end class MainTransitiveClosure
