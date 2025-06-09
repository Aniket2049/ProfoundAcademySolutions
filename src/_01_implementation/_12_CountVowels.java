package _01_implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

// https://profound.academy/algorithms-data-structures/count-vowels-7hPMkP4As7lin43TKhQb

/*
Count vowels
Given a string s, you would like to calculate the number of substrings that 
have an odd number of vowels (a, e, i, o, u, and y).

Definition of a substring
Any contiguous sequence of characters in the string s is considered a substring
of s. For instance, the string abc has substrings a, b, c, ab, bc, abc.

Input
The input contains a single string s (1 ≤ |s| ≤ 100) of lowercase Latin letters.
Output
The program should print the number of substrings that have an odd number of 
vowels.

Examples
+---------------+---------------+
|Input        	|Output			|
+---------------+---------------+
|abc			|3				|
+---------------+---------------+
|hello			|9				|
+---------------+---------------+
|xyz			|4				|
+---------------+---------------+

Explanation
1. abc -> a, ab, abc
2. hello -> he, hel, hell, e, el, ell, llo, lo, o
3. xyz -> xy, xyz, y, yz
*/

public class _12_CountVowels {

	public static List<String> findSubstrings(String s) {
		List<String> res = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				res.add(s.substring(i, j + 1));
			}
		}
		return res;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String word = scanner.nextLine();
		scanner.close();

		// ----- INPUT READ -----

		HashSet<Character> vowels = new HashSet<Character>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		vowels.add('y');

		Integer result = 0;

		List<String> subStrings = findSubstrings(word);
		for (String str : subStrings) {
			int vowelCount = 0;
			for (Character c : str.toCharArray()) {
				if (vowels.contains(c))
					vowelCount++;
			}

			if (vowelCount % 2 != 0)
				result++;
		}

		System.out.println(result);
	}

}
