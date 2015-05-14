package book.ctci.chapter11.q8;

import java.util.Comparator;

public class IntComparable implements Comparator<Integer>{
	 
	public int compare(Integer o1, Integer o2) {
		return o1.compareTo(o2);
	}
}
