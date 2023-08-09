790. Domino and Tromino Tiling
Medium
3K
950
Companies
You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.


Given an integer n, return the number of ways to tile an 2 x n board. Since the answer may be very large, return it modulo 109 + 7.

In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.

 

Example 1:


Input: n = 3
Output: 5
Explanation: The five different ways are show above.
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 1000

class Solution {
    public int numTilings(int n) {
        int MOD = 1000000007;
        
        // dp[i] represents the number of ways to tile a 2 x i board
        // Initialize dp array with values for base cases
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            // Place a vertical 2 x 1 tile at the end
            dp[i] = dp[i - 1];
            
            // Place two horizontal 2 x 1 tiles at the end
            dp[i] = (dp[i] + dp[i - 2]) % MOD;
            
            // Consider tromino shapes
            for (int j = 3; j <= i; j++) {
                dp[i] = (dp[i] + dp[i - j] * 2) % MOD;
            }
        }
        
        return (int) dp[n];
    }
}

