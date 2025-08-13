package _02_binaryNumbers;

import java.util.Scanner;

// https://profound.academy/algorithms-data-structures/binary-addition-p8LhR9JG5SHriSi4naPl

/*
Binary Addition
You are given two binary numbers as strings. Your task is to write a program to 
add these two binary numbers and output the sum as a binary string.

Input
The first line contains the first binary string a (1 <= |a| <= 10000)
The second line contains the second binary string b (1 <= |b| <= 10000)

Output
Print the sum of the two binary numbers a + b as a binary string.

Examples
+---------------+---------------+
|Input        	|Output			|
+---------------+---------------+
|1101			|11000			|
|1011			|				|
+---------------+---------------+
|101			|1000			|
|11				|				|
+---------------+---------------+
*/

public class _09_BinaryAddition {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String n1 = scanner.nextLine();
		String n2 = scanner.nextLine();
		scanner.close();

		// ----- INPUT READ -----

		String result = addBinary(n1, n2);
		System.out.println(result);

	}

	public static String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();

		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;

		while (i >= 0 || j >= 0 || carry > 0) {
			int sum = carry;

			if (i >= 0)
				sum += a.charAt(i--) - '0';
			if (j >= 0)
				sum += b.charAt(j--) - '0';

			sb.append(sum % 2);
			carry = sum / 2;
		}

		sb.reverse();

		int start = 0;
		while (start < sb.length() - 1 && sb.charAt(start) == '0') {
			start++;
		}

		return sb.substring(start);
	}

}
