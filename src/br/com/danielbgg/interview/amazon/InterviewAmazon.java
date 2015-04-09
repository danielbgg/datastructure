package br.com.danielbgg.interview.amazon;

public class InterviewAmazon {

	public static String moveRobot(String s) {
		Robot r = new Robot(s);
		return r.move();
	}

	public static void main(String[] args) {
		executeTestCase1();
		executeTestCase2();
		executeTestCase3();
		executeTestCase4();
		executeTestCase5();
		executeTestCase6();
	}

	static void executeTestCase1() {
		if ("(-4,-105)".equals(InterviewAmazon.moveRobot("7N4W112S5EX4SX")))
			System.out.println("1- passed");
		else
			System.out.println("1- failed");
	}

	static void executeTestCase2() {
		if ("(0,0)".equals(InterviewAmazon.moveRobot("7N4WX5E4SXXX")))
			System.out.println("2- passed");
		else
			System.out.println("2- failed");
	}

	static void executeTestCase3() {
		if ("(999,999)".equals(InterviewAmazon.moveRobot("7N4W2X5E4SXXX")))
			System.out.println("3- passed");
		else
			System.out.println("3- failed");
	}

	static void executeTestCase4() {
		if ("(7,5)".equals(InterviewAmazon.moveRobot("5N88EX95SX7E")))
			System.out.println("4- passed");
		else
			System.out.println("4- failed");
	}

	static void executeTestCase5() {
		if ("(3,1)".equals(InterviewAmazon.moveRobot("N6SXW4E")))
			System.out.println("5- passed");
		else
			System.out.println("5- failed");
	}

	static void executeTestCase6() {
		if ("(0,-4)".equals(InterviewAmazon.moveRobot("XX4S")))
			System.out.println("6- passed");
		else
			System.out.println("6- failed");
	}

}
