package _02_BinaryNumbers;

import java.util.Scanner;

// https://profound.academy/algorithms-data-structures/integer-to-binary-xuzwi6iy5OdBj833XgY9

/*
Integer to binary
Your goal is to develop a program that reads an integer n in its decimal form 
and outputs the number in its binary equivalent.

Input
The only line of the input contains a single integer n (1 <= n <= 10^9)

Output
The program should print the binary representation. The first bit should always
be 1.

Examples
+---------------+---------------+
|Input        	|Output			|
+---------------+---------------+
|5				|101			|
+---------------+---------------+
|6				|110			|
+---------------+---------------+
|7				|111			|
+---------------+---------------+
|311			|100110111		|
+---------------+---------------+
*/

public class _04_IntegerToBinary {

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
		int number = scanner.nextInt();
		scanner.close();

		// ----- INPUT READ -----
		
		System.out.println(decimalToBinary(number));

	}

}
