package br.com.danielbgg.ctci;

/**
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j
 * Write a method to set all bits between i and j in N equal to M (e g , M
 * becomes a substring of N located at i and starting at j)
 * 
 * EXAMPLE:
 * 
 * Input: N = 10000000000, M = 10101, i = 2, j = 6
 * 
 * Output: N = 10001010100
 */
public class C05Q01 {

	/**
	 * This code operates by clearing all bits in N between position i and j,
	 * and then ORing to put M in there
	 */
	public static int updateBits(int n, int m, int i, int j) {
		int max = ~0; /* All 1’s */
		System.out.println(Integer.toBinaryString(max));
		System.out.println(max);

		// 1’s through position j, then 0’s
		int left = max - ((1 << j) - 1);
		System.out.println(Integer.toBinaryString(left));
		System.out.println(left);

		// 1’s after position i
		int right = ((1 << i) - 1);
		System.out.println(Integer.toBinaryString(right));
		System.out.println(right);

		// 1’s, with 0s between i and j
		int mask = left | right;
		System.out.println(Integer.toBinaryString(mask));
		System.out.println(mask);

		// Clear i through j, then put m in there
		return (n & mask) | (m << i);
	}

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(C05Q01.updateBits(~0,
				10101, 2, 6)));
	}

}
