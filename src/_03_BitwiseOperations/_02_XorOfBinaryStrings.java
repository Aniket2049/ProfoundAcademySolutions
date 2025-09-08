package _03_BitwiseOperations;

import java.util.Scanner;

// https://profound.academy/algorithms-data-structures/xor-of-binary-strings-NbAg67EQbNSXoZuxvmRj

/*
You are given two binary strings a and b. Both strings may be quite long, 
containing up to 1000 bits. Your task is to compute the bitwise XOR of these 
two binary strings and output the result.

Input
The first line contains the first binary string a (1 <= |a| <= 1000)
The second line contains the second binary string b (1 <= |b| <= 1000)
Both strings have the same length.

Output
Output a single binary string: the bitwise XOR of a and b having the same 
length as the input strings.

Examples
+---------------+---------------+
|Input        	|Output			|
+---------------+---------------+
|1101  			|0111			|
|1010			|				|
+---------------+---------------+
|111  			|111			|
|000			|				|
+---------------+---------------+
*/
public class _02_XorOfBinaryStrings {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String n1 = scanner.nextLine();
		String n2 = scanner.nextLine();
		scanner.close();

		// ----- INPUT READ -----

		StringBuilder sb = new StringBuilder();

		int i = 0, j = 0;
		while (i < n1.length() && j < n2.length()) {
			if (n1.charAt(i) == n2.charAt(j))
				sb.append("0");
			else
				sb.append("1");

			i++;
			j++;
		}

		System.out.println(sb.toString());

	}

}
