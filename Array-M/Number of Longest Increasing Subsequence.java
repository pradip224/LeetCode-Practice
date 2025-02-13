673. Number of Longest Increasing Subsequence
Solved
Medium
Topics
Companies
Given an integer array nums, return the number of longest increasing subsequences.

Notice that the sequence has to be strictly increasing.

 

Example 1:

Input: nums = [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
Example 2:

Input: nums = [2,2,2,2,2]
Output: 5
Explanation: The length of the longest increasing subsequence is 1, and there are 5 increasing subsequences of length 1, so output 5.
 

Constraints:

1 <= nums.length <= 2000
-106 <= nums[i] <= 106
The answer is guaranteed to fit inside a 32-bit integer.


class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dpLen = new int[n];
        int[] dpCount = new int[n];
        dpLen[0] = 1;
        dpCount[0] = 1;
        int currLen = 1;
        int currCount = 1;
        int overallLen = 1;
        int res = 1;


        for(int i = 1; i < n; i++){
            currLen = 1;
            currCount = 1;
            for(int j = i - 1; j >= 0; j--){
                if(nums[i] > nums[j]){
                    if(dpLen[j] + 1 == currLen){
                        currCount += dpCount[j];
                    }else if(dpLen[j] + 1 > currLen){
                        currLen = dpLen[j] + 1;
                        currCount = dpCount[j];
                    }
                }
            }

            dpLen[i] = currLen;
            dpCount[i] = currCount;

            if(currLen == overallLen){
                res += currCount;
            }else if(currLen > overallLen){
                res = currCount;
                overallLen = currLen;
            }
        }

        return res;
    }
}
