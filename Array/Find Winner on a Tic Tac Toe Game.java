1275. Find Winner on a Tic Tac Toe Game
Easy
1.4K
327
Companies
Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:

Players take turns placing characters into empty squares ' '.
The first player A always places 'X' characters, while the second player B always places 'O' characters.
'X' and 'O' characters are always placed into empty squares, never on filled ones.
The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
The game also ends if all squares are non-empty.
No more moves can be played if the game is over.
Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played on grid[rowi][coli]. return the winner of the game if it exists (A or B). In case the game ends in a draw return "Draw". If there are still movements to play return "Pending".

You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.

 

Example 1:


Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
Output: "A"
Explanation: A wins, they always play first.
Example 2:


Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
Output: "B"
Explanation: B wins.
Example 3:


Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
Output: "Draw"
Explanation: The game ends in a draw since there are no moves to make.
 

Constraints:

1 <= moves.length <= 9
moves[i].length == 2
0 <= rowi, coli <= 2
There are no repeated elements on moves.
moves follow the rules of tic tac toe.


/**
 * Space Optimized solution. Here the score of each row, column and diagonal is
 * stored in an int. For Player1 add 1 and for Player2 add -1.
 *
 * Time Complexity: O(M) or O(N^2) or O(1)
 *
 * Space Complexity: O(N) = O(1)
 *
 * M = Number of Moves. N = Board Size (3 -> Number of Rows or Number of Columns)
 */
class Solution {
    public String tictactoe(int[][] moves) {
        if (moves == null || moves.length > 9) {
            throw new IllegalArgumentException("Input move list is invalid");
        }

        int n = 3;
        int[] rows = new int[n];
        int[] cols = new int[n];
        int diag1 = 0;
        int diag2 = 0;
        int numMoves = moves.length;

        for (int i = 0; i < numMoves; i++) {
            int r = moves[i][0];
            int c = moves[i][1];
            int val = i % 2 == 0 ? 1 : -1;
            rows[r] += val;
            cols[c] += val;
            if (r == c) {
                diag1 += val;
            }
            if (r + c == n - 1) {
                diag2 += val;
            }
            if (Math.abs(rows[r]) == n || Math.abs(cols[c]) == n || Math.abs(diag1) == n || Math.abs(diag2) == n) {
                if (i != numMoves - 1) {
                    throw new IllegalArgumentException("Input move list is invalid");
                }
                return val == 1 ? "A" : "B";
            }
        }

        return numMoves == 9 ? "Draw" : "Pending";
    }
}