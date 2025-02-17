695. Max Area of Island
Solved
Medium
Topics
Companies
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

 

Example 1:


Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] is either 0 or 1.


class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for(int i=0; i<grid.length; i++)
            for(int j=0; j<grid[0].length; j++)
                if(grid[i][j] == 1) {
                    int[] ans = new int[1];
                    send(grid, i, j, ans);
                    res = Math.max(res, ans[0]);
                }
        return res;
    }
    
    void send(int[][] grid, int i, int j, int[] ans) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0) return;
        grid[i][j] = 0; ans[0]++;
        send(grid,i+1,j,ans); send(grid,i,j+1,ans);
        send(grid,i-1,j,ans); send(grid,i,j-1,ans);
    }
}
