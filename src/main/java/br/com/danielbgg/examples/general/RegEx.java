package br.com.danielbgg.examples.general;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {

	public static void main(String[] args) {
		RegEx.regex("This order was placed for QT3000! OK?", "(.*)(\\d+)(.*)");
		RegEx.regex("Marius is one of the topcoders.", "the|top|coder");
		RegEx.regex("This regex matches topcoder and also codertop.", "(top|coder)+");
		RegEx.regex("101 + 10 = 111 , 11111 = 10000 + 1111", "1{2,4}");
		RegEx.regex("top-topcoder|coder", "([a-z]+).\1");
		RegEx.regex("bat", "[^b-d]at");
		RegEx.regex("hat", "[^b-d]at");
		RegEx.regex("<font size=\"2\">Topcoder is the</font> <b>best</b>", "<([a-zA-Z][a-zA-Z0-9]*)(()| [^>]*)>(.*)</\\1>");
	}

	public static void regex(String input, String regex) {
		System.out.println("INPUT: " + input);
		System.out.println("REGEX: " + regex);
		Pattern r = Pattern.compile(regex);
		Matcher m = r.matcher(input);
		int count = 0;
		while (m.find()) {
			   count++;
			System.out.println("RESULT " +count + ": " + m.group() + " (staring at index " +m.start() + " and ending at index " +m.end()+ ")");			
		}
		System.out.println("");
	}

}
