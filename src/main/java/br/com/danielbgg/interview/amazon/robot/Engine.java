package br.com.danielbgg.interview.amazon.robot;

import java.util.Stack;

public class Engine {

	private Position position;

	public Engine() {
		this.position = new Position();
	}

	// executar movimentação do robo
	// fazer somatória de x e y antes
	public String move(Stack<Command> commands) {
		int del = 0;
		while (!commands.isEmpty()) {
			Command rc = commands.pop();
			if (rc.isDelete()) {
				del++;
			} else {
				if (del > 0) {
					del--;
				} else {
					position.calculate(rc);
				}

			}
		}
		return position.toString();
	}

}
