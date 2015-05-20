package br.com.danielbgg.ctci;

import java.util.HashSet;

/**
 * Design an algorithm and write code to remove the duplicate characters in a
 * string without using any additional buffer NOTE: One or two additional
 * variables are fine An extra copy of the array is not
 * 
 * FOLLOW UP Write the test cases for this method
 */
public class C01Q03 {

	private HashSet<Character> set;
	private char[] c;
	private int offset = 0;

	public String removeDuplicates(String s) {
		set = new HashSet<Character>();
		offset = 0;
		c = s.toCharArray();

		for (int i = 0; i < c.length; i++) {
			c[i] = getNextNonDuplicateChar(i);
		}

		return new String(c);
	}

	private char getNextNonDuplicateChar(int initial) {
		for (int i = initial; i < c.length; i++) {
			if (set.contains(c[i])) {
				offset++;
			} else {
				set.add(c[i]);
				return c[i];
			}
		}
		return ' ';
	}

	public static void main(String[] args) {
		C01Q03 c = new C01Q03();
		System.out.println(c.removeDuplicates("abcd"));
		System.out.println(c.removeDuplicates("aaaa"));
		System.out.println(c.removeDuplicates("aaaabbbb"));
		System.out.println(c.removeDuplicates("abababa"));
		System.out.println(c.removeDuplicates("abcabcdefghidef"));
	}

}
