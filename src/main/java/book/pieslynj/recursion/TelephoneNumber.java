package book.pieslynj.recursion;

//If the current digit is past the last digit
//Print the word because you’re at the end
//Else
//For each of the three digits that can represent the current digit
//    Have the letter represent the current digit
//    Move to next digit and recurse
//    If the current digit is a 0 or a 1, return
public class TelephoneNumber {

	private static final int PHONE_NUMBER_LENGTH = 7;
	private final int[] phoneNum;
	private char[] result = new char[PHONE_NUMBER_LENGTH];

	public TelephoneNumber(int[] n) {
		phoneNum = n;
	}

	public void printWords() {
		printWords(0);
	}

	private void printWords(int curDigit) {
		if (curDigit == PHONE_NUMBER_LENGTH) {
			System.out.println(new String(result));
			return;
		}
		for (int i = 1; i <= 3; ++i) {
			result[curDigit] = getCharKey(phoneNum[curDigit], i);
			printWords(curDigit + 1);
			if (phoneNum[curDigit] == 0 || phoneNum[curDigit] == 1)
				return;
		}
	}

	private static char getCharKey(int telephoneKey, int place) {
		if (telephoneKey == 0) {
			return '0';
		}
		if (telephoneKey == 1) {
			return '1';
		}
		return (char) (59 + ((telephoneKey - 1 + place) * 3));
	}

	public static void main(String[] args) {
		TelephoneNumber t = new TelephoneNumber(new int[] { 4, 9, 7, 1, 9, 2, 7 });
		t.printWords();
	}

}
