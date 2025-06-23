package _01_implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://profound.academy/algorithms-data-structures/sea-battle-QlPrhs2w2BBvGpZJOHyg

/*
You're trying to develop the game "Sea Battle". At the beginning of this game, 
each player places some battleships on a board at certain locations. Each 
battleship spans a straight line from (r1, c1) to (r2, c2), where the 
connecting line between those coordinates is always perpendicular to the sides 
of the grid.
As a first step, you'd like to validate the grid to make sure, the users don't 
put the battleships too close to each other or even intersect them. Each of the 
battleships needs to have at least a single cell of water distancing it from 
another ship. It's okay to place the battleships next to the border without 
any water padding between the border and the ship.

Input
The first line of the input contains 3 integers n - the number of the 
battleships (1 ≤ n ≤ 20), w - the width of the battlefield (1 ≤ w ≤ 1000), 
and h - the height of the battlefield (1 ≤ h ≤ 1000).
The next n lines contain 4 integers (r1, c1) and (r2, c2) 
(1 <= r1 <= r2 <= h) (1 <= C1 <= C2 <= w) coordinates of each battleship.

Output
The program should print "Valid" in case the grid is valid and "Invalid" 
otherwise.

Examples
+---------------+---------------+
|Input        	|Output			|
+---------------+---------------+
|2 10 10		|Valid			|
|1 1 1 5		|				|
|8 1 8 10		|				|
+---------------+---------------+
|2 10 10		|Invalid		|
|1 1 1 5		|				|
|2 3 2 10		|				|
+---------------+---------------+
*/

public class _14_SeaBattle {

	private static int h, w;
	private static int[][] battlefield;
	private static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	private static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	/* Directions
	 * [(-1,-1) (-1,0) (-1,1)]
	 * [ (0,-1)  cell  (0,1)]
	 * [ (1,-1)  (1,0) (1,1)]
	*/

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		w = input.nextInt();
		h = input.nextInt();
		List<int[]> ships = new ArrayList<>();
		battlefield = new int[h][w];
		for (int i = 1; i <= n; i++) {
			int r1 = input.nextInt() - 1;
			int c1 = input.nextInt() - 1;
			int r2 = input.nextInt() - 1;
			int c2 = input.nextInt() - 1;

			int rowStart = Math.min(r1, r2);
			int rowEnd = Math.max(r1, r2);
			int colStart = Math.min(c1, c2);
			int colEnd = Math.max(c1, c2);

			for (int r = rowStart; r <= rowEnd; r++) {
				for (int c = colStart; c <= colEnd; c++) {
					if (battlefield[r][c] != 0) {
						System.out.println("Invalid");
						return;
					}
					battlefield[r][c] = i;
				}
			}

			ships.add(new int[] { rowStart, colStart, rowEnd, colEnd });
		}
		input.close();

		// ----- INPUT READ -----

		for (int r = 0; r < h; r++) {
			for (int c = 0; c < w; c++) {
				if (battlefield[r][c] != 0) {
					int shipId = battlefield[r][c];
					for (int d = 0; d < 8; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (inBounds(nr, nc) && battlefield[nr][nc] != 0 && battlefield[nr][nc] != shipId) {
							System.out.println("Invalid");
							return;
						}
					}
				}
			}
		}

		System.out.println("Valid");

	}

	static boolean inBounds(int r, int c) {
		return r >= 0 && r < h && c >= 0 && c < w;
	}

}
