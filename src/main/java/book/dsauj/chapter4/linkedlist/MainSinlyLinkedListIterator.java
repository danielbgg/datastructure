package book.dsauj.chapter4.linkedlist;

public class MainSinlyLinkedListIterator {
	public static void main(String[] args) {
		SinglyLinkedListIterator boston = new SinglyLinkedListIterator();
		String number;
		Listing2 l1 = new Listing2("Bill", "1st Avenue", "123 4567");
		Listing2 l2 = new Listing2("Al", "2nd Avenue", "456 3232");
		Listing2 l3 = new Listing2("Mike", "3rd Avenue", "333 3333");
		boston.insert(l1); // test insert
		boston.insert(l2);
		boston.insert(l3);
		// output all the listings using the iterator, i
		while (boston.i.hasNext()) {
			System.out.println(boston.i.next()); // Java automatically invokes
												 // toString
		}
		// add an area code to all the listings using the iterator, i
		boston.i.reset();
		while (boston.i.hasNext()) {
			l1 = boston.i.next();
			number = l1.getNumber();
			number = "631 " + number;
			l1.setNumber(number);
			boston.i.set(l1);
		}
		// output the updated listings using the iterator, i
		boston.i.reset();
		while (boston.i.hasNext()) {
			System.out.println(boston.i.next()); // Java automatically invokes
												 // toString
		}
		System.exit(0);
	}// end of iterator application

}
