
Longest Increasing Subsequence
Medium
18K
343
Companies
Given an integer array nums, return the length of the longest strictly increasing 
subsequence
.

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 

Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104


class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int[] dp = new int[n]; // dp[i] will store the length of LIS ending at index i
        dp[0] = 1; // Base case: The LIS ending at the first element is always 1
        
        int maxLength = 1; // Initialize maxLength to 1 (minimum LIS length is 1)
        
        for (int i = 1; i < n; i++) {
            dp[i] = 1; // Initialize LIS length for index i as 1 (minimum length)
            
            // Check all elements before index i to find if there is a strictly increasing subsequence ending at i
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            // Update the maxLength if the LIS ending at index i is greater
            maxLength = Math.max(maxLength, dp[i]);
        }
        
        return maxLength;
    }
}
