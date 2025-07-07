package _02_binaryNumbers;

import java.util.Scanner;

// https://profound.academy/algorithms-data-structures/isolate-the-rightmost-bit-D91MAaR8QLKn7gbc34JI

/*
You are given an integer N (in base-10). Your task is to isolate the rightmost
bit from the number. Write a program that prints two integers: the value of 
the rightmost bit and the value of the original number with its rightmost bit 
removed.
For example, consider the number 29, which in binary is 11101. The rightmost 
bit is 1, and after erasing it, the number becomes 1110, which is equal to 14 
in base-10.

Input
The first line contains a single integer N(1 <= N <= 10^9)

Output
Two integers separated by a space: the rightmost bit in binary representation 
of N and the value of N with its rightmost bit completely erased (in base-10).

Examples
+---------------+---------------+
|Input        	|Output			|
+---------------+---------------+
|29				|1 14			|
+---------------+---------------+
|18				|0 9			|
+---------------+---------------+
*/

public class _03_IsolateTheRightmostBit {

	private static String decimalToBinary(int num) {
		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			sb.append(num % 2);
			num = num / 2;
		}
		return sb.reverse().toString();
	}

	private static int binaryToDecimal(String num) {
		int power = 0;
		int res = 0;

		for (int i = num.length() - 1; i >= 0; i--) {
			char bit = num.charAt(i);
			if (bit == '1') {
				res += Math.pow(2, power);
			}
			power++;
		}

		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		scanner.close();

		// ----- INPUT READ -----

		String numAsBinary = decimalToBinary(number);
		char rightMostBit = numAsBinary.charAt(numAsBinary.length() - 1);

		numAsBinary = numAsBinary.substring(0, numAsBinary.length() - 1);
		int newNumber = binaryToDecimal(numAsBinary);

		System.out.println(rightMostBit + " " + newNumber);

	}

}
