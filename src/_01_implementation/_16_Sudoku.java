package _01_implementation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

// https://profound.academy/algorithms-data-structures/sudoku-368WaDQeCjf9szyA5Udv

/*
Given a sudoku grid, you are asked if it's a valid one.
A valid 9 x 9 sudoku grid should have:
1. All the numbers from 1 to 9 on each row.
2. All the numbers from 1 to 9 on each column.
3. All the numbers from 1 to 9 inside the 3 x 3 cells.

So, the invalid sudoku grid might have:
1. Some repeating numbers on some rows
2. Some repeating numbers on some columns
3. Some repeating numbers inside the 3 x 3 cells.

Input
The input contains a 9 x 9 grid of numbers. All the filled numbers are integers
from 0 to 9. The empty cells are represented as Os.

Output
The program should print Valid in case the grid is "Valid" and "Not valid" 
otherwise.

Examples
+---------------+---------------+
|Input        	|Output			|
+---------------+---------------+
|000008002		|Valid			|
|070000010		|				|
|020700900		|				|
|000000701		|				|
|000902600		|				|
|305800040		|				|
|900600400		|				|
|000207060		|				|
|001004000		|				|
+---------------+---------------+
|000008002		|Not valid		|
|070000010		|				|
|020700900		|				|
|000000701		|				|
|060902600		|				|
|305800040		|				|
|900600400		|				|
|000207060		|				|
|001004000		|				|
+---------------+---------------+
*/

public class _16_Sudoku {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[][] grid = new int[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				grid[i][j] = input.nextInt();
			}
		}

		input.close();

		// ----- INPUT READ -----

		HashMap<Integer, HashSet<Integer>> rows = new HashMap<Integer, HashSet<Integer>>();
		HashMap<Integer, HashSet<Integer>> cols = new HashMap<Integer, HashSet<Integer>>();
		HashMap<String, HashSet<Integer>> sqrs = new HashMap<String, HashSet<Integer>>();
		boolean isValid = true;
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				if (grid[r][c] == 0)
					continue;

				String sqKey = (r / 3) + "," + (c / 3);
				rows.computeIfAbsent(r, k -> new HashSet<Integer>());
				cols.computeIfAbsent(c, k -> new HashSet<Integer>());
				sqrs.computeIfAbsent(sqKey, k -> new HashSet<Integer>());
				
				if (rows.get(r).contains(grid[r][c]) || cols.get(c).contains(grid[r][c])
						|| sqrs.get(sqKey).contains(grid[r][c])) {
					System.out.println("Not valid");
					isValid = false;
					break;
				}

				rows.get(r).add(grid[r][c]);
				cols.get(c).add(grid[r][c]);
				sqrs.get(sqKey).add(grid[r][c]);
			}
			if (!isValid)
				break;
		}

		if (!isValid)
			return;

		System.out.println("Valid");
	}

}
