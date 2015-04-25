package book.dsauj.chapter2.array;

public class UOA<T> {
	private int next;
	private T[] data;
	private int size;

	public UOA() {
		next = 0;
		size = 100;
		data = (T[]) new Object[100];
	}// end of constructor

	public UOA(int s) {
		next = 0;
		data = (T[]) new Object[s];
		size = s;
	}// end of constructor

	public boolean insert(T newListing) {
		KeyMode node = (KeyMode) newListing;
		if (next >= size)
			return false; // check for too many listings
		data[next] = (T) node.deepCopy();
		if (data[next] == null) // check for insufficient memory
			return false;
		next = next + 1;
		return true; // insert performed
	} // end of insert method

	public KeyMode fetch(Object targetKey) { // access the node using a
											 // sequential search, returns null
											 // for
		                                     // not found
		KeyMode node = (KeyMode) data[0];
		T temp;
		int i = 0;
		while (i < next && node.compareTo(targetKey) != 0) {
			i++;
			node = (KeyMode) data[i];
		}
		if (i == next) // the node with the given key was not found.
			return null;
		// deep copy the nodes information into returned node
		node = node.deepCopy();
		// move the node up one position in the array, unless it is the
		// first node
		if (i != 0) // bubble-up accessed node
		{
			temp = data[i - 1];
			data[i - 1] = data[i];
			data[i] = temp;
		}
		return node;
	}// end of the fetch method

	public boolean delete(Object targetKey) { // access the node using a
											  // sequential search, returns null
											  // for
		                                      // not found
		KeyMode node = (KeyMode) data[0];
		int i = 0;
		while (i < next && node.compareTo(targetKey) != 0) {
			i++;
			node = (KeyMode) data[i];
		}
		if (i == next) // the node was not found
			return false;
		// move the last node into the deleted node’s position
		data[i] = data[next - 1];
		data[next - 1] = null;
		next = next - 1;
		return true;
	}// end of delete method

	public boolean update(Object targetKey, T newNode) {
		if (delete(targetKey) == false)
			return false;
		else if (insert(newNode) == false)
			return false;
		else
			return true;
	}// end of update method

	public void showAll() {
		for (int i = 0; i < next; i++)
			System.out.println(data[i].toString());
	}// end of toString method
}// end of class UOA

