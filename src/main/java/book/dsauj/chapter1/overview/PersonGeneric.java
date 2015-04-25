package book.dsauj.chapter1.overview;

public class PersonGeneric<T, E> { // definition of the data members
	private T age;
	private E weight;

	// definition of member functions
	public PersonGeneric(T a, E w) // the constructor
	{
		age = a;
		weight = w;
	}

	public String toString() {
		return ("this person’s age is: " + age + "\n and their weight is: " + weight);
	} // end of toString method
} // end of PersonGeneric class

