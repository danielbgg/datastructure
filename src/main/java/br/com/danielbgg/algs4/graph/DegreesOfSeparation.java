package br.com.danielbgg.algs4.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Degrees of separation. One of the classic applications of graph processing is
 * to find the degree of separation between two individuals in a social network.
 * To fix ideas, we discuss this application in terms of a recently popularized
 * pastime known as the Kevin Bacon game, which uses the movie-performer graph
 * that we just considered. Kevin Bacon is a prolific actor who has appeared in
 * many movies. We assign every performer a Kevin Bacon number as follows: Bacon
 * himself is 0, any performer who has been in the same cast as Bacon has a
 * Kevin Bacon number of 1, any other performer (except Bacon) who has been in
 * the same cast as a performer whose number is 1 has a Kevin Bacon number of 2,
 * and so forth.
 * 
 * This SymbolGraph and BreadthFirstPaths client finds shortest paths in graphs.
 * For movies.txt, it plays the Kevin Bacon game.
 */
public class DegreesOfSeparation {

	private SymbolGraph sg;
	private Graph G;

	public DegreesOfSeparation(String stream, String sp) {
		sg = new SymbolGraph(stream, sp);
		G = sg.G();
	}

	public List<String> search(String source, String sink) {
		List<String> l = new ArrayList<String>();
		l.add("FROM " + source + " TO " + sink);
		if (!sg.contains(source)) {
			l.add(source + " not in database.");
			return l;
		}
		int s = sg.index(source);
		BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);
		if (sg.contains(sink)) {
			int t = sg.index(sink);
			if (bfs.hasPathTo(t))
				for (int v : bfs.pathTo(t))
					l.add("   " + sg.name(v));
			else
				l.add("Not connected");
		} else
			l.add("Not in database.");
		return l;
	}

}