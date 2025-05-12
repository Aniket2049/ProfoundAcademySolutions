package _01_implementation;

import java.util.Scanner;

// https://profound.academy/algorithms-data-structures/finding-the-peak-eFb3XHZRbWxhmrsEI4xz

/*
Finding the peak
You are given an array of integers. You are asked to find the rightmost peak 
element in that array. We consider an element to be a peak if it's greater or 
equal to two of its neighbors ( ai-1 ai ai+1).

Input
The first line of the input contains the number (3≤ n ≤ 105). The second line 
contains n integers representing the array, where each element (-10° ≤ a ≤109).

Output
The program should print the value of the rightmost peak element. In case it's 
impossible to find a peak, the program should print Impossible.

Examples
+---------------+---------------+
|Input        	|Output			|
+---------------+---------------+
|5				|8				|
|7 20 0 8 7		|				|
+---------------+---------------+
|6				|2				|
|0 2 -1 4 5 7	|				|
+---------------+---------------+
|3				|Impossible		|
|1 2 3			|				|
+---------------+---------------+
*/

public class _02_FindingThePeak {
	public static void main(String[] args) {
		int n;
		int[] nums;
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		if (n < 3) {
			System.out.println("Impossible");
			input.close();
			return;
		}
		nums = new int[n];
		for (int i = 0; i < n; i++)
			nums[i] = input.nextInt();

		input.close();
		//--------Input Read--------

		for (int i = n - 2; i >= 1; i--) {
			if (nums[i] >= nums[i + 1] && nums[i] >= nums[i - 1]) {
				System.out.println(nums[i]);
				return;
			}
		}

		System.out.println("Impossible");
	}
}
