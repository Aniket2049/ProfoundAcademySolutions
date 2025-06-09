package _01_implementation;

import java.util.Scanner;

// https://profound.academy/algorithms-data-structures/the-digital-root-of-a-number-IT2Ia1VaYVSP9nplpxjR

/*
The digital root of a number
Given an integer n, we can compute the digital root of n by summing up all the 
digits of n and repeating that process on the result until reaching a single 
digit. The digital sum of a number is the result of an iterative process of 
summing the digits of the number. You are asked to write a program that would 
calculate the digital root of a number.

Input
The input contains a single integer n (0 ≤ n ≤ 10^18).

Output
The program should print the digital root of the number n.

Examples
+---------------+---------------+
|Input        	|Output			|
+---------------+---------------+
|15				|6				|
+---------------+---------------+
|12345			|6				|
+---------------+---------------+

Explanation
1. 15 -> 1 + 5 = 6
2. 12345 -> 1 + 2 + 3 + 4 + 5 = 15 -> 1 + 5 = 6
*/

public class _08_DigitalRootOfANumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder sb = new StringBuilder(scanner.nextLine());
		scanner.close();

		// ----- INPUT READ -----

		String input = sb.toString();
		while (input.length() != 1) {
			Integer curentRes = 0;
			for (char c : input.toCharArray()) {
				curentRes += Integer.parseInt(String.valueOf(c));
			}
			input = String.valueOf(curentRes);
		}

		System.out.println(input);
	}

}
