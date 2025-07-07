package _02_binaryNumbers;

import java.util.Scanner;

// https://profound.academy/algorithms-data-structures/convert-binary-to-decimal-numbers-d4t3WHKzGjuHzdAryYbr

/*
Convert Binary to Decimal Numbers
In computer science, numbers are often represented in binary form. Your task 
is to develop a program that reads such a binary string from the input and 
outputs its decimal (base-10) equivalent.
In case you need a refresher, remember that each 1 in a binary string 
represents a specific power of 2. Summing these powers gives you the equivalent
decimal number, starting with the rightmost bit corresponding to 2^0 and so on.
For instance, 110 = 2^2 + 2^1 = 6

Input
The only line of the input contains the strings consisting of Os and 1s (1 <= |s| <= 31)

Output
A single integer, representing the decimal equivalent of the binary string.

Examples
+---------------+---------------+
|Input        	|Output			|
+---------------+---------------+
|101			|5				|
+---------------+---------------+
|110			|6				|
+---------------+---------------+
|111			|7				|
+---------------+---------------+
|0100110111		|311			|
+---------------+---------------+
*/

public class _02_BinaryToDecimal {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String binaryStr = scanner.nextLine();
		scanner.close();

		// ----- INPUT READ -----

		int power = 0;
		int res = 0;

		// Start from the rightmost bit
		for (int i = binaryStr.length() - 1; i >= 0; i--) {
			char bit = binaryStr.charAt(i);
			if (bit == '1') {
				res += Math.pow(2, power);
			} else if (bit != '0') {
				System.out.println("Invalid binary number.");
				return;
			}
			power++;
		}

		System.out.println(res);
	}

}
