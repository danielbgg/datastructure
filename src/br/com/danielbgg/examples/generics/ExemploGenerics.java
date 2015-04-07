package br.com.danielbgg.examples.generics;

public class ExemploGenerics {

	public static void main(String[] args) {
		Integer[] ages = { 10, 20, 30 };
		output(ages);
		String[] names = { "A", "B", "C" };
		output(names);

		Person<Integer, Integer> p1 = new Person<Integer, Integer>(10, 100);
		Person<Double, Double> p2 = new Person<Double, Double>(20.0, 200.0);
		Person<Float, String> p3 = new Person<Float, String>(30f, "Daniel");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);

	}

	public static <T> void output(T[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

}
