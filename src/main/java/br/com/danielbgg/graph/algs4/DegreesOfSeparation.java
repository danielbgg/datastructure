package br.com.danielbgg.graph.algs4;

import java.util.ArrayList;
import java.util.List;

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