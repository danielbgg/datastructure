package br.com.danielbgg.datastructure.linkedlist;

public class StackLinkedList {

	private LinkedList ll;

	public StackLinkedList() {
		ll = new LinkedList();
	}

	public void push(Object data) {
		ll.insertInFront(data);
	}

	public Object pop() {
		Object o = ll.fetchtHead();
		ll.delete(o);
		return o;
	}

	public static final void main(String[] args) {
		StackLinkedList sll = new StackLinkedList();
		for (int i = 0; i < 4; i++) {
			sll.push(i);
		}

		boolean loop = true;
		while (loop) {
			Object data = sll.pop();
			if (data == null) {
				loop = false;
			} else {
				System.out.println(data);
			}
		}

	}

}
