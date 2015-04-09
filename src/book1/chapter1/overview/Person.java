package book1.chapter1.overview;

/*
 * http://www.jblearning.com/catalog/9780763757564/
 * Data Structures and Algorithms Using Java
 */
public class Person { // definition of the data members
	private int age;
	private double weight;

	// definition of member functions
	public Person(int a, double w) // the constructor
	{
		age = a;
		weight = w;
	} // end of constructor

	public String toString() // returns annotated value of data members
	{
		return ("this person’s age is: " + age + "\nand their weight is: " + weight);
	} // end of toString method
} // end of Person class

