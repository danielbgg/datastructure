package br.com.danielbgg.interview.amazon;

import java.util.Stack;

public class Analyzer {

	private String description;
	private Stack<Command> commands;

	public Analyzer(String description) {
		this.description = description;
		this.commands = new Stack<Command>();
		checkConstraints();
		interpreter();
	}

	// programação defensiva
	private void checkConstraints() {
		if (description == null) {
			throw new IllegalArgumentException("Command must not be null");
		}
		// verificar se a string contem apenas os commandos validos: N, S, E, W,
		// X e valores numéricos
	}

	// interpretar entrada
	// stack para armazenamento dos valores
	// X remove entradas
	private void interpreter() {
		for (int i = 0; i < description.length(); i++) {
			char c = description.charAt(i);
			if (Character.isDigit(c)) {
				int j = 0;
				boolean next = true;
				while (next) {
					j++;
					next = ((i + j) < description.length()-1) && Character.isDigit(description.charAt(i + j));
				}
				int number = new Integer(description.substring(i, i + j));
				i = i + j;
				char to;
				if (i >= description.length()) {
					to = ' ';
				} else {
					to = description.charAt(i);
				}
				commands.add(new Command(number, to));
			} else {
				commands.add(new Command(c));
			}
		}
	}

	public Stack<Command> getCommands() {
		return commands;
	}

}
