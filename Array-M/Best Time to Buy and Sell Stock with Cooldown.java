309. Best Time to Buy and Sell Stock with Cooldown
Solved
Medium
Topics
Companies
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
Example 2:

Input: prices = [1]
Output: 0
 

Constraints:

1 <= prices.length <= 5000
0 <= prices[i] <= 1000


class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dpb = new int[n];  // dp for buy state
        int[] dps = new int[n];  // dp for sell state
        Arrays.fill(dpb, -1);    // Initialize with -1 (unvisited)
        Arrays.fill(dps, -1);    // Initialize with -1 (unvisited)

        return dfs(prices, dpb, dps, 0, null);
    }

    private int dfs(int[] prices, int[] dpb, int[] dps, int i, Integer stockPrice) {
        if (i >= prices.length) {
            return 0;
        }

        if (stockPrice == null && dpb[i] != -1) {  // If we haven't bought a stock yet
            return dpb[i];
        }
        if (stockPrice != null && dps[i] != -1) {  // If we have already bought a stock
            return dps[i];
        }

        int price = prices[i];
        int skip = dfs(prices, dpb, dps, i + 1, stockPrice);  // Skip this day

        if (stockPrice != null) {  // If holding a stock, we can sell
            int sell = price + dfs(prices, dpb, dps, i + 2, null);  // Sell and go to i + 2 because of cooldown
            dps[i] = Math.max(skip, sell);
            return dps[i];
        } else {  // If not holding a stock, we can buy
            int buy = dfs(prices, dpb, dps, i + 1, price) - price;  // Buy and hold stock
            dpb[i] = Math.max(buy, skip);
            return dpb[i];
        }
    }
}