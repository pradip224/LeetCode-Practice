
Equal Row and Column Pairs
Medium
1.8K
96
Companies
Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.

A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).

 

Example 1:


Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
Output: 1
Explanation: There is 1 equal row and column pair:
- (Row 2, Column 1): [2,7,7]
Example 2:


Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
Output: 3
Explanation: There are 3 equal row and column pairs:
- (Row 0, Column 0): [3,1,2,2]
- (Row 2, Column 2): [2,4,2,2]
- (Row 3, Column 2): [2,4,2,2]
 

Constraints:

n == grid.length == grid[i].length
1 <= n <= 200
1 <= grid[i][j] <= 105


import java.util.HashMap;
import java.util.Map;

class Solution {
    public int equalPairs(int[][] grid) {
        int count = 0;
        int n = grid.length;
        
        // Store the rows in a map where the key is the row as a string and the value is the count of occurrences.
        Map<String, Integer> rowCounts = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String rowAsString = arrayToString(grid[i]);
            rowCounts.put(rowAsString, rowCounts.getOrDefault(rowAsString, 0) + 1);
        }
        
        // Check each column and find the number of equal pairs.
        for (int j = 0; j < n; j++) {
            int[] columnArray = new int[n];
            for (int i = 0; i < n; i++) {
                columnArray[i] = grid[i][j];
            }
            String columnAsString = arrayToString(columnArray);
            count += rowCounts.getOrDefault(columnAsString, 0);
        }
        
        return count;
    }
    
    private String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append(",");
        }
        return sb.toString();
    }
}
