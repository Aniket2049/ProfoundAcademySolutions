package _01_implementation;

import java.util.Scanner;

//https://profound.academy/algorithms-data-structures/slice-and-dice-R9g7aB9mKx2EvJXGEMYk

/*
Slice and dice
Given two arrays, you are asked if it's possible to obtain the second one by 
slicing the first one at one location and swapping those parts. Empty slices 
are allowed.

Input
The first line of the input contains a single integer n the size of the two 
arrays (1 ≤ n ≤ 1000). The second line contains n space-separated integers
(-10^9≤ a ≤ 10^9). The third line contains space-separated integers 
(-10^9≤ b ≤ 10^9).

Output
The program should print Yes in case it's possible to find a single location 
and slice the first array to obtain the second one after swapping the two 
slices, and No otherwise.

Examples
+---------------+---------------+
|Input        	|Output			|
+---------------+---------------+
|4				|Yes			|
|1 2 3 4		|				|
|3 4 1 2		|				|
+---------------+---------------+
|3				|No				|
|1 2 3 			|				|
|4 5 6			|				|
+---------------+---------------+
*/

public class _04_SliceAndDice {

	public static void main(String[] args) {
		int n;
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		String normalNums = new String();
		String slicedNums = new String();
		for (int i = 0; i < n; i++)
			normalNums += (input.nextInt()) + " ";
		for (int i = 0; i < n; i++)
			slicedNums += (input.nextInt()) + " ";
		input.close();

		//--------Input Read--------

		slicedNums = slicedNums + slicedNums;
		if (slicedNums.contains(normalNums))
			System.out.println("Yes");
		else
			System.out.println("No");

	}

}
