Sort Colors
Medium
15K
534
Companies
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
 

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
 




class Solution {
    public void sortColors(int[] nums) {
        int low = 0;   // pointer for 0s (red)
        int mid = 0;   // pointer for 1s (white)
        int high = nums.length - 1;  // pointer for 2s (blue)

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap the element at mid with the element at low
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // No swapping needed, just move the mid pointer
                mid++;
            } else {
                // Swap the element at mid with the element at high
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}

