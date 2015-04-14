package book1.chapter4.linkedlist;

public class Listing2 {
	private String name; // key field
	private String address;
	private String number;

	public Listing2(String n, String a, String num) {
		name = n;
		address = a;
		number = num;
	}

	public String toString() {
		return ("Name is " + name + "\nAddress is " + address + "\nNumber is " + number + "\n");
	}

	public Listing2 deepCopy() {
		Listing2 clone = new Listing2(name, address, number);
		return clone;
	}

	public int compareTo(String targetKey) {
		return (name.compareTo(targetKey));
	}

	public String getNumber() // fetch the phone number
	{
		return number;
	} // end of getNumber method

	public void setNumber(String n) // change the phone number
	{
		number = n;
	} // end of setNumber method
}// end of Listing2 Class
