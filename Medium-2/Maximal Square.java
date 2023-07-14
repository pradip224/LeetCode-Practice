Maximal Square
Medium
9.1K
191
Companies
Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

 

Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4
Example 2:


Input: matrix = [["0","1"],["1","0"]]
Output: 1
Example 3:

Input: matrix = [["0"]]
Output: 0

class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return 0;
        int cols = matrix[0].length;
        
        // Create a 2D array to store the maximum square size ending at each position
        int[][] dp = new int[rows + 1][cols + 1];
        
        int maxSquareSize = 0;
        
        // Traverse the matrix
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    // Calculate the maximum square size at the current position
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    
                    // Update the maximum square size found so far
                    maxSquareSize = Math.max(maxSquareSize, dp[i][j]);
                }
            }
        }
        
        // Return the area of the largest square
        return maxSquareSize * maxSquareSize;
    }
}

