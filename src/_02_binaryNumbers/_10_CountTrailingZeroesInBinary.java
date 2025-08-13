package _02_binaryNumbers;

import java.util.Scanner;

// https://profound.academy/algorithms-data-structures/count-trailing-zeros-in-binary-xlO2osVgHRG5R8ShVmDM

/*
Count Trailing Zeros in Binary
You are given an integer n (in base-10). Write a program to find the number of 
trailing zeros when n is converted to its binary representation.
For example, the number 456 has a binary representation of 111001000, which 
has three trailing zeros at the end.

Input
The input contains a single integer n (1 <= n <= 10^9)

Output
The program should print the number of trailing zeros in the binary 
representation of n

Examples
+---------------+---------------+
|Input        	|Output			|
+---------------+---------------+
|12				|2				|
+---------------+---------------+
|456			|3				|
+---------------+---------------+
*/

public class _10_CountTrailingZeroesInBinary {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Long n = scanner.nextLong();
		scanner.close();

		// ----- INPUT READ -----

		StringBuilder sb = new StringBuilder();

		while (n > 0) {
			sb.append(n % 2);
			n = n / 2;
		}

		Integer start = 0;
		while (start < sb.length() && sb.charAt(start) == '0') {
			start++;
		}

		System.out.println(start);
	}

}
