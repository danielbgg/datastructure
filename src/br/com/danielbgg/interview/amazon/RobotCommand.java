package br.com.danielbgg.interview.amazon;

public class RobotCommand {

	private int howMany;
	private char to;

	public RobotCommand(char to) {
		this.to = to;
		this.howMany = 1;
	}

	public RobotCommand(int howMany, char to) {
		this.to = to;
		this.howMany = howMany;
	}

	public int getHowMany() {
		return howMany;
	}

	public void setHowMany(int howMany) {
		this.howMany = howMany;
	}

	public char getTo() {
		return to;
	}

	public void setTo(char to) {
		this.to = to;
	}

	public boolean isDelete() {
		return to == 'X';
	}

	public String toString() {
		return "Positions: " + howMany + " - to: " + to;
	}

}
