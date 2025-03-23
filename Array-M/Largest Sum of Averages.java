813. Largest Sum of Averages
Solved
Medium
Topics
Companies
You are given an integer array nums and an integer k. You can partition the array into at most k non-empty adjacent subarrays. The score of a partition is the sum of the averages of each subarray.

Note that the partition must use every integer in nums, and that the score is not necessarily an integer.

Return the maximum score you can achieve of all the possible partitions. Answers within 10-6 of the actual answer will be accepted.

 

Example 1:

Input: nums = [9,1,2,3,9], k = 3
Output: 20.00000
Explanation: 
The best choice is to partition nums into [9], [1, 2, 3], [9]. The answer is 9 + (1 + 2 + 3) / 3 + 9 = 20.
We could have also partitioned nums into [9, 1], [2], [3, 9], for example.
That partition would lead to a score of 5 + 2 + 6 = 13, which is worse.
Example 2:

Input: nums = [1,2,3,4,5,6,7], k = 4
Output: 20.50000
 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 104
1 <= k <= nums.length

class Solution {
  public double largestSumOfAverages(int[] nums, int k) {
    int n = nums.length;
    Double[][] dp = new Double[n][k];
    return divide(nums, 0, n, k-1, dp);
  }
  
  public double divide(int[] nums, int start, int end, int k, Double[][] dp) {
    if(start >= end) return 0;
    if(dp[start][k] != null) return dp[start][k];
    if(k == 0) {
      double lastPartitionSum = 0;
      for(int j = start; j < end; j++) {
        lastPartitionSum += nums[j];
      }
      return lastPartitionSum / (end - start);
    }
    
    double max = 0;
    for(int i = start+1; i < end; i++) { // try to split at every single index > start
      double res = divide(nums, i, end, k-1, dp);
      
      double currPartitionSum = 0;
      for(int j = start; j < i; j++) { // get the average of the partition we just tried to make
        currPartitionSum += nums[j];
      }
      double avg = currPartitionSum / (i - start); 
      max = Math.max(res + avg, max); // optimal substructure, find the best partition at each index
    }
    dp[start][k] = max;
    return max;    
  }
}
