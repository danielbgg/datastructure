package book1.chapter5.hashed;

import java.util.Hashtable;

public class MainAPIHashtable {
	public static void main(String[] args) {
		Hashtable<String, Listing> dataBase = new Hashtable<String, Listing>();
		Listing b, t;
		Listing bill = new Listing("Bill", "1st Avenue", "999 9999");
		Listing tom = new Listing("Tom", "2nd Avenue", "456 8978");
		Listing newBill = new Listing("William", "99th Street", "123 4567");
		// inserts
		dataBase.put("Bill", bill);
		dataBase.put("Tom", tom);
		// fetches
		b = dataBase.get("Bill");
		t = dataBase.get("Tom");
		System.out.println(b);
		System.out.println(t);
		// effectively an update of Bill's address
		dataBase.put("Bill", newBill);
		b = dataBase.get("Bill"); // fetches
		System.out.println(b);
		// demonstration of the lack of encapsulation. Client can change the
		// contents of the node
		newBill.setAddress("18 Park Avenue");
		b = dataBase.get("Bill");
		System.out.println(b);
		// delete operation
		dataBase.remove("Bill");
		b = dataBase.get("Bill");
		System.out.println(b);
	}
}
