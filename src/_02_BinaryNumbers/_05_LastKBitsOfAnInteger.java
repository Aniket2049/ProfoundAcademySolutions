package _02_BinaryNumbers;

import java.util.Scanner;

// https://profound.academy/algorithms-data-structures/last-k-bits-of-an-integer-8BPKBwF3SmggDwtWLnCd

/*
Last K Bits of an Integer
You are given an integer number n and another integer k. Your task is to find 
and output the last k bits of the given number n when represented in binary 
form.
Input
The first line contains a single integer n (1 <= n <= 10^9).
The second line contains a single integer k (0 <= k <= 30).

Output
Output a single integer representing the last k bits of n in its binary 
representation.

Examples
+---------------+---------------+
|Input        	|Output			|
+---------------+---------------+
|100			|0100			|
|4				|				|
+---------------+---------------+
|3				|0000000011		|
|10				|				|
+---------------+---------------+
*/

public class _05_LastKBitsOfAnInteger {

	private static String decimalToBinary(int num) {
		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			sb.append(num % 2);
			num = num / 2;
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		scanner.close();

		// ----- INPUT READ -----

		String binaryOfN = decimalToBinary(n);

		if (binaryOfN.length() >= k) {
			System.out.println(binaryOfN.substring(binaryOfN.length() - k, binaryOfN.length()));
		} else {
			int padding = k - binaryOfN.length();
			StringBuilder sb = new StringBuilder();
			while (padding-- > 0)
				sb.append("0");
			System.out.println(sb.toString() + binaryOfN);
		}

	}

}
