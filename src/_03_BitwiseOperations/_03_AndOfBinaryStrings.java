package _03_BitwiseOperations;

import java.util.Scanner;

// https://profound.academy/algorithms-data-structures/and-of-binary-strings-DlGSWkH8p9d4te1ZYSHh

/*
You are given two binary strings a and b. Both strings may be quite long, 
containing up to 1000 bits. Your task is to compute the bitwise AND of these 
two binary strings and output the result.

Input
The first line contains the first binary string a (1 <= |a| <= 1000)
The second line contains the second binary string b (1 <= |b| <= 1000).

Output
Output a single binary string: the bitwise AND of a and b.

Examples
+---------------+---------------+
|Input        	|Output			|
+---------------+---------------+
|1101  			|1000			|
|1010			|				|
+---------------+---------------+
|111  			|000			|
|000			|				|
+---------------+---------------+
*/
public class _03_AndOfBinaryStrings {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String n1 = scanner.nextLine();
		String n2 = scanner.nextLine();
		scanner.close();

		// ----- INPUT READ -----

		StringBuilder sb = new StringBuilder();

		int i = 0, j = 0;
		while (i < n1.length() && j < n2.length()) {
			if (n1.charAt(i) == '1' && n2.charAt(j) == '1')
				sb.append("1");
			else
				sb.append("0");

			i++;
			j++;
		}

		System.out.println(sb.toString());

	}

}
