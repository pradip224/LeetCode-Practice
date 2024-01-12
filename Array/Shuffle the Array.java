1470. Shuffle the Array
Solved
Easy
Topics
Companies
Hint
Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].

Return the array in the form [x1,y1,x2,y2,...,xn,yn].

 

Example 1:

Input: nums = [2,5,1,3,4,7], n = 3
Output: [2,3,5,4,1,7] 
Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
Example 2:

Input: nums = [1,2,3,4,4,3,2,1], n = 4
Output: [1,4,2,3,3,2,4,1]
Example 3:

Input: nums = [1,1,2,2], n = 2
Output: [1,2,1,2]
 

Constraints:

1 <= n <= 500
nums.length == 2n
1 <= nums[i] <= 10^3


class Solution {
    public int[] shuffle(int[] nums, int n) {
        for(int i = 0; i < n; i++) concat(nums, i, n + i);
        for(int i = n-1; i >= 0; i--) {
            int[] xy = getXandY(nums, i);
            nums[i * 2] = xy[0];
            nums[i * 2 + 1] = xy[1];
        }
        return nums;
    }

    private void concat(int[] nums, int index1, int index2) {
        nums[index1] = nums[index1] | (nums[index2] << 10);
    }

    private int[] getXandY(int[] nums, int index) {
        int[] delimited = new int[2];
        int mask = (1 << 10) - 1;
        delimited[0] = nums[index] & mask;
        delimited[1] = (nums[index] & (~mask)) >> 10;
        return delimited;
    }
}