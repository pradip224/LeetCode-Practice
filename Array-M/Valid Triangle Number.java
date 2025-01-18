611. Valid Triangle Number
Solved
Medium
Topics
Companies
Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

 

Example 1:

Input: nums = [2,2,3,4]
Output: 3
Explanation: Valid combinations are: 
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3
Example 2:

Input: nums = [4,2,3,4]
Output: 4
 

Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 1000


class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int c = 0;
        if(n<3)
        {
            return 0;
        }
        for(int i = n-1;i>=2;i--)
        {
            int j = 0, k = i-1;
            while(j<k)
            {
                if(nums[j] + nums[k] > nums[i])
                {
                    c += (k-j);
                    k--;
                }
                else
                {
                   j++; 
                }
            }
        }
        return c;
    }
}
