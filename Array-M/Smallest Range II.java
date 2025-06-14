910. Smallest Range II
Solved
Medium
Topics
premium lock icon
Companies
You are given an integer array nums and an integer k.

For each index i where 0 <= i < nums.length, change nums[i] to be either nums[i] + k or nums[i] - k.

The score of nums is the difference between the maximum and minimum elements in nums.

Return the minimum score of nums after changing the values at each index.

 

Example 1:

Input: nums = [1], k = 0
Output: 0
Explanation: The score is max(nums) - min(nums) = 1 - 1 = 0.
Example 2:

Input: nums = [0,10], k = 2
Output: 6
Explanation: Change nums to be [2, 8]. The score is max(nums) - min(nums) = 8 - 2 = 6.
Example 3:

Input: nums = [1,3,6], k = 3
Output: 3
Explanation: Change nums to be [4, 6, 3]. The score is max(nums) - min(nums) = 6 - 3 = 3.
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 104
0 <= k <= 104


class Solution {
    public int smallestRangeII(int[] nums, int k) {
        
        // Number of Elements
        int N  = nums.length;
      
        // Sort so that we can have partition
        Arrays.sort(nums);

        // Trivial Case, all incremented OR all decremented
        int score = nums[N-1] - nums[0];

        // To store minimum score
        int ans   = score;

        // Check all N-1 Non-Trivial partitions/walls. 
        // Both sets will be non-empty   
        for (int divider = 0; divider < N-1; divider++){

            // Compute maximum and minimum after partitioning
            // Kudos! We only have two candidates for each
            int maximumAfterDivision = Math.max(nums[divider]    + k , nums[N-1] - k);
            int minimumAfterDivision = Math.min(nums[divider+1]  - k , nums[0]  + k);

            // Score after dividing here
            score = maximumAfterDivision - minimumAfterDivision;

            // ans will be minimum score
            ans = Math.min(ans, score);
        }
        
        // return answer
        return ans;
    }
}
