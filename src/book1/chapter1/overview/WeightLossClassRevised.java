package book1.chapter1.overview;

public class WeightLossClassRevised { // data members
	private WeightLossClient person1, person2, person3; // three
														// WeightLossClient
														// reference variables

	// methods
	public WeightLossClassRevised(int a1, double w1, double g1, int a2, double w2, double g2, int a3, double w3, double g3) {
		person1 = new WeightLossClient(a1, w1, g1); // allocation of three
		person2 = new WeightLossClient(a2, w2, g2); // WeightLossClient objects
		person3 = new WeightLossClient(a3, w3, g3);
	}

	public void showAll() {
		System.out.println(person1.toString());
		System.out.println(person2.toString());
		System.out.println(person3.toString());
	}// end of showAll method
} // end of class WeightLossClassRevised

