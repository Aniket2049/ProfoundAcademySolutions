package _01_implementation;

import java.util.HashSet;
import java.util.Scanner;

// https://profound.academy/algorithms-data-structures/minimum-excluded-value-mex-tZwBDZoGDAVnfcgWhy31

/*
Minimum Excluded value (MEX)
Let's consider the positive whole numbers (0, 1, 2, ...). For a given list of 
numbers l, we'll say that the minimum excluded value (MEX) of l is the 
smallest nonnegative integer number that doesn't occur in 1. You are asked to 
write a program that given the list l, would calculate its MEX.

Input
The first line of the input contains a single integer n (1 ≤ n ≤ 10^5) the 
number of elements in the list l. The next line contains n elements 
representing the list (0 <= li ≤ 10^9).

Output
The program should print the MEX of the given list.

Examples
+---------------+---------------+
|Input        	|Output			|
+---------------+---------------+
|3				|0				|
|123			|				|
+---------------+---------------+
|4				|2				|
|0134			|				|
+---------------+---------------+
|5				|5				|
|01234			|				|
+---------------+---------------+
*/

public class _10_MinimumExcludedValue {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int inputLength = n;
		HashSet<Integer> set = new HashSet<Integer>();
		while (inputLength != 0) {
			set.add(scanner.nextInt());
			inputLength--;
		}
		scanner.close();

		// ----- INPUT READ -----

		for (int i = 0; i <= n; i++) {
			if (!set.contains(i)) {
				System.out.println(i);
				break;
			}
		}
	}

}
