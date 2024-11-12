368. Largest Divisible Subset
Solved
Medium
Topics
Companies
Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:

answer[i] % answer[j] == 0, or
answer[j] % answer[i] == 0
If there are multiple solutions, return any of them.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,2]
Explanation: [1,3] is also accepted.
Example 2:

Input: nums = [1,2,4,8]
Output: [1,2,4,8]
 

Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 2 * 109
All the integers in nums are unique.


class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.sort(nums);
        Arrays.fill(dp,1);
        Arrays.fill(hash,-1);
        int max = 0;
        int last = -1;
        List<Integer> ans = new ArrayList<>();
        for(int i =0;i<n;i++){
            for(int j = 0;j<i;j++){
                if(nums[i] % nums[j] == 0 && dp[j]+1>dp[i]){
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
        if(max<dp[i]){
            max = dp[i];
            last = i;
        }

        }

        while(last!=-1){
            ans.add(nums[last]);
            last = hash[last];
        }

        Collections.reverse(ans);
        return ans;
    }
}