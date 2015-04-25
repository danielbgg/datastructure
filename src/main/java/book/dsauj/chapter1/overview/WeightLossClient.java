package book.dsauj.chapter1.overview;

public class WeightLossClient extends Person { // member data
	private double goalWeight;

	// member methods
	public WeightLossClient(int a, double w, double g) {
		super(a, w); // initializes the age and weight , the inherited
					 // attributes
		goalWeight = g;
	}

	public String toString() {
		String s = super.toString(); // invokes the inherited toString method
									 // for age and weight
		return (s + "\nand the person’s goal weight is: " + goalWeight);
	}
}
