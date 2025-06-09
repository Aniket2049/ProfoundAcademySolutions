package _01_implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

// https://profound.academy/algorithms-data-structures/anagrams-g2Y5BM7P3biKDa90qGaI

/*
Anagrams
Two strings are considered anagrams if we can rearrange the letters of one to 
obtain the other. So, for instance, the words "listen" and "silent" are 
anagrams, as it's possible to rearrange the letters of "listen" to obtain 
"silent". Similarly, "William Shakespeare" is an anagram of 
"I am a weakish speller". So, when determining if two strings are anagrams, the
comparison should be case insensitive, and the two strings can have a different
number of spaces. Given a string s and n other strings, you are asked to 
calculate how many of those are anagrams of the string s.

Input
The first line of the input contains the string s (1 ≤ |s| ≤ 100).
The second line contains the number n (0 ≤ n ≤ 10^4).
The next n lines contain strings of lengths not exceeding 100.

Output
The program should print the number of anagrams of the string s.

Examples
+-----------------------+---------------+
|Input        			|Output			|
+-----------------------+---------------+
|Tom Marvolo Riddle		|1				|
|2						|				|
|Some random string		|				|
|I am Lord Voldemort	|				|
+-----------------------+---------------+
*/

public class _09_Anagrams {

	public static String getKey(String str) {
		StringBuilder sb = new StringBuilder();
		for (char c : str.toCharArray()) {
			if (c != ' ') {
				sb.append(Character.toLowerCase(c));
			}
		}
		char[] charArr = sb.toString().toCharArray();
		Arrays.sort(charArr);
		String key = String.valueOf(charArr);
		return key;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		int n = scanner.nextInt();
		ArrayList<String> lines = new ArrayList<String>();
		while (n + 1 != 0) {
			lines.add(scanner.nextLine());
			n--;
		}
		scanner.close();

		// ----- INPUT READ -----

		HashMap<String, Integer> linesFrequency = new HashMap<String, Integer>();
		for (String line : lines) {
			String key = getKey(line);
			linesFrequency.putIfAbsent(key, 0);
			linesFrequency.put(key, linesFrequency.get(key) + 1);
		}

		String sKey = getKey(s);

		int res = 0;
		for (Entry<String, Integer> entry : linesFrequency.entrySet()) {
			if (entry.getKey().equals(sKey)) {
				res += entry.getValue();
			}
		}

		System.out.println(res);

	}

}
