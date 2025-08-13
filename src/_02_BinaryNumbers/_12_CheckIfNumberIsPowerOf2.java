package _02_BinaryNumbers;

import java.util.Scanner;

// https://profound.academy/algorithms-data-structures/check-if-a-number-is-a-power-of-2-UFlt2YGpxRha3oJKRmR4

/*
Check if a number is a power of 2
Given a positive integern, you are asked to find out if it's a power of 2.

Input
The first line of the input contains a single integer n (2 <= n <= 10^9).

Output
The program should print Yes if n is a power of 2 and No otherwise.

Examples
+---------------+---------------+
|Input        	|Output			|
+---------------+---------------+
|8				|Yes			|
+---------------+---------------+
|17				|No				|
+---------------+---------------+
|2048			|Yes			|
+---------------+---------------+
*/

public class _12_CheckIfNumberIsPowerOf2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Integer n = scanner.nextInt();
		scanner.close();

		// ----- INPUT READ -----

		StringBuilder sb = new StringBuilder();

		while (n > 0) {
			sb.append(n % 2);
			n = n / 2;
		}
		
		sb.reverse();

		if (sb.charAt(0) != '1') {
			System.out.println("No");
			return;
		}

		for (int i = 1; i < sb.length(); i++) {
			if (sb.charAt(i) != '0') {
				System.out.println("No");
				return;
			}
		}

		System.out.println("Yes");

	}

}
