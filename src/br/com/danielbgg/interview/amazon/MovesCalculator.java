package br.com.danielbgg.interview.amazon;

public class MovesCalculator {

	private int eixoX = 0;
	private int eixoY = 0;

	public void add(RobotCommand command) {
		switch (command.getTo()) {
		case 'N':
			eixoY += command.getHowMany();
			break;
		case 'S':
			eixoY += (command.getHowMany() * -1);
			break;
		case 'E':
			eixoX += command.getHowMany();
			break;
		case 'W':
			eixoX += (command.getHowMany() * -1);
			break;
		}
	}

	public int getEixoX() {
		return eixoX;
	}

	public int getEixoY() {
		return eixoY;
	}

	public String toString() {
		return "(" + eixoX + "," + eixoY + ")";
	}

}
