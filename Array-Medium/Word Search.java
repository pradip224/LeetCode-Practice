
Word Search
Medium
13.4K
544
Companies
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.







class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        // Iterate through each cell in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    // Start the backtracking algorithm from this cell
                    if (backtrack(board, word, i, j, 0))
                        return true;
                }
            }
        }
        
        // Word not found
        return false;
    }
    
    private boolean backtrack(char[][] board, String word, int i, int j, int index) {
        // Base case: If all characters of the word have been matched
        if (index == word.length())
            return true;
        
        // Check for out-of-bounds or mismatching characters
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index))
            return false;
        
        // Mark the current cell as visited
        char temp = board[i][j];
        board[i][j] = '#';
        
        // Recursively backtrack in all four directions
        boolean found = backtrack(board, word, i + 1, j, index + 1) ||
                        backtrack(board, word, i - 1, j, index + 1) ||
                        backtrack(board, word, i, j + 1, index + 1) ||
                        backtrack(board, word, i, j - 1, index + 1);
        
        // Restore the original value of the current cell
        board[i][j] = temp;
        
        return found;
    }
}




