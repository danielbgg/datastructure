package br.com.danielbgg.ctci;

import br.com.danielbgg.examples.linkedlist.Element;
import br.com.danielbgg.examples.linkedlist.LinkedList;

/**
 * Implement an algorithm to find the nth to last element of a singly linked
 * list
 */
public class C02Q02 {

	public static Element find(LinkedList ll, int number) {
		int n = 0;
		
		Element element = ll.getHead();
		Element element2 = ll.getHead();
		while (element.getNext() != null) {
			n++;
			if (n >= number) {
				element2 = element2.getNext();
			}
			element = element.getNext();
		}
		
		return element2;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		for (int i = 0; i < 11; i++) {
			ll.insert(i);
		}
		System.out.println("todos:");
		ll.printList();

		System.out.println(C02Q02.find(ll, 3).getValue());
	}

}
