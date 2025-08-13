package _02_BinaryNumbers;

import java.util.Scanner;

// https://profound.academy/algorithms-data-structures/number-of-bit-strings-f66iDo45y9MGGWaLFF8k
/*
Number of bit-strings
Given an integer n, you are asked to calculate the number of different 
bit-strings of length n. Bit strings are strings that only have Os and 1s.

Input
The only line of the input contains a single integer n (1 <= n <= 30)

Output
The program should print the number of bit strings of length n

Examples
+---------------+---------------+
|Input        	|Output			|
+---------------+---------------+
|3				|8				|
+---------------+---------------+
|4				|16				|
+---------------+---------------+

Explanation
3 -> 000, 001, 010, 011, 100, 101, 110, 111 -> 8 different bit-strings.
4 -> 0000, 0001, 0010, 0011, 0100, 0101, 0110, 0111, 1000, 1001, 1010, 
1011, 1100, 1101, 1110, 1111 -> 16 different bit-strings.
*/

public class _13_NumberOfBitStrings {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Integer n = scanner.nextInt();
		scanner.close();

		// ----- INPUT READ -----

		System.out.println(1 << n);
	}

}
