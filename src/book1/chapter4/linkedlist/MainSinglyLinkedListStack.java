package book1.chapter4.linkedlist;

public class MainSinglyLinkedListStack {
	public static void main(String[] args) {
		SinglyLinkedList boston = new SinglyLinkedList();
		Listing l1 = new Listing("X", "1st Avenue", "123 4567");
		Listing l2 = new Listing("X", "2nd Avenue", "456 3232");
		Listing l3 = new Listing("X", "3rd Avenue", "333 3333");
		// three “push” operations
		boston.insert(l1);
		boston.insert(l2);
		boston.insert(l3);
		// Three “pop” operations
		l3 = boston.fetch("X"); // first “pop”
		boston.delete("X");
		System.out.println(l3); // (Java automatically invokes the toString
								// method)
		l3 = boston.fetch("X"); // second “pop”
		boston.delete("X");
		System.out.println(l3); // (Java automatically invokes the toString
								// method)
		l3 = boston.fetch("X"); // third “pop”
		boston.delete("X");
		System.out.println(l3); //
		System.exit(0);
	}
}
