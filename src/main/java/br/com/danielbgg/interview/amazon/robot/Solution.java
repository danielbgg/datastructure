package br.com.danielbgg.interview.amazon.robot;


/**
 * Class responsible for interpreting a list of commands and gives as a result the coordinate plan. 
 * In case of valid input must print the coordinate plan (x,y). For example: (12,5), or (-23,0), and son on.
 * In case of invalid input must print (999,999)
 * Before executing movement, the coordinate plan starts in (x,y), where x=0 and y=0
 * Assumptions: 
 * 	(1) The direction-command are all in uppercase: N, S, W , E', X;
 *  (2) The command 'X' doesn't accept magnification, for example: 5X. The invalid coordinate plan (999,999) will be printed
 *  
 *  Asymptotic Analysis - BigO
 *  The runtime performance is given for O(n).
 *  The constants were omitted due to: (1) implementation details and (2) magnitude of the input given for number of commands
 *  In spite of there are 2 loops in the solution, they run sequentially. Because of this, the Asymptotic Analysis is given for O(n) 
 *  N is given for the length of the string command and not for the number of commands.
 *  
 * @author mbrienze
 * @date 05/18/2015
 *
 */

public class Solution{
	
	static String moveRobot(String s) {
		Robot robot =  new Solution().new Robot();
		return robot.moveRobot(s).toString();

    }

  class Robot {
	
	 Coordinate moveRobot(String command){
		 
		java.util.ArrayList<Command> commands = new java.util.ArrayList<Command>();//it will store the valid commands.
		
		int size = command.length();
		boolean isLastDigit = false;// storing the last letter of command
		int i = 0;
		int magnification = 1;//initialization with a value that represents the direction without magnification, for example 'N'
		while(i < size){
			char letter = command.charAt(i);
			
			if(Character.isDigit(letter)){//it is number
				int start = i;
				while(Character.isDigit(command.charAt(i))){
					i++;//iterate over the command until reach the direction, which is represented by a letter.
					//Important: I will assume that the magnfication is an integer number, which means that the maximum value is 2147483647
					//Asymptotic Analysis Note: This loop iterates over outer loop, which means that the outer iteration is continuing here.
					
				}
				magnification = Integer.parseInt(command.substring(start, i));
				isLastDigit = true;
			}else if(Character.isAlphabetic(letter)){
				if(letter == 'X'){
					if(isLastDigit){
						return new Solution().new Coordinate().createInvalidCoordinate();//5X is incorrect, for example
					}
					removeLastCommand(commands);//as required, the prior command must be deleted
				}else{
					if(!isLastDigit){
						magnification = 1;//in case of the command be 4NS, see that 'S' doesn't have the magnification explicitly defined 
					}
					commands.add(new Command(magnification,letter));
					isLastDigit = false;
				}
				i++;
			}
		}
		
		return applyCoordinate(commands);
	}
	
	private  void removeLastCommand(java.util.ArrayList<Command> commands){
		if(commands.size() > 0){
			commands.remove(commands.size()-1);//do remove last element, or prior command
		}
		
	}
	/**
	 * Method that turn the commands into coordinate plan
	 * @param commands
	 * @return
	 */
	private  Coordinate applyCoordinate(java.util.ArrayList<Command> commands){
		Coordinate coordinate = new Coordinate();
		for (java.util.Iterator<Command> iterator = commands.iterator(); iterator.hasNext();) {
			Command aCommand = (Command) iterator.next();
			coordinate.addCommand(aCommand);//see comments in the method
		}
		
		return coordinate;
	}
	
	
	
	
}

	class Command{
		private char direction;
		private int magnificier;
		
		Command(int magnificier, char direction){
			this.setMagnificier(magnificier);
			this.setDirection(direction);
		}
	
		char getDirection() {
			return direction;
		}
	
		void setDirection(char direction) {
			this.direction = direction;
		}
	
		int getMagnificier() {
			return magnificier;
		}
	
		void setMagnificier(int magnificier) {
			this.magnificier = magnificier;
		}
		
		
	}
	
	class Coordinate{
		 
		private boolean isValid;
		private int x;
		private int y;
		
		 Coordinate createInvalidCoordinate(){
			return new Coordinate(999,999,false);
		}
		Coordinate(int x, int y, boolean isValid){
			this.x = x;
			this.y = y;
			this.isValid = isValid;
		}
		Coordinate(){
			x = 0;
			y = 0;
		}
		
		Coordinate(int x, int y){
			this.x = x;
			this.y = y;
			this.isValid = true;
		}
		/**
		 * Utility method to give the 'command the treatment as a coordinate plan
		 * Maybe upon refactoring this method might be refactored to another class, not here. But, for sake of simplicity I'll leave it here.
		 * @param command
		 */
		void addCommand(Command command){
			switch(command.getDirection()){
				case 'N' :
					y = (y + command.getMagnificier());
					break;
				case 'S' :
					y = (y + (command.getMagnificier())*-1);
					break;
				case 'W' :
					x = (x + (command.getMagnificier())*-1);
					break;
				case 'E' :
					x = (x + (command.getMagnificier()));
					break;
			}
		}
		
		
		boolean isValid(){
			return isValid;
		}
		
