package book.pieslynj.strings;

import java.util.HashMap;

public class StringAlgorithms {

	private static final int MAX_DIGITS = 10;
	private static final Object once = new Object();
	private static final Object multiple = new Object();

	// suport for unicode 32bit characters
	public static String firstNonRepeated(String str) {
		HashMap<Integer, Object> charHash = new HashMap<Integer, Object>();
		for (int i = 0; i < str.length();) {
			int cp = str.codePointAt(i);
			i = i + Character.charCount(cp);
			Object seen = charHash.get(cp);
			if (seen == null) {
				charHash.put(cp, once);
			} else {
				if (seen == once) {
					charHash.put(cp, multiple);
				}
			}
		}
		for (int i = 0; i < str.length(); i++) {
			int cp = str.codePointAt(i);
			i = i + Character.charCount(cp);
			if (charHash.get(cp) == once) {
				return new String(Character.toChars(cp));
			}
		}
		return null;
	}

	// asc 2 characters only
	public static String removeChars(String str, String remove) {
		char[] s = str.toCharArray();
		char[] r = remove.toCharArray();
		boolean[] flags = new boolean[128];
		for (int i = 0; i < r.length; ++i) {
			flags[r[i]] = true;
		}
		int dst = 0;
		for (int i = 0; i < s.length; ++i) {
			if (!flags[s[i]]) {
				s[dst++] = s[i];
			}
		}
		return new String(s, 0, dst);
	}

	public static String reverseWords(String s) {
		int start = 0, end = 0, length;
		length = s.length();
		char[] str = s.toCharArray();
		reverseString(str, start, length - 1);
		while (end < length) {
			if (str[end] != ' ') {
				start = end;
				while (end < length && str[end] != ' ') {
					end++;
				}
				end--;
				reverseString(str, start, end);
			}
			end++;
		}
		return new String(str);
	}

	private static void reverseString(char[] str, int start, int end) {
		char temp;
		while (end > start) {
			temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}
	}

	public static int strToInt(String str) {
		int i = 0, num = 0;
		boolean isNeg = false;
		int len = str.length();
		if (str.charAt(0) == '-') {
			isNeg = true;
			i = 1;
		}
		while (i < len) {
			num *= 10;
			num += (str.charAt(i++) - '0');
		}
		if (isNeg)
			num = -num;
		return num;
	}

	public static String intToStr(int num) {
		int i = 0;
		boolean isNeg = false;
		char[] temp = new char[MAX_DIGITS + 1];
		if (num < 0) {
			num = -num;
			isNeg = true;
		}
		do {
			temp[i++] = (char) ((num % 10) + '0');
			num /= 10;
		} while (num != 0);
		StringBuilder b = new StringBuilder();
		if (isNeg)
			b.append('-');
		while (i > 0) {
			b.append(temp[--i]);
		}
		return b.toString();
	}

	public static void main(String[] args) {
		System.out.println(StringAlgorithms.firstNonRepeated("tester"));
		System.out.println(StringAlgorithms.removeChars("Battle of the Vowels: Hawaii vs. Grozny", "aeiou"));
		System.out.println(StringAlgorithms.reverseWords("Do or do not, there is no try."));
		System.out.println(StringAlgorithms.strToInt("2344"));
		System.out.println(StringAlgorithms.intToStr(2344));
	}

}
