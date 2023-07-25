
Increasing Triplet Subsequence
Medium
6.9K
324
Companies
Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

 

Example 1:

Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
Example 2:

Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.
Example 3:

Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 

Constraints:

1 <= nums.length <= 5 * 105
-231 <= nums[i] <= 231 - 1


class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min1 = Integer.MAX_VALUE; // Initialize the first minimum to the maximum possible value
        int min2 = Integer.MAX_VALUE; // Initialize the second minimum to the maximum possible value

        for (int num : nums) {
            if (num <= min1) {
                min1 = num; // Update the first minimum
            } else if (num <= min2) {
                min2 = num; // Update the second minimum
            } else {
                return true; // Found a number greater than both min1 and min2, triplet found
            }
        }

        return false; // No triplet found
    }
}