		public String toString(){
			return "("+ x + "," + y + ")";
		}
		
		public boolean equals(Object obj){
			if(obj instanceof Coordinate){
				Coordinate aCoordinate = (Coordinate)obj;
				return (x == aCoordinate.x && y == aCoordinate.y);
			}
			return false;
			
		}
	}
	
	class TestCaseRobot{
		
		private  void evaluateResult(byte testCaseNumber, Coordinate expected, Coordinate result){
			if(expected.equals(result))
				System.out.println(testCaseNumber + "- Passed");
			else
				System.out.println(testCaseNumber + "- Failed [" + " got: " + result + " expected:"+ expected + "]");
		}
		
	  void executeTestCase(){
			executeTestCase1();
			executeTestCase2();
			executeTestCase3();
			executeTestCase4();
			executeTestCase5();
			executeTestCase6();
			executeTestCase7();
			executeTestCase8();
			executeTestCase9();
			executeTestCase10();
			executeTestCase11();
		}
		
		
		 void executeTestCase1(){
			int x = -44;
			int y = -105;
			Coordinate expected = new Coordinate(x,y);
			Coordinate result = new Robot().moveRobot("7N44W112S5EX4SX");
			
			byte testCaseId=1;
			evaluateResult(testCaseId,expected, result);
		}
		
		 void executeTestCase2(){
			int x = 0;
			int y = 0;
			Coordinate expected = new Coordinate(x,y);
			Coordinate result = new Robot().moveRobot("7N4WX5E4SXXX");
			
			byte testCaseId=2;
			evaluateResult(testCaseId,expected, result);
			
		}
		
		 void executeTestCase3(){
			int x = 999;
			int y = 999;
			Coordinate expected = new Coordinate(x,y);
			Coordinate result = new Robot().moveRobot("7N4W2X5E4SXXX");
			
			byte testCaseId=3;
			evaluateResult(testCaseId,expected, result);
			
			
		}
		
		 void executeTestCase4(){
			int x = 7;
			int y = 5;
			
			Coordinate expected = new Coordinate(x,y);
			Coordinate result = new Robot().moveRobot("5N88EX95SX7E");
			
			byte testCaseId=4;
			evaluateResult(testCaseId,expected, result);
		}
		
		 void executeTestCase5(){
			int x = 3;
			int y = 1;
			
			Coordinate expected = new Coordinate(x,y);
			Coordinate result = new Robot().moveRobot("N6SXW4E");
			
			byte testCaseId=5;
			evaluateResult(testCaseId,expected, result);
		}
		
		 void executeTestCase6(){
			int x = 0;
			int y = -4;
			
			Coordinate expected = new Coordinate(x,y);
			Coordinate result = new Robot().moveRobot("XX4S");
			
			byte testCaseId=6;
			evaluateResult(testCaseId,expected, result);
			
			
		}
		
		 void executeTestCase7(){
			int x = 0;
			int y = -4;
			
			Coordinate expected = new Coordinate(x,y);
			Coordinate result = new Robot().moveRobot("XX4S");
			
			byte testCaseId=7;
			evaluateResult(testCaseId,expected, result);
			
			
		}
		
		 void executeTestCase8(){
			int x = 3;
			int y = 1;
			
			Coordinate expected = new Coordinate(x,y);
			Coordinate result = new Robot().moveRobot("NEEE");
			
			byte testCaseId=8;
			evaluateResult(testCaseId,expected, result);
			
			
		}
		
		 void executeTestCase9(){
			int x = -1;
			int y = 3;
			
			Coordinate expected = new Coordinate(x,y);
			Coordinate result = new Robot().moveRobot("SEEWWWNNNN");
			
			byte testCaseId=9;
			evaluateResult(testCaseId,expected, result);
			
			
		}
	
		
		 void executeTestCase10(){
			int x = -3;
			int y = 7;
			
			Coordinate expected = new Coordinate(x,y);
			Coordinate result = new Robot().moveRobot("7N3W");
			
			byte testCaseId=10;
			evaluateResult(testCaseId,expected, result);
			
			
		}
		
		 void executeTestCase11(){
			int x = -44;
			int y = -2147483640;//maximum value for an integer number (32 bytes)
			Coordinate expected = new Coordinate(x,y);
			Coordinate result = new Robot().moveRobot("7N44W2147483647S5EX4SX");
			
			byte testCaseId=11;
			evaluateResult(testCaseId,expected, result);
		}
	
	
	}
	
	public static void main(){
		new Solution().new TestCaseRobot().executeTestCase();
	}

}
