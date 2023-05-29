
Spiral Matrix II
Medium
5.7K
233
Companies
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

 

Example 1:


Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
Example 2:

Input: n = 1
Output: [[1]]
 

Constraints:

1 <= n <= 20






class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        
        while (num <= n * n) {
            for (int col = left; col <= right; col++) {
                matrix[top][col] = num++;
            }
            top++;
            
            for (int row = top; row <= bottom; row++) {
                matrix[row][right] = num++;
            }
            right--;
            
            for (int col = right; col >= left; col--) {
                matrix[bottom][col] = num++;
            }
            bottom--;
            
            for (int row = bottom; row >= top; row--) {
                matrix[row][left] = num++;
            }
            left++;
        }
        
        return matrix;
    }
}

