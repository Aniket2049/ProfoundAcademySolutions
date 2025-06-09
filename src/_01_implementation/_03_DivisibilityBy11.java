package _01_implementation;

import java.util.Scanner;

//https://profound.academy/algorithms-data-structures/divisibility-by-11-JJsIT210xYYDgPXMZlKZ

/*
Divisibility by 11
Did you know that there is an easy way to check if a number is divisible by 11?
For large numbers, we can take all the digits in odd positions and sum them 
together, after that take all the digits in even positions and sum those 
together, and subtract those two sums from each other. If the resulting number 
is divisible by 11, then the whole number is divisible by 11.

Input
The input contains a very large positive integer that can have up to 106 
(million) digits.
Output
The program should print Yes if the given number is divisible by 11 and 
No otherwise.

Examples
+---------------+---------------+
|Input        	|Output			|
+---------------+---------------+
|563706			|Yes			|
+---------------+---------------+
|12345678		|No				|
+---------------+---------------+

Explanation
1. 563706   -> (5+3+0)-(6+7+6) = 8-19 = -11 which is divisible by 11.
2. 12345678 -> (1+3+5+7)-(2+4+6+8) = 16-20 = -4 which is not divisible by 11

*/

public class _03_DivisibilityBy11 {

	public static void main(String[] args) {
		String num;
		Scanner input = new Scanner(System.in);
		num = input.nextLine();
		input.close();

		//--------Input Read--------

		int n = num.length();
		int oddSum = 0;
		int evenSum = 0;
		boolean isOdd = true;
		for (int i = n - 1; i >= 0; i--) {
			Integer number = Integer.parseInt(String.valueOf(num.charAt(i)));
			if (isOdd) {
				oddSum += number;
			} else {
				evenSum += number;
			}
			isOdd = !isOdd;
		}

		if (Math.abs(oddSum - evenSum) % 11 == 0)
			System.out.println("Yes");
		else
			System.out.println("No");

	}

}
