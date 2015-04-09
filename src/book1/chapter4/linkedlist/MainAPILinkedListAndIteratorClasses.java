package book1.chapter4.linkedlist;

import java.util.*;

public class MainAPILinkedListAndIteratorClasses {
	public static void main(String args[]) {
		LinkedList DataBase = new LinkedList();
		Listing2 b;
		Listing2 a;
		Listing2 bill = new Listing2("Bill", "1st Avenue", "123 4567");
		Listing2 al = new Listing2("Al", "2nd Avenue", "456 3232");
		// declare a ListIterator attached to the structure Database
		ListIterator i = DataBase.listIterator();

		// add two phone listings to the data set
		i.add(bill);
		i.add(al);

		// return the iterator to the front of the list
		while (i.hasPrevious())
			i.previous();

		// fetch back the two listings and output them
		a = (Listing2) i.next();
		b = (Listing2) i.next();
		System.out.println(a);
		System.out.println(b);

		// demonstrate the structure is un-encapsulated
		// change Bill's phone number to 999 9999
		bill.setNumber("999 9999");
		// return the iterator to the front of the list
		while (i.hasPrevious())
			i.previous();
		// fetch and output William’s listing from the structure
		a = (Listing2) i.next();
		System.out.println(a);
	}
}
