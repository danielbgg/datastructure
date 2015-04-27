package br.com.danielbgg.interview.google.prefix;

import java.util.StringTokenizer;

/**
 * Q: Given a list of strings where each string is a ' '-delimited "phrase" of
 * "words" (a word is one or more non-' ' characters), compute and return the
 * longest phrase which is a prefix or exact match for every phrase in the
 * input. Matching is at the granularity of words. Eg. Given an input list with
 * the two elements "this is a short phrase" and
 * "this is a slightly longer phrase", the expected result is "this is a".
 * 
 * Given an input list with the three elements "this is a long phrase",
 * "this is a short one" and "this is also a phrase", the expected result is
 * "this is".
 * 
 * {"this is a long phrase", "this is a short one", "this is also a phrase"} =>
 * “this is” {"this is a long phrase", "this", "this is also a phrase"} =>
 * “this”
 */
public class PrefixPhrase {

	public String analyse(String[] args) {
		// defensive programming
		if (args == null || args.length == 0) {
			return "";
		}
		if (args.length == 1) {
			return args[0];
		}

		String first = args[0];
		String comparison = "";
		String oldComparison = "";
		int number = 1;
		boolean cont = true;

		while (cont == true) {
			oldComparison = comparison;
			comparison = giveMeWords(first, number);
			cont = work(comparison, args);
			number++;
		}

		if (cont == true) {
			return comparison.trim();
		} else {
			return oldComparison.trim();
		}
	}

	private boolean work(String comparison, String[] args) {
		boolean cont = true;
		for (int i = 1; i < args.length; i++) {
			String toBeAnalyzed = args[i];
			if (!toBeAnalyzed.startsWith(comparison)) {
				// STOP MY COMPARISONS
				cont = false;
				break;
			}
		}
		return cont;
	}

	private String giveMeWords(String s, int howMany) {
		// TODO: returns a quantity of words in a given String
		StringTokenizer idata = new StringTokenizer(s);
		StringBuffer ret = new StringBuffer("");
		int i = 0;
		while (i < howMany && idata.hasMoreTokens()) {
			ret.append(idata.nextToken());
			ret.append(" ");
			i++;
		}
		return ret.toString();
	}

}