324. Wiggle Sort II
Solved
Medium
Topics
Companies
Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

You may assume the input array always has a valid answer.

 

Example 1:

Input: nums = [1,5,1,1,6,4]
Output: [1,6,1,5,1,4]
Explanation: [1,4,1,5,1,6] is also accepted.
Example 2:

Input: nums = [1,3,2,2,3,1]
Output: [2,3,1,3,1,2]
 

Constraints:

1 <= nums.length <= 5 * 104
0 <= nums[i] <= 5000
It is guaranteed that there will be an answer for the given input nums.


class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = (n - 1)/2;
        int right = n-1;
        int res[] = new int[n];
        int i = 0;
        while(left >= 0){
            res[i++] = nums[left--];
            if(i >= n)
                break;
            res[i++] = nums[right--];
        }   
        for(i=0;i<n;i++)
            nums[i] = res[i];
    }
}