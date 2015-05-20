package br.com.danielbgg.ctci;

import br.com.danielbgg.examples.linkedlist.Element;
import br.com.danielbgg.examples.linkedlist.LinkedList;

/**
 * Given a circular linked list, implement an algorithm which returns node at
 * the beginning of the loop
 * 
 * DEFINITION
 * 
 * Circular linked list: A (corrupt) linked list in which a node’s next pointer
 * points to an earlier node, so as to make a loop in the linked list
 * 
 * EXAMPLE
 * 
 * input: A -> B -> C -> D -> E -> C [the same C as earlier]
 * 
 * output: C
 */
public class C02Q05 {

	public static Element findCycle(LinkedList ll) {
		Element n1 = ll.getHead();
		Element n2 = ll.getHead();

		// Find meeting point
		while (n2.getNext() != null) {
			n1 = n1.getNext();
			n2 = n2.getNext().getNext();
			if (n1 == n2) {
				break;
			}
		}

		// Error check - there is no meeting point, and therefore no loop
		if (n2.getNext() == null) {
			return null;
		}

		/*
		 * Move n1 to Head. Keep n2 at Meeting Point. Each are k steps from the
		 * Loop Start. If they move at the same pace, they must meet at Loop
		 * Start.
		 */
		n1 = ll.getHead();
		while (n1 != n2) {
			n1 = n1.getNext();
			n2 = n2.getNext();
		}
		// Now n2 points to the start of the loop.
		return n2;

	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		for (int i = 0; i < 11; i++) {
			ll.insert(i);
		}
		ll.getTail().setNext(ll.getHead());
		System.out.println(C02Q05.findCycle(ll).getValue());
	}

}
