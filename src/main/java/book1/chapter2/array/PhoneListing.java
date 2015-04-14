package book1.chapter2.array;

public class PhoneListing implements KeyMode // 's 3 methods
{
	private String name; // key field
	private String address;
	private String number;

	public PhoneListing(String n, String a, String num) {
		name = n;
		address = a;
		number = num;
	}

	public String toString() {
		return ("Name is " + name + "\nAddress is " + address + "\nNumber is " + number + "\n");
	}

	public KeyMode deepCopy() {
		PhoneListing clone = new PhoneListing(name, address, number);
		return clone;
	}

	public int compareTo(Object targetKey) {
		String tKey = (String) targetKey; // targetKey is a String
		return (name.compareTo(tKey));
	} // end of compareTo method
} // end of class PhoneListin
