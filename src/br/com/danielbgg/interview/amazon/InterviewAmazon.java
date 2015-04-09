package br.com.danielbgg.interview.amazon;

public class InterviewAmazon {

	public static String moveRobot(String s) {
		String position = null;
		try {
			Robot r = new Robot();
			position = r.move(s);
		} catch (IllegalArgumentException e) {
			position = "(999,999)";
		}
		System.out.println("Position: " + position + " after command: " + s);
		return position;
	}

	public static void main(String[] args) {
		assert ("(-4,-105)".equals(InterviewAmazon.moveRobot("7N4W112S5EX4SX")));
		assert ("(0,0)".equals(InterviewAmazon.moveRobot("7N4WX5E4SXXX")));
		assert ("(7,5)".equals(InterviewAmazon.moveRobot("5N88EX95SX7E")));
		assert ("(3,1)".equals(InterviewAmazon.moveRobot("N6SXW4E")));
		assert ("(0,-4)".equals(InterviewAmazon.moveRobot("XX4S")));
		assert ("(999,999)".equals(InterviewAmazon.moveRobot("7N4W2X5E4SXXX")));
		assert ("(999,999)".equals(InterviewAmazon.moveRobot("7TX23uikal")));
		assert ("(999,999)".equals(InterviewAmazon.moveRobot("123")));
		assert ("(999,999)".equals(InterviewAmazon.moveRobot("XX4S1")));
	}

}
