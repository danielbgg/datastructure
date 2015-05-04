package br.com.danielbgg.trie;

public class Trie {

	private int words;
	private int prefixes;
	private Trie edges[];

	public Trie() {
	}

	public void initialize(Trie vertex) {
		vertex.setWords(0);
		vertex.setPrefixes(0);
		Trie ed[] = vertex.getEdges();
		for (int i = 0; i <= 26; i++) {
			ed[i] = null;
		}
	}

	public void addWord(Trie vertex, String word) {
	}

	public int countPrefixes(Trie vertex, String prefix) {
		return 0;
	}

	public int countWords(Trie vertex, String word) {
		return 0;
	}

	public int getWords() {
		return words;
	}

	public void setWords(int words) {
		this.words = words;
	}

	public int getPrefixes() {
		return prefixes;
	}

	public void setPrefixes(int prefixes) {
		this.prefixes = prefixes;
	}

	public Trie[] getEdges() {
		return edges;
	}

	public void setEdges(Trie[] edges) {
		this.edges = edges;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
