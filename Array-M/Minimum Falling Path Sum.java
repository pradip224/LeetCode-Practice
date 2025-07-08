931. Minimum Falling Path Sum
Solved
Medium
Topics
premium lock icon
Companies
Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

 

Example 1:


Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13
Explanation: There are two falling paths with a minimum sum as shown.
Example 2:


Input: matrix = [[-19,57],[-40,-5]]
Output: -59
Explanation: The falling path with a minimum sum is shown.
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 100
-100 <= matrix[i][j] <= 100


class Solution {
    public int minFallingPathSum(int[][] matrix) {
        // ham start karenge last row ke kisi bhi ek element se...starting row ke kisi bhi ek element tak.
        int n = matrix[0].length;
        int m = matrix.length;
        int min = Integer.MAX_VALUE;

        // Recursion..
        // for(int j = 0; j < n; j++){
        //     min = Math.min(recursion(matrix, m-1, j), min);
        // }
        //  return min;

        // Memoization.. (Top Down)
        // int dp[][] = new int[m][n];
        // for(int arr[] : dp){
        //     Arrays.fill(arr, -1);
        // }
        // for(int j = 0; j < n; j++){
        //     min = Math.min(memo(matrix, m-1, j, dp), min);
        // }
        //  return min;



        // Tabulation (Bottom Up)
        // return tabulation(matrix, m, n);


        // Space Optimization..
        return spaceOpt(matrix, m, n);
    }

    public int recursion(int grid[][], int i, int j) {
        // base case aur out of bound wala case likh lo
        if (j < 0 || j >= grid[0].length) {
            return Integer.MAX_VALUE / 100;
        }
        if (i == 0) {
            return grid[i][j];
        }

        // traverse all the paths.. 
        int up = grid[i][j] + recursion(grid, i - 1, j);
        int leftDigonal = grid[i][j] + recursion(grid, i - 1, j - 1);
        int rightDigonal = grid[i][j] + recursion(grid, i - 1, j + 1);

        // do the final calculation..
        return Math.min(up, Math.min(leftDigonal, rightDigonal));
    }

    // Memo (Top Down)
    public int memo(int grid[][], int i, int j, int dp[][]) {
        if (j < 0 || j >= grid[0].length) {
            return Integer.MAX_VALUE / 100;
        }
        if (i == 0) {
            return grid[i][j];
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        int up = grid[i][j] + memo(grid, i - 1, j, dp);
        int leftDigonal = grid[i][j] + memo(grid, i - 1, j - 1, dp);
        int rightDigonal = grid[i][j] + memo(grid, i - 1, j + 1, dp);

        return dp[i][j] = Math.min(up, Math.min(leftDigonal, rightDigonal));
    }

    // Tabulation (Buttom Up)
    public int tabulation(int grid[][], int m, int n) {
        int dp[][] = new int[m][n];

        // base case toh ho gya..
        for (int j = 0; j < n; j++) {
            dp[0][j] = grid[0][j];
        }

        // traverse all paths..
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int up = grid[i][j] + dp[i - 1][j];

                int leftDigonal = grid[i][j];
                if (j > 0) {
                    leftDigonal += dp[i - 1][j - 1];
                }else{
                    leftDigonal += Integer.MAX_VALUE/100;
                }
                int rightDigonal = grid[i][j];
                if (j < n - 1) {
                    rightDigonal += dp[i - 1][j + 1];
                }else{
                    rightDigonal += Integer.MAX_VALUE/100;
                }

                // taking mininum (final calculation)
                dp[i][j] = Math.min(up, Math.min(leftDigonal, rightDigonal));
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp[m - 1][j]);
        }
        return min;
    }
    // Space Optimization.
    public int spaceOpt(int grid[][], int m, int n) {
        int prev[] = new int[n];

        // base case toh ho gya..
        for (int j = 0; j < n; j++) {
            prev[j] = grid[0][j];
        }

        // traverse all paths..
        for (int i = 1; i < m; i++) {
            int curr[] = new int[n];
            for (int j = 0; j < n; j++) {
                int up = grid[i][j] + prev[j];

                int leftDigonal = grid[i][j];
                if (j > 0) {
                    leftDigonal += prev[j - 1];
                }else{
                    leftDigonal += Integer.MAX_VALUE/100;
                }
                int rightDigonal = grid[i][j];
                if (j < n - 1) {
                    rightDigonal += prev[j + 1];
                }else{
                    rightDigonal += Integer.MAX_VALUE/100;
                }

                // taking mininum (final calculation)
                curr[j] = Math.min(up, Math.min(leftDigonal, rightDigonal));
            }
            prev = curr;
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, prev[j]);
        }
        return min;
    }
}
