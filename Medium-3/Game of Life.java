Game of Life
Medium
5.8K
501
Companies
According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.

 

Example 1:


Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
Example 2:


Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 25
board[i][j] is 0 or 1.


class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;
        int[][] nextBoard = new int[m][n]; // Create a copy of the board to store the next state

        // Loop through each cell in the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = countLiveNeighbors(board, i, j);

                // Apply the rules to determine the next state of the cell
                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    nextBoard[i][j] = 0; // Cell dies due to under-population or over-population
                } else if (board[i][j] == 1 && (liveNeighbors == 2 || liveNeighbors == 3)) {
                    nextBoard[i][j] = 1; // Cell lives on to the next generation
                } else if (board[i][j] == 0 && liveNeighbors == 3) {
                    nextBoard[i][j] = 1; // Dead cell becomes live due to reproduction
                }
            }
        }

        // Update the original board with the next state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = nextBoard[i][j];
            }
        }
    }

    // Helper method to count the live neighbors of a cell
    private int countLiveNeighbors(int[][] board, int i, int j) {
        int count = 0;
        int m = board.length;
        int n = board[0].length;

        // Relative coordinates of the eight neighbors (horizontal, vertical, diagonal)
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int k = 0; k < 8; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            // Check if the neighbor coordinates are within the board boundaries
            if (x >= 0 && x < m && y >= 0 && y < n) {
                count += board[x][y]; // If the neighbor is live (1), add 1 to the count
            }
        }

        return count;
    }
}
