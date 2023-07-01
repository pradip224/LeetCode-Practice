
Unique Binary Search Trees
Medium
9.3K
363
Companies
Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

 

Example 1:


Input: n = 3
Output: 5
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 19





class Solution {
    public int numTrees(int n) {
        // Create an array to store the number of unique BSTs for each value of n
        int[] dp = new int[n + 1];
        
        // There is only one unique BST with no nodes
        dp[0] = 1;
        
        // There is only one unique BST with a single node
        dp[1] = 1;

        // Iterate from 2 to n to calculate dp[i]
        for (int i = 2; i <= n; i++) {
            // Iterate from 1 to i to calculate dp[i]
            for (int j = 1; j <= i; j++) {
                // Multiply the number of unique left subtrees and right subtrees
                // and add it to the total number of unique BSTs for i nodes
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        // Return the total number of unique BSTs with n nodes
        return dp[n];
    }
}


