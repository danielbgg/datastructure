package book1.chapter4.linkedlist;

public class SllIterator // implements Iterator
{
	private NewNode ip;
	private NewNode h;

	public SllIterator(NewNode h) {
		ip = h;
		this.h = h;
	}

	public void reset() {
		ip = h;
	}

	public boolean hasNext() {
		if (ip.next == null)
			return false;
		else
			return true;
	};

	public Listing2 next() {
		ip = ip.next;
		return ip.l.deepCopy();
	}

	public void set(Listing2 newListing) {
		ip.l = newListing.deepCopy();
	}
}// end of the class SllIterator;

