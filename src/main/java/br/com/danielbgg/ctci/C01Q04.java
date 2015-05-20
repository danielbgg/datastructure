package br.com.danielbgg.ctci;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a method to decide if two strings are anagrams or not
 * 
 * Solution #1: Sort the strings (sort(s) == sort(t))
 */
public class C01Q04 {

	public static boolean anagram(String s1, String s2) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		for (int i = 0; i < c1.length; i++) {
			if (map.containsKey(c1[i])) {
				int v = map.get(c1[i]);
				map.put(c1[i], v++);
			} else {
				map.put(c1[i], 1);
			}
		}

		for (int i = 0; i < c2.length; i++) {
			if (map.containsKey(c2[i])) {
				int v = map.get(c2[i]);
				v--;
				if (v == 0) {
					map.remove(c2[i]);
				} else {
					map.put(c2[i], v);
				}
			} else {
				return false;
			}
		}

		if (map.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(C01Q04.anagram("abcd", "dcba"));
		System.out.println(C01Q04.anagram("abcde", "dcbag"));
	}

}
