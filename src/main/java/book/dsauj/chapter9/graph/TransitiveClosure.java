package book.dsauj.chapter9.graph;

public class TransitiveClosure {
	public static int[][] transitiveClosure(int n, int adjacency[][]) {
		int t[][] = new int[n][n];
		for (int row = 0; row < n; row++)
			// set t to the adjacency matrix
			for (int col = 0; col < n; col++)
				t[row][col] = adjacency[row][col];
		// Warshall’s algorithm
		for (int b = 0; b < n; b++) // for each vertex, b
		{
			for (int c = 0; c < n; c++) // locate the paths from vertex b to
										// vertex c
			{
				if (t[b][c] == 1) // a path from vertex b to some vertex c has
								  // been found
				{
					for (int a = 0; a < n; a++) // find the paths to b
					{
						if (t[a][b] == 1 && a != c) // a path to b from a has
													// been found
							t[a][c] = 1; // mark that a path from vertex a to
										 // vertex c exists
					}// end for
				}// end if
			}// end for
		}// end for
		return t;
	}

}
