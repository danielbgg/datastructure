package br.com.danielbgg.interview.amazon.robot;

public class Command {

	private int value;
	private char way;

	public Command(char way) {
		this.way = way;
		this.value = 1;
		checkConstraints();
	}

	public Command(int value, char way) {
		this.way = way;
		this.value = value;
		checkConstraints();
	}

	private void checkConstraints() {
		if (way != 'N' && way != 'S' && way != 'E' && way != 'W' && way != 'X') {
			throw new IllegalArgumentException("Valid values for position: N, S, E, W (and X)");
		}
		if (way == 'X' && value != 1) {
			throw new IllegalArgumentException("X must not have a value");
		}
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public char getWay() {
		return way;
	}

	public void setWay(char way) {
		this.way = way;
	}

	public boolean isDelete() {
		return way == 'X';
	}

	public String toString() {
		return "Value: " + value + " - Way: " + way;
	}

}
