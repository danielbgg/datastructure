package book.dsauj.chapter4.linkedlist;

public class SllExternalIterator {
	private NewNode h;

	public SllExternalIterator() {
		h = new NewNode();
		h.next = null;
		h.l = null;
	}

	public boolean insert(Listing2 newListing) {
		NewNode n = new NewNode();
		if (n == null) // out of memory
			return true;
		else {
			n.l = newListing.deepCopy();
			n.next = h.next;
			h.next = n;
			return false;
		}
	}// end insert method

	public Listing2 fetch(String targetKey) {
		NewNode p = h.next;
		while (p != null && p.l.compareTo(targetKey) != 0) {
			p = p.next;
		}
		if (p == null)
			return null;
		else {
			return p.l.deepCopy();
		}
	}// end of fetch

	public boolean delete(String targetKey) {
		NewNode q = h;
		NewNode p = q.next;
		while (p != null && p.l.compareTo(targetKey) != 0) {
			q = q.next;
			p = p.next;
		}
		if (p == null)
			return true;
		else {
			q.next = p.next;
			return false;
		}
	}// end of delete method

	public boolean update(String targetKey, Listing2 newListing) {
		if (delete(targetKey) == true)
			return true;
		else if (insert(newListing) == true)
			return true;
		return false;
	}// end of update

	public void showAll() {
		NewNode p = h.next;
		while (p != null) {
			System.out.println(p.l); // Java automatically uses the toString
									 // method
			p = p.next;
		}
	}// end of showAll method

	public SllIterator iterator() {
		return (new SllIterator(h));
	}
}// end of class SllExternalIterator

