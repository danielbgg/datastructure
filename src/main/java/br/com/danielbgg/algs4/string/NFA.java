package br.com.danielbgg.algs4.string;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedDFS;
import edu.princeton.cs.algs4.Stack;

/**
 * This constructor builds an NFA corresponding to a given RE by creating a
 * digraph of E-transitions.
 * 
 * 
 * Definition. A regular expression (RE) is either
 * 
 * Empty
 * 
 * A single character
 * 
 * A regular expression enclosed in parentheses
 * 
 * Two or more concatenated regular expressions
 * 
 * Two or more regular expressions separated by the or operator (|)
 * 
 * A regular expression followed by the closure operator (*)
 * 
 * Proposition Q. Determining whether an N-character text string is recognized
 * by the NFA corresponding to an M-character RE takes time proportional to NM
 * in the worst case.
 * 
 * Proof: For each of the N text characters, we iterate through a set of states
 * of size no more than M and run a DFS on the digraph of -transitions. The
 * construction that we will consider next establishes that the number of edges
 * in that digraph is no more than 2M, so the worst-case time for each DFS is
 * proportional to M.
 * 
 * Proposition R. Building the NFA corresponding to an M-character RE takes time
 * and space proportional to M in the worst case.
 * 
 * Proof. For each of the M RE characters in the regular expression, we add at
 * most three E-transitions and perhaps execute one or two stack operations.
 */
public class NFA {
	private char[] re; // match transitions
	private Digraph G; // epsilon transitions
	private int M; // number of states

	public NFA(String regexp) { // Create the NFA for the given regular
		                        // expression.
		Stack<Integer> ops = new Stack<Integer>();
		re = regexp.toCharArray();
		M = re.length;
		G = new Digraph(M + 1);
		for (int i = 0; i < M; i++) {
			int lp = i;
			if (re[i] == '(' || re[i] == '|')
				ops.push(i);
			else if (re[i] == ')') {
				int or = ops.pop();
				if (re[or] == '|') {
					lp = ops.pop();
					G.addEdge(lp, or + 1);
					G.addEdge(or, i);
				} else
					lp = or;
			}
			if (i < M - 1 && re[i + 1] == '*') // lookahead
			{
				G.addEdge(lp, i + 1);
				G.addEdge(i + 1, lp);
			}
			if (re[i] == '(' || re[i] == '*' || re[i] == ')')
				G.addEdge(i, i + 1);
		}
	}

	public boolean recognizes(String txt) { // Does the NFA recognize txt?
		Bag<Integer> pc = new Bag<Integer>();
		DirectedDFS dfs = new DirectedDFS(G, 0);
		for (int v = 0; v < G.V(); v++)
			if (dfs.marked(v))
				pc.add(v);
		for (int i = 0; i < txt.length(); i++) { // Compute possible NFA states
			                                     // for txt[i+1].
			Bag<Integer> match = new Bag<Integer>();
			for (int v : pc)
				if (v < M)
					if (re[v] == txt.charAt(i) || re[v] == '.')
						match.add(v + 1);
			pc = new Bag<Integer>();
			dfs = new DirectedDFS(G, match);
			for (int v = 0; v < G.V(); v++)
				if (dfs.marked(v))
					pc.add(v);
		}
		for (int v : pc)
			if (v == M)
				return true;
		return false;
	}
}