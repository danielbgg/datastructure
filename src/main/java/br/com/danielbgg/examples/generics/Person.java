package br.com.danielbgg.examples.generics;

public class Person<A, B> {
	private A age;
	private B weight;

	public Person(A a, B b) {
		this.age = a;
		this.weight = b;
	}

	public String toString() {
		return "Age: " + age + " - Weight: " + weight;
	}

}