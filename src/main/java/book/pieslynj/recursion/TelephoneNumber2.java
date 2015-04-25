package book.pieslynj.recursion;

//Create the first word character by character
//Loop infinitely:
//     Print out the word
//     Increment the last letter and carry the change
//     If the first letter has reset, you’re done
public class TelephoneNumber2 {

	private static final int PHONE_NUMBER_LENGTH = 7;
	private final int[] phoneNum;
	private char[] result = new char[PHONE_NUMBER_LENGTH];

	public TelephoneNumber2(int[] n) {
		phoneNum = n;
	}

	public void printWords() {
		// Initialize result with first telephone word
		for (int i = 0; i < PHONE_NUMBER_LENGTH; ++i)
			result[i] = getCharKey(phoneNum[i], 1);

		for (;;) { // Infinite loop
			for (int i = 0; i < PHONE_NUMBER_LENGTH; ++i) {
				System.out.print(result[i]);
			}
			System.out.print('\n');

			/*
			 * Start at the end and try to increment from right to left.
			 */
			for (int i = PHONE_NUMBER_LENGTH - 1; i >= -1; --i) {
				if (i == -1) // if attempted to carry past leftmost digit,
					return; // we're done, so return

				/*
				 * Start with high value, carry case so 0 and 1 special cases
				 * are dealt with right away
				 */
				if (getCharKey(phoneNum[i], 3) == result[i] || phoneNum[i] == 0 || phoneNum[i] == 1) {
					result[i] = getCharKey(phoneNum[i], 1);
					// No break, so loop continues to next digit
				} else if (getCharKey(phoneNum[i], 1) == result[i]) {
					result[i] = getCharKey(phoneNum[i], 2);
					break;
				} else if (getCharKey(phoneNum[i], 2) == result[i]) {
					result[i] = getCharKey(phoneNum[i], 3);
					break;
				}
			}
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
		TelephoneNumber2 t = new TelephoneNumber2(new int[] { 4, 9, 7, 1, 9, 2, 7 });
		t.printWords();
	}

}
