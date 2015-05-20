package br.com.danielbgg.ctci;

import java.util.HashSet;

/**
 * Implement an algorithm to determine if a string has all unique characters
 * What if you can not use additional data structures?
 * 
 * If we are allowed to destroy the input string, we could sort the string in
 * O(n log n) time and then linearly check the string for neighboring characters
 * that are identical Careful, though - many sorting algorithms take up extra
 * space
 */
public class C01Q01 {

	// Implement an algorithm to determine if a string has all unique characters
	public static boolean hasUniqueChars1(String s) {
		HashSet<Character> set = new HashSet<Character>();
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (set.contains(c[i])) {
				return false;
			} else {
				set.add(c[i]);
			}
		}
		return true;
	}

	// What if you can not use additional data structures?
	public static boolean hasUniqueChars2(String s) {
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			char c1 = c[i];
			for (int j = c.length - 1; j >= 0; j--) {
				char c2 = c[j];
				if (c1 == c2 && i != j) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean hasUniqueChars3(String str) {
		if (str.length() > 128) {
			return false;
		}
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0)
				return false;
			checker |= (1 << val);
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(C01Q01.hasUniqueChars1("test"));
		System.out.println(C01Q01.hasUniqueChars1("asdfglkjhzxcvbmn"));
		System.out.println(C01Q01.hasUniqueChars2("test"));
		System.out.println(C01Q01.hasUniqueChars2("asdfglkjhzxcvbmn"));
		System.out.println(C01Q01.hasUniqueChars3("test"));
		System.out.println(C01Q01.hasUniqueChars3("asdfglkjhzxcvbmn"));
	}

}
