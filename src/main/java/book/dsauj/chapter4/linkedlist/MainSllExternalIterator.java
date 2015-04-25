package book.dsauj.chapter4.linkedlist;

public class MainSllExternalIterator {
	public static void main(String[] args) {
		SllExternalIterator boston = new SllExternalIterator();
		String number;
		Listing2 l1 = new Listing2("Bill", "1st Avenue", "123 4567");
		Listing2 l2 = new Listing2("Al", "2nd Avenue", "456 3232");
		Listing2 l3 = new Listing2("Mike", "3rd Avenue", "333 3333");
		Listing2 aListing;
		boston.insert(l1); // test insert
		boston.insert(l2);
		boston.insert(l3);
		SllIterator i1, i2, i3;
		i1 = boston.iterator();
		i2 = boston.iterator();
		i3 = boston.iterator();
		// output all the listings using iterator 1
		while (i1.hasNext()) {
			aListing = i1.next();
			System.out.println(aListing); // Java automatically uses the
										  // toString method;
		}
		// add an area code to all the listings using iterator 2

		while (i2.hasNext()) {
			l1 = i2.next();
			number = l1.getNumber();
			number = "631 " + number;
			l1.setNumber(number);
			i2.set(l1);
		}
		// output all the updated listings using iterator 3

		while (i3.hasNext()) {
			System.out.println(i3.next());
		}
		System.exit(0);
	}
}
