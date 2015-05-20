package br.com.danielbgg.ctci;

import br.com.danielbgg.examples.linkedlist.Element;
import br.com.danielbgg.examples.linkedlist.LinkedList;

/**
 * Write code to remove duplicates from an unsorted linked list
 * 
 * FOLLOW UP
 * 
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class C02Q01 {

	public static void removeDuplicates(LinkedList ll) {
		Element element = ll.getHead();
		while (element.getNext() != null) {
			remove(ll, element);
			element = element.getNext();
		}
	}

	private static void remove(LinkedList ll, Element el) {
		Element element = ll.getHead();
		while (element.getNext() != null && !element.equals(el)) {
			if (el.getValue() == element.getValue()) {
				element = element.getNext();
				ll.delete(el.getValue());
			}
			element = element.getNext();
		}
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		for (int i = 0; i < 4; i++) {
			ll.insert(i);
		}
		ll.insert(2);
		ll.insert(3);
		ll.insert(5);
		System.out.println("todos:");
		ll.printList();

		C02Q01.removeDuplicates(ll);
		System.out.println("todos:");
		ll.printList();

	}

}
