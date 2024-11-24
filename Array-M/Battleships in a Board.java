419. Battleships in a Board
Solved
Medium
Topics
Companies
Given an m x n matrix board where each cell is a battleship 'X' or empty '.', return the number of the battleships on board.

Battleships can only be placed horizontally or vertically on board. In other words, they can only be made of the shape 1 x k (1 row, k columns) or k x 1 (k rows, 1 column), where k can be of any size. At least one horizontal or vertical cell separates between two battleships (i.e., there are no adjacent battleships).

 

Example 1:


Input: board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
Output: 2
Example 2:

Input: board = [["."]]
Output: 0
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is either '.' or 'X'.



/**
 * One-Pass Constant-Space solution. Input board is not modified
 *
 * Going over all cells, we can count only those that are the "last" cell of the
 * battleship. Last cell will be defined as the most bottom-right cell. We can
 * check for last cells by only counting cells that do not have an 'X' to the
 * right and do not have an 'X' below them.
 *
 * Time Complexity: O(M * N)
 *
 * Space Complexity: O(1)
 *
 * M = Number of rows in the board. N = Number of columns in the board.
 */
class Solution {
    public int countBattleships(char[][] board) {
        if (board == null) {
            throw new IllegalArgumentException("Input is null");
        }
        if (board.length == 0 || board[0].length == 0) {
            return 0;
        }

        int rows = board.length;
        int cols = board[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'X'
						&& (j == cols - 1 || board[i][j + 1] == '.')
                        && (i == rows - 1 || board[i + 1][j] == '.')) {
                    count++;
                }
            }
        }

        return count;
    }
}