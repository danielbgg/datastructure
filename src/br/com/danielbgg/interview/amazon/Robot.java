package br.com.danielbgg.interview.amazon;

public class Robot {

	private Engine engine;

	public Robot() {
		this.engine = new Engine();
	}

	public String move(String description) {
		Analyzer analyzer = new Analyzer(description);
		return engine.move(analyzer.getCommands());
	}
}
