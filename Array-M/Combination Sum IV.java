377. Combination Sum IV
Solved
Medium
Topics
Companies
Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

The test cases are generated so that the answer can fit in a 32-bit integer.

 

Example 1:

Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.
Example 2:

Input: nums = [9], target = 3
Output: 0
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 1000
All the elements of nums are unique.
1 <= target <= 1000



class Solution {
    public int combinationSum4(int[] nums, int target) {
        int sumCount[] = new int[target + 1];
        sumCount[0] = 1;
        int sz = nums.length;
        for(int sum = 1; sum <= target; sum++){
            for(int indx = 0; indx < sz; indx++){
                if(nums[indx] <= sum){
                    sumCount[sum] = (sumCount[sum] + sumCount[sum-nums[indx]]);
                }
            }
        }
        return sumCount[target];
    }
}