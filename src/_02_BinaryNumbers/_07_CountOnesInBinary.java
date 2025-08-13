package _02_BinaryNumbers;

import java.util.Scanner;

// https://profound.academy/algorithms-data-structures/count-ones-in-binary-CPH9YFigy7GYNJMT23Du

/*
Count Ones in Binary
You are given a single integer numbern. Your task is to count the number of 1s 
in the binary representation of n and output this count.

Input
The first line contains a single integer n (1 <= n <= 10^9)

Output
A single integer: the number of 1s in the binary representation of n

Examples
+---------------+---------------+
|Input        	|Output			|
+---------------+---------------+
|5				|2				|
+---------------+---------------+
|1023			|10				|
+---------------+---------------+
*/
public class _07_CountOnesInBinary {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		scanner.close();

		// ----- INPUT READ -----
		
        int res = 0;
        while (n != 0) {
            res += (n & 1) == 1 ? 1 : 0;
            n >>= 1;
        }
     
        System.out.println(res);
	}

}
