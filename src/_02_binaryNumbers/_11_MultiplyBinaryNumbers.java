package _02_binaryNumbers;

import java.math.BigInteger;
import java.util.Scanner;

// https://profound.academy/algorithms-data-structures/multiply-binary-numbers-kJdPHuNfu9GITtTILv76

/*
Multiply Binary Numbers
You are given two binary numbers represented as strings s1 and s2 
Your task is to calculate the product of these two binary numbers and 
output the result in binary form.

Input
The first line contains the first binary string s1 (0 <= |s1| <= 100)
The second line contains the second binary string s2 (0 <= |s2| <= 100)

Output
Output a single string representing the product of s1 and s2 in binary form.

Examples
+---------------+---------------+
|Input        	|Output			|
+---------------+---------------+
|1101			|1000001		|
|101			|				|
+---------------+---------------+
|1011			|110111			|
|101			|				|
+---------------+---------------+
*/
public class _11_MultiplyBinaryNumbers {

	// Convert binary string to BigInteger
	private static BigInteger binaryToDecimal(String num) {
		BigInteger res = BigInteger.ZERO;
		for (int i = 0; i < num.length(); i++) {
			res = res.multiply(BigInteger.valueOf(2));
			if (num.charAt(i) == '1') {
				res = res.add(BigInteger.ONE);
			}
		}
		return res;
	}

	// Convert BigInteger to binary string
	private static String decimalToBinary(BigInteger num) {
		if (num.equals(BigInteger.ZERO)) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		while (num.compareTo(BigInteger.ZERO) > 0) {
			sb.append(num.mod(BigInteger.valueOf(2))); // append remainder (0 or 1)
			num = num.divide(BigInteger.valueOf(2));
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String n1 = scanner.nextLine().trim();
		String n2 = scanner.nextLine().trim();
		scanner.close();

		// ----- INPUT READ -----

		BigInteger num1 = binaryToDecimal(n1);
		BigInteger num2 = binaryToDecimal(n2);

		BigInteger result = num1.multiply(num2);

		System.out.println(decimalToBinary(result));
	}

}
