
Coin Change
Medium
16.9K
381
Companies
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104



class Solution {
    public int coinChange(int[] coins, int amount) {
        // Create an array dp to store the fewest number of coins needed for each amount
        int[] dp = new int[amount + 1];

        // Initialize dp array with a value greater than the maximum possible amount (amount + 1)
        Arrays.fill(dp, amount + 1);

        // Base case: To make amount 0, we need 0 coins
        dp[0] = 0;

        // Iterate through each coin in the coins array
        for (int coin : coins) {
            // For each coin, calculate the fewest number of coins needed for each amount from coin to amount
            for (int i = coin; i <= amount; i++) {
                // Update dp[i] to be the minimum of its current value or dp[i - coin] + 1
                // dp[i - coin] represents the fewest number of coins needed to make up the remaining amount (i - coin),
                // and adding 1 accounts for using the current coin in the solution
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        // If dp[amount] is greater than amount, it means we were not able to make up the given amount
        // Return -1 in such cases, otherwise, return the fewest number of coins needed to make up the amount
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
