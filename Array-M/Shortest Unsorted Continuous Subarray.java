581. Shortest Unsorted Continuous Subarray
Solved
Medium
Topics
Companies
Given an integer array nums, you need to find one continuous subarray such that if you only sort this subarray in non-decreasing order, then the whole array will be sorted in non-decreasing order.

Return the shortest such subarray and output its length.

 

Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Example 2:

Input: nums = [1,2,3,4]
Output: 0
Example 3:

Input: nums = [1]
Output: 0
 

Constraints:

1 <= nums.length <= 104
-105 <= nums[i] <= 105
 

Follow up: Can you solve it in O(n) time complexity?


class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        // startIdx, endIdx, value
        int start = -1, end = -1, val = Integer.MIN_VALUE;
        int pi = -1; // poll Index
        for(int i = 0; i < nums.length; i++){
            while(!stack.isEmpty() && nums[stack.peekLast()] > nums[i]){
                pi = stack.pollLast();
                // set the start to leftMost index which is not in order
                if(start == -1 || pi < start) start = pi;
                // find the maximum value of elements in stack (which are being polled)
                // reasoning : maximum element's index will be the rightmost after sorting 
                // (or) inserting in the right place
                val = Math.max(nums[pi], val);
            }
            // offer the current Index (this index is in correct position)
            stack.offer(i);
            // if maximum value can be inserted after current element(nums[i]) then that position will be current index + 1. 
            if(val > nums[i]) end = i + 1;
            // if it can't be inserted, then the element was already inserted previously. Now we can reset the value, hoping to catch another value if there are unordered elements in the future.
            else val = Integer.MIN_VALUE;
        }
        // finally return the length from the range observed
        return end - start;
    }
}
