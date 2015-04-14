package br.com.danielbgg.datastructure.sorting;

//This implementation uses the Apache Commons Collections CursorableLinkedList class rather than LinkedList from the Java Collections Framework because CurorableLinkedList can maintain the validity of an iterator (cursor) even as the list is modified through other iterators. This capability enables a more efficient implementation of the sort. The implementation could be further optimized if you implemented a custom linked list class that supported copying iterators and moving (rather than just deleting and inserting) elements.
public class SelectionSortStable {
	/*
	public void selectionSortStable(CursorableLinkedList data) {
		CursorableLinkedList.Cursor sortedBoundary = data.cursor(0);
		while (sortedBoundary.hasNext()) {
			sortedBoundary.add(getMinimum(data, sortedBoundary.nextIndex()));
		}
	}

	// remove and return the first minimum-value element from data
	// with position greater than start
	private Comparable getMinimum(CursorableLinkedList data, int start) {
		CursorableLinkedList.Cursor unsorted = data.cursor(start);
		CursorableLinkedList.Cursor minPos = data.cursor(start + 1);
		Comparable minValue = (Comparable) minPos.previous();

		while (unsorted.hasNext()) {
			if (((Comparable) unsorted.next()).compareTo(minValue) < 0) {
				// advance minPos to new minimum value location
				while (minPos.nextIndex() < unsorted.nextIndex())
					minValue = (Comparable) minPos.next();
			}
		}
		minPos.remove();
		minPos.close();
		unsorted.close();
		return minValue;
	}
	*/
}
