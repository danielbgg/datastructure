package br.com.danielbgg.examples.datastructure;

/*
 * Arrays are a very simple data structure, and may be thought of as a list of a fixed length. 
 * Arrays are nice because of their simplicity, and are well suited for situations where the number of 
 * data items is known (or can be programmatically determined). 
 * Suppose you need a piece of code to calculate the average of several numbers. 
 * An array is a perfect data structure to hold the individual values, since they have no specific order, 
 * and the required computations do not require any special handling other than to iterate through 
 * all of the values. The other big strength of arrays is that they can be accessed randomly, 
 * by index. For instance, if you have an array containing a list of names of students seated in a 
 * classroom, where each seat is numbered 1 through n, then studentName[i] is a trivial way to read or 
 * store the name of the student in seat i. 
 * An array might also be thought of as a pre-bound pad of paper. It has a fixed number of pages, 
 * each page holds information, and is in a predefined location that never changes. 
 */
public class ExemploArray {

	public static void main(String[] args) {
		int i[] = new int[10];
		for (int j = 0; j < i.length; j++) {
			i[j] = 3 * j;
			System.out.println(i[j]);
		}
	}

}
