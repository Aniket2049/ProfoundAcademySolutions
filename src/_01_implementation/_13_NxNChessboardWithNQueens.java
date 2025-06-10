package _01_implementation;

import java.util.HashSet;
import java.util.Scanner;

// https://profound.academy/algorithms-data-structures/n-by-n-chessboard-with-n-queens-zqP9fOoQXQkG805pvdMG

/*
N by N chessboard with N queens

Given an N x N chessboard and queens with their coordinates, you are asked if 
there are any two queens that attack each other.

Input
The first line of the input contains a single integer N (1 ≤ N ≤ 100).
The next N lines contain the (ri, ci) coordinates of the queens (1 ≤ ri, ci ≤ N).

Output
The program should print Yes in case there are queens attacking each other and 
No otherwise.

Examples
+---------------+---------------+
|Input        	|Output			|
+---------------+---------------+
|4				|No				|
|1 2			|				|
|2 4			|				|
|3 1			|				|
|4 3			|				|
+---------------+---------------+
|4				|Yes			|
|1 1			|				|
|2 3			|				|
|3 4			|				|
|4 2			|				|
+---------------+---------------+
*/
public class _13_NxNChessboardWithNQueens {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int[][] queens = new int[N][2];
		for (int i = 0; i < N; i++) {
			queens[i][0] = input.nextInt();
			queens[i][1] = input.nextInt();
		}
		input.close();

		// ----- INPUT READ -----

//		int N = 4;
//		int[][] queens = { { 1, 2 }, { 2, 4 }, { 3, 1 }, { 4, 3 } };	// No
//		int[][] queens = { { 1, 1 }, { 2, 3 }, { 3, 4 }, { 4, 2 } };	// Yes

		boolean isAttacking = false;
		HashSet<Integer> rows = new HashSet<Integer>();
		HashSet<Integer> cols = new HashSet<Integer>();
		HashSet<Integer> pDiag = new HashSet<Integer>();
		HashSet<Integer> nDiag = new HashSet<Integer>();

		for (int i = 0; i < queens.length; i++) {
			int r = queens[i][0];
			int c = queens[i][1];
			int pDiagKey = c - r;
			int nDiagKey = r + c;

			if (rows.contains(r) || cols.contains(c) || pDiag.contains(pDiagKey) || nDiag.contains(nDiagKey)) {
				System.out.println("Yes");
				isAttacking = true;
				break;
			}

			rows.add(r);
			cols.add(c);
			pDiag.add(pDiagKey);
			nDiag.add(nDiagKey);
		}

		if (isAttacking)
			return;

		System.out.println("No");
	}

}
