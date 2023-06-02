

Search in Rotated Sorted Array II
Medium
6.2K
850
Companies
There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

You must decrease the overall operation steps as much as possible.

 

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
 

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
nums is guaranteed to be rotated at some pivot.
-104 <= target <= 104






class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0; // Initialize the left pointer to the start index of the array.
        int right = nums.length - 1; // Initialize the right pointer to the end index of the array.

        while (left <= right) { // Perform the following steps while the left pointer is less than or equal to the right pointer.
            int mid = (left + right) / 2; // Calculate the middle index.

            if (nums[mid] == target) { // Check if the middle element is equal to the target.
                return true; // If it is, return true as the target is found.
            }

            if (nums[left] < nums[mid]) { // Check if the left part of the array is sorted.
                if (target >= nums[left] && target < nums[mid]) { // Check if the target falls within the range of the left part.
                    right = mid - 1; // Update the right pointer to search in the left part.
                } 
                else {
                    left = mid + 1; // Update the left pointer to search in the right part.
                }
            } 
            else if (nums[left] > nums[mid]) { // Check if the right part of the array is sorted.
                if (target > nums[mid] && target <= nums[right]) { // Check if the target falls within the range of the right part.
                    left = mid + 1; // Update the left pointer to search in the right part.
                } 
                else {
                    right = mid - 1; // Update the right pointer to search in the left part.
                }
            } 
            else {
                left++; // If nums[left] and nums[mid] are equal, increment the left pointer.
            }
        }
        

        return false; // If the target is not found after the while loop, return false.
    }
}




