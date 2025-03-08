764. Largest Plus Sign
Solved
Medium
Topics
Companies
Hint
You are given an integer n. You have an n x n binary grid grid with all values initially 1's except for some indices given in the array mines. The ith element of the array mines is defined as mines[i] = [xi, yi] where grid[xi][yi] == 0.

Return the order of the largest axis-aligned plus sign of 1's contained in grid. If there is none, return 0.

An axis-aligned plus sign of 1's of order k has some center grid[r][c] == 1 along with four arms of length k - 1 going up, down, left, and right, and made of 1's. Note that there could be 0's or 1's beyond the arms of the plus sign, only the relevant area of the plus sign is checked for 1's.

 

Example 1:


Input: n = 5, mines = [[4,2]]
Output: 2
Explanation: In the above grid, the largest plus sign can only be of order 2. One of them is shown.
Example 2:


Input: n = 1, mines = [[0,0]]
Output: 0
Explanation: There is no plus sign, so return 0.
 

Constraints:

1 <= n <= 500
1 <= mines.length <= 5000
0 <= xi, yi < n
All the pairs (xi, yi) are unique.


class Solution {
    
    public class Total {
        int l;
        int r;
        int u;
        int d;
        
        Total(int l, int r, int u, int d){
            this.l = l;
            this.r = r;
            this.u = u;
            this.d = d;
        }
    }
    
    public int orderOfLargestPlusSign(int n, int[][] mine) {
        int[][] mines = new int[n][n];
        
        
        for (int[] row : mines) {
            Arrays.fill(row, 1);
        }
        
        
        for (int[] m : mine) {
            mines[m[0]][m[1]] = 0;
        }
        
        Total[][] nums = new Total[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = new Total(0, 0, 0, 0);
            }
        }
        
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (mines[i][j] == 0) {
                    sum = 0;
                    nums[i][j].l = sum;
                } else {
                    nums[i][j].l = ++sum;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (mines[i][j] == 0) {
                    sum = 0;
                    nums[i][j].r = sum;
                } else {
                    nums[i][j].r = ++sum;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (mines[j][i] == 0) {
                    sum = 0;
                    nums[j][i].u = sum;
                } else {
                    nums[j][i].u = ++sum;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (mines[j][i] == 0) {
                    sum = 0;
                    nums[j][i].d = sum;
                } else {
                    nums[j][i].d = ++sum;
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                max = Math.max(Math.min(nums[i][j].l, Math.min(nums[i][j].r, Math.min(nums[i][j].d, nums[i][j].u))), max);
            }
        }
        
        return max;
    }
}
