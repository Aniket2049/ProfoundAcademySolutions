package _01_implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

// https://profound.academy/algorithms-data-structures/plural-nouns-GJx4yjmjU0drA7GBCVg1

/*
Plural nouns
Let's make a simple program that would turn a singular noun into a plural one. 
There are several rules that we would like to follow:
1. For regular nouns, add s to the end (cat -> cats, house -> houses, etc)
2. If the noun ends with s, ss, sh, ch, x, or z, add es to the end 
(bus -> buses, tax -> taxes, etc)
3. If the noun ends with y, and the letter before y is a consonant, change the 
ending to ies (city -> cities, puppy -> puppies)
4. If the noun ends with y, and the letter before y is a vowel, add s 
(ray -> rays, boy -> boys, etc)

Input
The input contains a single word w (1 ≤ |w| ≤100).

Output
The program should print the plural version of w.

Examples
+---------------+---------------+
|Input        	|Output			|
+---------------+---------------+
|bus			|buses			|
+---------------+---------------+
|cat			|cats			|
+---------------+---------------+
|table			|tables			|
+---------------+---------------+
*/

public class _11_PluralNouns {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String word = scanner.nextLine();
		scanner.close();

		// ----- INPUT READ -----

		HashSet<Character> vowel = new HashSet<Character>();
		vowel.add('a');
		vowel.add('e');
		vowel.add('i');
		vowel.add('o');
		vowel.add('u');

		String lastTwoChars = word.substring(word.length() - 3, word.length());
		Character lastChar = word.charAt(word.length() - 1);

		if (lastChar == 'y') {
			if (vowel.contains(word.charAt(word.length() - 2))) {
				word += "s";
			} else {
				word = word.substring(0, word.length() - 1);
				word += "ies";
			}
		} else if (lastChar.equals('s') || lastChar.equals('x') || lastChar.equals('z') || lastTwoChars.equals("ss")
				|| lastTwoChars.equals("sh")) {
			word += "es";
		} else {
			word += "s";
		}

		System.out.println(word);
	}

}
