package _02_binaryNumbers;

import java.util.Scanner;

// https://profound.academy/algorithms-data-structures/express-as-powers-of-two-ndHYG5eouRj2K7uqrks8

/*
Express as Powers of Two
You are given a single integer n. Your task is to find and output a list of 
different powers of 2 that sum up to the given number n. The list should be 
in increasing order.

Input
The first line contains a single integer n (1 <= n <= 10^9)

Output
Print the powers of 2 that sum up to n, separated by a space. The numbers 
should be in increasing order.

Examples
+---------------+---------------+
|Input        	|Output			|
+---------------+---------------+
|11				|1 2 8			|
+---------------+---------------+
|30				|2 4 8 16		|
+---------------+---------------+
*/
public class _08_ExpressAsPowersOfTwo {

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
		scanner.close();

		// ----- INPUT READ -----

		String nInBinary = decimalToBinary(n);
		StringBuilder sb = new StringBuilder();

		int length = nInBinary.length();
		for (int i = 0; i < length; i++) {
			// Check from right to left
			char bit = nInBinary.charAt(length - 1 - i);
			if (bit == '1') {
				sb.append((1 << i) + " ");
			}
		}

		System.out.println(sb.toString());

	}

}
