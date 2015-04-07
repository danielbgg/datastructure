package book1.chapter4.linkedlist;

public class SinglyLinkedListIterator // extends SinglyLinkedList (see Fig.
									  // 4.15)
{
	private Node h; // list header
	public Iterator i;

	public SinglyLinkedListIterator() {
		h = new Node(); // dummy node
		i = new Iterator();
		h.l = null;
		h.next = null;
	}

	public boolean insert(Listing2 newListing) {
		Node n = new Node();
		if (n == null) // out of memory
			return false;
		else {
			n.next = h.next;
			h.next = n;
			n.l = newListing.deepCopy();
			return true;
		}
	}

	public Listing2 fetch(String targetKey) {
		Node p = h.next;
		while (p != null && !(p.l.compareTo(targetKey) == 0)) {
			p = p.next;
		}
		if (p != null)
			return p.l.deepCopy();
		else
			return null;
	}

	public boolean delete(String targetKey) {
		Node q = h;
		Node p = h.next;
		while (p != null && !(p.l.compareTo(targetKey) == 0)) {
			q = p;
			p = p.next;
		}
		if (p != null) {
			q.next = p.next;
			return true;
		} else
			return false;
	}

	public boolean update(String targetKey, Listing2 newListing) {
		if (delete(targetKey) == false)
			return false;
		else if (insert(newListing) == false)
			return false;
		return true;
	}

	public void showAll() {
		Node p = h.next;
		while (p != null) // continue to traverse the list
		{
			System.out.println(p.l.toString());
			p = p.next;
		}
	}

	public class Node {
		private Listing2 l;
		private Node next;

		public Node() {
		}
	}// end of inner class Node

	public class Iterator {
		private Node ip;

		public Iterator() {
			ip = h;
		}

		public void reset() {
			ip = h;
		}

		public boolean hasNext() {
			if (ip.next != null)
				return true;
			else
				return false;
		}

		public Listing2 next() {
			ip = ip.next;
			return ip.l.deepCopy();
		}

		public void set(Listing2 newListing) {
			ip.l = newListing.deepCopy();
		}
	}// end of inner class Iterator
}// end class SinglyLinkedListIterator

