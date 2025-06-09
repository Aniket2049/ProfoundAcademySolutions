package _01_implementation;

import java.util.ArrayList;
import java.util.Scanner;

// https://profound.academy/algorithms-data-structures/capture-the-knight-20XvDdBvMSC7a2ZshTS5

/*
Capture the knight
Given an 8 x 8 chessboard, one white knight at position(r1, c1) and one black 
knight at position(r2, c2), you are asked if one can capture the other in 1 or 
2 moves. A knight captures another knight if it moves to the same location as 
the other one. As a reminder, in one move, the knight moves 2 cells in one 
direction and 1 cell in another perpendicular to the first direction. So, it 
can move 2 cells up and 1 cell left or right. It can move 2 cells right and 1 
cell up or down. It can move 2 cells down and one cell left or right, etc. In 
this problem, the second knight stays in the same place, while the first one 
does exactly two moves.

Input
The input contains 2 lines. The first line contains two coordinates indicating 
the first knight (r1, c1), while the second line contains the coordinates of 
the second knight (r2, c2) (1<= r1, c1, r2, c2 <= 8). It's guaranteed that 
(r1, c1) is different from (r2, c2).

Output
The program should print "Yes" in case the first knight can capture the second 
one in 1 or 2 moves and "No" otherwise.

Examples
+---------------+---------------+
|Input        	|Output			|
+---------------+---------------+
|1 1			|Yes			|
|1 3			|				|
+---------------+---------------+
|1 1			|No				|
|1 8			|				|
+---------------+---------------+

Explanation
(1,1) -> (3,2) -> (1,3)

*/

public class _07_CaptureTheKnight {

	public static boolean isValidPosition(int r, int c) {
		if (r < 1 || c < 1 || r > 8 || c > 8)
			return false;
		return true;
	}

	public static ArrayList<int[]> getNextKnightPositions(int r, int c) {
		ArrayList<int[]> resultPositions = new ArrayList<int[]>();
		int[][] dirs = { { 2, -1 },	// UP LEFT
				{ 2, 1 },	// UP RIGHT
				{ 1, 2 }, 	// RIGHT UP
				{ -1, 2 }, 	// RIGHT DOWN
				{ -2, -1 }, // DOWN LEFT
				{ -2, 1 }, 	// DOWN RIGHT
				{ -1, -2 }, // LEFT DOWN
				{ 1, -2 }, 	// LEFT UP
		};

		for (int i = 0; i < dirs.length; i++) {
			// add row change to current row coordinate
			int dr = dirs[i][0];
			// add column change to current column coordinate
			int dc = dirs[i][1];

			// new Row and Column position
			int newRow = r + dr;
			int newCol = c + dc;

			// if positions are valid i.e. within bounds of chess board add them to resultant array
			if (isValidPosition(newRow, newCol)) {
				resultPositions.add(new int[] { newRow, newCol });
			}
		}

		return resultPositions;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int r1 = input.nextInt();
		int c1 = input.nextInt();
		int r2 = input.nextInt();
		int c2 = input.nextInt();
		input.close();

		//--------Input Read--------

//		int r1 = 1, r2 = 1;
//		int c1 = 1, c2 = 3;

		int moves = 2;
		boolean found = false;

		// add starting positions for each move
		ArrayList<int[]> startingPositions = new ArrayList<int[]>();
		startingPositions.add(new int[] { r1, c1 });

		while (moves != 0) {
			// nextMoveStartingPositions will replace startingPositions array for next move
			ArrayList<int[]> nextMoveStartingPositions = new ArrayList<int[]>();
			for (int i = 0; i < startingPositions.size(); i++) {
				// get current row and column coordinates
				int curRow = startingPositions.get(i)[0];
				int curCol = startingPositions.get(i)[1];

				// fetch all possible positions from current coordinates
				ArrayList<int[]> nextPositions = getNextKnightPositions(curRow, curCol);
				for (int[] pos : nextPositions) {
					// if a next coordinate pair is equal to second knights position we stop execution by marking found as true
					if (pos[0] == r2 && pos[1] == c2) {
						System.out.println("Yes");
						found = true;
						break;
					}
				}

				if (found)
					break;

				// we add all coordinates possible from current first move to check in next move
				nextMoveStartingPositions.addAll(nextPositions);
			}

			if (found)
				break;
			// we add all coordinates possible from first move to check in next move			
			startingPositions = nextMoveStartingPositions;
			moves--;
		}

		if (found)
			return;

		System.out.println("No");

	}

}
