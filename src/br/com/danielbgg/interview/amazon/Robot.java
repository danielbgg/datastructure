package br.com.danielbgg.interview.amazon;

import java.util.Stack;

public class Robot {

	private String command;
	private Stack<RobotCommand> stack;
	private MovesCalculator calculator;

	public Robot(String command) {
		this.command = command;
		this.stack = new Stack<RobotCommand>();
		this.calculator = new MovesCalculator();
		verifyCommand();
		checkCommand();
		analyseCommand();
	}

	// programação defensiva
	private void verifyCommand() {
		if (command == null) {
			throw new IllegalArgumentException("Command must not be null");
		}
		// verificar se a string contem apenas os commandos validos: N, S, E, W,
		// X e valores numéricos
	}

	// verificar se entrada está certa
	private void checkCommand() {
	}

	// interpretar entrada
	// stack para armazenamento dos valores
	// X remove entradas
	private void analyseCommand() {
		for (int i = 0; i < command.length(); i++) {
			char c = command.charAt(i);
			if (Character.isDigit(c)) {
				int j = 0;
				boolean next = true;
				while (next) {
					j++;
					next = Character.isDigit(command.charAt(i + j));
				}
				String number = command.substring(i, i + j);
				i = i + j;
				char to = command.charAt(i);
				stack.add(new RobotCommand(new Integer(number).intValue(), to));
			} else {
				stack.add(new RobotCommand(c));
			}
		}
	}

	// executar movimentação do robo
	// fazer somatória de x e y antes
	public String move() {
		int del = 0;
		while (!stack.isEmpty()) {
			RobotCommand rc = stack.pop();
			//System.out.println("Comando: " + rc);
			if (rc.isDelete()) {
				//System.out.println("Encontrei o delete.");
				del++;
			} else {
				if (del > 0) {
					//System.out.println("Não sumarizando o comando.");
					del--;
				} else {
					calculator.add(rc);
					//System.out.println("Sumarizando o comando.");
				}

			}
		}
		System.out.println("Resultado final: " + calculator);
		return calculator.toString();
	}

}
