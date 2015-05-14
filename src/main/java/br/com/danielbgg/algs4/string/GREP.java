package br.com.danielbgg.algs4.string;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class GREP {

	public GREP() {
	}

	public void search(In in, String regex) {
		String regexp = "(.*" + regex + ".*)";
		NFA nfa = new NFA(regexp);
		while (in.hasNextLine()) {
			String txt = in.readLine();
			if (nfa.recognizes(txt))
				StdOut.println(txt);
		}
	}
}