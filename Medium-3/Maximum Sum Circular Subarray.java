
Maximum Sum Circular Subarray
Medium
6K
258
Companies
Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

 

Example 1:

Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3.
Example 2:

Input: nums = [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
Example 3:

Input: nums = [-3,-2,-3]
Output: -2
Explanation: Subarray [-2] has maximum sum -2.
 

Constraints:

n == nums.length
1 <= n <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        // Step 1: Find the maximum subarray sum using Kadane's algorithm
        int maxKadane = kadane(nums);

        // Step 2: Find the maximum circular subarray sum
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Invert the signs of the array elements and find the minimum subarray sum using Kadane's algorithm
        int[] invertedNums = new int[n];
        for (int i = 0; i < n; i++) {
            invertedNums[i] = -nums[i];
        }
        int maxWrap = totalSum + kadane(invertedNums);

        // If all elements are negative, the maximum circular subarray sum will be the maximum subarray sum
        if (maxWrap == 0) {
            return maxKadane;
        }

        // Return the maximum of the two scenarios
        return Math.max(maxKadane, maxWrap);
    }

    // Kadane's algorithm to find the maximum subarray sum
    private int kadane(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}

