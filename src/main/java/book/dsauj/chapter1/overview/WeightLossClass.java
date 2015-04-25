package book.dsauj.chapter1.overview;

public class WeightLossClass { // data members
	private Person person1, person2, person3; // three Person reference
											  // variables

	// methods
	public WeightLossClass(int a1, double w1, int a2, double w2, int a3, double w3) {
		person1 = new Person(a1, w1); // allocation of three Person objects
		person2 = new Person(a2, w2);
		person3 = new Person(a3, w3);
	}// end of constructor

	public void showAll() {
		System.out.println(person1.toString());
		System.out.println(person2.toString());
		System.out.println(person3.toString());
	}// end of showAll method
}// end of class weightLossStudent
