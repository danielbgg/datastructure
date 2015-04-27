package br.com.danielbgg.interview.amazon.robot;

public class Position {

	private int x = 0;
	private int y = 0;

	public void calculate(Command command) {
		switch (command.getWay()) {
		case 'N':
			y += command.getValue();
			break;
		case 'S':
			y += (command.getValue() * -1);
			break;
		case 'E':
			x += command.getValue();
			break;
		case 'W':
			x += (command.getValue() * -1);
			break;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}

}
