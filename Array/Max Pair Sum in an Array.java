2815. Max Pair Sum in an Array
Solved
Easy
Topics
Companies
Hint
You are given a 0-indexed integer array nums. You have to find the maximum sum of a pair of numbers from nums such that the maximum digit in both numbers are equal.

Return the maximum sum or -1 if no such pair exists.

 

Example 1:

Input: nums = [51,71,17,24,42]
Output: 88
Explanation: 
For i = 1 and j = 2, nums[i] and nums[j] have equal maximum digits with a pair sum of 71 + 17 = 88. 
For i = 3 and j = 4, nums[i] and nums[j] have equal maximum digits with a pair sum of 24 + 42 = 66.
It can be shown that there are no other pairs with equal maximum digits, so the answer is 88.
Example 2:

Input: nums = [1,2,3,4]
Output: -1
Explanation: No pair exists in nums with equal maximum digits.
 

Constraints:

2 <= nums.length <= 100
1 <= nums[i] <= 104

class Solution {
    public int maxSum(int[] nums) {
        int n=nums.length;
        int maxx=-1;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int n1=getMaxDigit(nums[i]);
                int n2=getMaxDigit(nums[j]);
                if(n1==n2){
                    maxx=Math.max(maxx,nums[j]+nums[i]);
                }
            }
        }
        return maxx;
    }
    private int getMaxDigit(int num){
        int maxx=0;
        while(num>0){
            int r=num%10;
            maxx=Math.max(maxx,r);
            num/=10;
        }
        return maxx;
    }
}