package _02_binaryNumbers;

import java.util.Scanner;

// https://profound.academy/algorithms-data-structures/perform-bitwise-shifts-lRyGEV3qIViHw1Tu2jMY

/*
Perform Bitwise Shifts
You are given an integer n (in base-10) and a string left or right indicating 
the direction of the bitwise shift. You are also given an integer k indicating 
the number of positions by which n should be shifted.
For example, if we left shift the integer 3 (11 in binary) by 1 position, it 
becomes 110 which is 6 in base-10.
Similarly, if we right shift the integer 4 (100 in binary) by 2 positions, it 
becomes 1, which is 1 in base-10.
Write a program that prints the result after performing the bitwise shift 
operation.

Input
The first line contains a single integer n (0 <= n <= 2^16)
The second line contains a string, either left or right, indicating the 
direction of the bitwise shift.
The third line contains a single integer k (0 <= k <= 16)

Output
The number n after performing the bitwise shift operation.

Examples
+---------------+---------------+
|Input        	|Output			|
+---------------+---------------+
|3				|12				|
|left			|				|
|2				|				|
+---------------+---------------+
|5				|2				|
|right			|				|
|1				|				|
+---------------+---------------+
*/

public class _06_PerformBitwseShifts {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		scanner.nextLine();
		String shift = scanner.nextLine();
		int k = scanner.nextInt();
		scanner.close();

		// ----- INPUT READ -----

		long res;
		if (shift.equals("left")) {
			res = n << k;
		} else {
			res = n >> k;
		}

		System.out.println(res);
	}

}
