package br.com.danielbgg.examples.linkedlist;

public class LinkedList {

	private Element<Object> head;
	private Element<Object> tail;

	public LinkedList() {
	}

	public void insert(Object data) {
		Element<Object> e = new Element<Object>(data);
		if (head == null) {
			head = e;
			tail = e;
		} else {
			tail.setNext(e);
			tail = e;
		}
	}

	public void insertInFront(Object data) {
		Element<Object> e = new Element<Object>(data);
		if (head == null) {
			head = e;
			tail = e;
		} else {
			Element<Object> oldHead = head;
			head = e;
			e.setNext(oldHead);
		}
	}

	public boolean delete(Object data) {
		if (head == null || data == null) {
			return false;
		} else {
			if (head.getValue() == data || head.getValue().equals(data)) {
				if (head == tail) {
					head = null;
				} else {
					head = head.getNext();
				}
			}

			Element<Object> elem = head;
			Element<Object> before = head;
			while (elem != null) {
				if (elem.getValue() == data || elem.getValue().equals(data)) {
					if (elem == tail) {
						tail = before;
					}
					before.setNext(elem.getNext());
					elem.setNext(null);
					return true;
				}
				before = elem;
				elem = elem.getNext();
			}

		}
		return false;
	}

	public Object fetchtHead() {
		if (head == null) {
			return null;
		} else {
			return head.getValue();
		}
	}
	
	public Element<Object> getHead() {
		return head;
	}

	public Element<Object> getTail() {
		return tail;
	}
	
	public Object fetch(Object data) {
		Element<Object> elem = head;
		while (elem != null) {
			if (elem.getValue() == data || elem.getValue().equals(data)) {
				return elem.getValue();
			}
			elem = elem.getNext();
		}
		return null;
	}

	public void printList() {
		Element<Object> elem = head;
		while (elem != null) {
			System.out.println(elem.getValue());
			elem = elem.getNext();
		}
	}

	public Object findMToLastElement(int m) {
		if (head == null) {
			return null;
		}
		Element<Object> current = head;
		for (int i = 0; i < m; i++) {
			if (current.getNext() != null) {
				current = current.getNext();
			} else {
				return null;
			}
		}

		// Start mBehind at beginning and advance pointers together until
		// current hits last element
		Element<Object> mBehind = head;
		while (current.getNext() != null) {
			current = current.getNext();
			mBehind = mBehind.getNext();
		}

		// mBehind now points to the element we were searching for, so return it
		return mBehind.getValue();
	}

	public boolean determineTermination() {
		Element<Object> slow = head;
		Element<Object> fast = head.getNext();
		while (true) {
			if (fast == null || fast.getNext() == null)
				return false;
			else if (fast == slow || fast.getNext() == slow)
				return true;
			else {
				slow = slow.getNext();
				fast = fast.getNext().getNext();
			}
		}
	}

	public static final void main(String[] args) {

		LinkedList ll = new LinkedList();
		for (int i = 0; i < 4; i++) {
			ll.insert(i);
		}
		System.out.println("todos:");
		ll.printList();

		ll.fetch(3);
		ll.insertInFront(-1);
		ll.insertInFront(-2);
		ll.delete(3);
		ll.insert(4);
		System.out.println("parcial 1:");
		ll.printList();

		ll.delete(2);
		ll.delete(-1);
		ll.delete(-2);
		ll.delete(0);
		ll.delete(1);
		ll.insert(15);
		ll.delete(15);
		System.out.println("parcial 2:");
		ll.printList();
		System.out.println(ll.determineTermination());

		LinkedList ll2 = new LinkedList();
		for (int i = 1; i < 11; i++) {
			ll2.insert(i);
		}
		System.out.println("parcial 3:");
		ll2.printList();
		System.out.println("parcial 4:");
		System.out.println(ll2.findMToLastElement(1));
		System.out.println(ll2.findMToLastElement(8));
		System.out.println(ll2.findMToLastElement(10));
		System.out.println(ll2.findMToLastElement(15));
		System.out.println(ll2.determineTermination());

		LinkedList ll3 = new LinkedList();
		for (int i = 1; i < 11; i++) {
			ll3.insert(i);
		}
		// ll3.loop();
		System.out.println("parcial 5:");
		System.out.println(ll3.determineTermination());

	}

}
