package book.ctci.chapter18.q9;

import java.util.Comparator;

public class MaxHeapComparator implements Comparator<Integer>{
	// Comparator that sorts integers from highest to lowest
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		if (o1 < o2) return 1;
		else if (o1 == o2) return 0;
		else return -1;
	}
}
