package book1.chapter5.hashed;

public class stringToInt {
	public static int stringToInt(String aKey) // from Figure 5.18
	{
		int pseudoKey = 0;
		int n = 1;
		int cn = 0;
		char c[] = aKey.toCharArray();
		int grouping = 0;
		while (cn < aKey.length()) // there is still more character in the key
		{
			grouping = grouping << 8; // pack next four characters in i
			grouping = grouping + c[cn];
			cn = cn + 1;
			if (n == 4 || cn == aKey.length()) // 4 characters are processed or
											   // no more characters
			{
				pseudoKey = pseudoKey + grouping;
				n = 1;
				grouping = 0;
			}
			n = n + 1;
		}
		return Math.abs(pseudoKey);
	}
}