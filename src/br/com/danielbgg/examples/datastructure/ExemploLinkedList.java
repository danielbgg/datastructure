package br.com.danielbgg.examples.datastructure;

import java.util.LinkedList;

/*
 * A linked list is a data structure that can hold an arbitrary number of data items, 
 * and can easily change size to add or remove items. A linked list, at its simplest, 
 * is a pointer to a data node. Each data node is then composed of data (possibly a record with 
 * several data values), and a pointer to the next node. At the end of the list, the pointer is set 
 * to null. By nature of its design, a linked list is great for storing data when the number of 
 * items is either unknown, or subject to change. However, it provides no way to access an 
 * arbitrary item from the list, short of starting at the beginning and traversing through every node 
 * until you reach the one you want. The same is true if you want to insert a new node at a specific 
 * location. It is not difficult to see the problem of inefficiency. 
 */
public class ExemploLinkedList {

	private static class ListNode {
		String data;
		ListNode nextNode;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		for (int i = 0; i < 100; i++) {
			ll.add(i);
		}
		System.out.println(ll.getFirst());
		System.out.println(ll.getLast());
		System.out.println(ll.get(50));
		
		ListNode firstNode = new ListNode();
		ListNode newNode = new ListNode();
		newNode.nextNode = firstNode;
		firstNode = newNode;

		// Iterating through all of the items in the list is a simple task:

		ListNode curNode = firstNode;
		while (curNode != null) {
			// ProcessData(curNode);
			curNode = curNode.nextNode;
		}
	}
}
