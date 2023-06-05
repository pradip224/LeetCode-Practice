
Triangle
Medium
8.2K
485
Companies
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

 

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10
 

Constraints:

1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104






class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        
        // Create a 2D array to store the minimum path sums
        int[][] dp = new int[rows][rows];
        
        // Copy the elements of the bottom row to the dp array
        for (int i = 0; i < rows; i++) {
            dp[rows - 1][i] = triangle.get(rows - 1).get(i);
        }
        
        // Iterate from the second last row up to the top
        for (int i = rows - 2; i >= 0; i--) {
            List<Integer> currRow = triangle.get(i);
            for (int j = 0; j < currRow.size(); j++) {
                // Calculate the minimum path sum for the current element
                dp[i][j] = currRow.get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        
        // The minimum path sum from top to bottom is the value at the top of the dp array
        return dp[0][0];
    }
}
