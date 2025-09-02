package _03_BitwiseOperations;

import java.util.ArrayList;
import java.util.Scanner;

// https://profound.academy/algorithms-data-structures/bitwise-operations-fXwZqUCpmxBVIcPcskFk

/*
Given n integers, you are asked to find 2 of those that after applying OR to 
them would result in the largest number.

Input
The first line of the input contains a single integer n (1 <= n <= 1000)
The next line contains n space-separated integers a{i} (1 <= a{i} <= 10^9)

Output
The output should contain the largest value you can obtain by applying an OR 
operation on 2 values from the given numbers.

Examples
+---------------+---------------+
|Input        	|Output			|
+---------------+---------------+
|5  			|7				|
|1 2 3 4 5		|				|
+---------------+---------------+
*/

public class _01_BitwiseOperations {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Integer n = scanner.nextInt();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			nums.add(i, scanner.nextInt());

		scanner.close();

		// ----- INPUT READ -----

		int res = 0;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int oredNum = nums.get(i) | nums.get(j);
				if (oredNum > res)
					res = oredNum;
			}
		}

		System.out.println(res);
	}

}
