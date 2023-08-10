

714. Best Time to Buy and Sell Stock with Transaction Fee
Medium
6.6K
183
Companies
You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.

Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.

Note:

You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
The transaction fee is only charged once for each stock purchase and sale.
 

Example 1:

Input: prices = [1,3,2,8,4,9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
- Buying at prices[0] = 1
- Selling at prices[3] = 8
- Buying at prices[4] = 4
- Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
Example 2:

Input: prices = [1,3,7,5,10,3], fee = 3
Output: 6
 

Constraints:

1 <= prices.length <= 5 * 104
1 <= prices[i] < 5 * 104
0 <= fee < 5 * 104


class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int hold = -prices[0]; // Initial profit if we buy the stock on the first day
        int cash = 0; // Initial profit if we do not buy the stock on the first day
        
        for (int i = 1; i < n; i++) {
            // Update the hold and cash variables
            int newHold = Math.max(hold, cash - prices[i]);
            int newCash = Math.max(cash, hold + prices[i] - fee);
            
            hold = newHold;
            cash = newCash;
        }
        
        // Return the maximum profit when not holding the stock
        return cash;
    }
}

