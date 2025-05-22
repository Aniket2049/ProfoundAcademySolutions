package _01_implementation;

import java.util.Scanner;

// https://profound.academy/algorithms-data-structures/perfect-number-oxHC5waPS5Cr1N5H5XTP

/*
Perfect number
A number is considered perfect if it's the sum of all its divisors except 
itself. For instance, the divisors of 6 are 1, 2, and 3, we exclude 6. 1+2+3=6
6 is a perfect number.

Input
The input contains a single integer n (1 ≤ n ≤ 10^6).

Output
The program should print Yes if the given number is perfect and No otherwise.

Examples
+---------------+---------------+
|Input        	|Output			|
+---------------+---------------+
|6				|Yes			|
+---------------+---------------+
|8				|No				|
+---------------+---------------+

Explanation
1. 6+1+2+3=6 -> 6 is perfect
2. 8+1+2+4=7 -> 8 is not perfect
*/

public class _05_PerfectNumber {

	public static void main(String[] args) {
		int n;
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		input.close();

		//--------Input Read--------

		int sum = 0;
		for (int i = 1; i < n; i++) {
			if (n % i == 0)
				sum += i;
		}

		System.out.println(sum == n ? "Yes" : "No");
	}

}
