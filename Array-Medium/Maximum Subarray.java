

Maximum Subarray
Medium
29.7K
1.3K
Companies
Given an integer array nums, find the 
subarray
 with the largest sum, and return its sum.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104






class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0]; // Initialize maxSum with the first element
        int currentSum = nums[0]; // Initialize currentSum with the first element

        for (int i = 1; i < nums.length; i++) {
            // Calculate the maximum sum up to the current index
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // Update the maximum sum if the current sum is greater
            maxSum = Math.max(maxSum, currentSum);
            // System.out.println(maxSum+":"+currentSum);
        }
        
        return maxSum;
    }
}


