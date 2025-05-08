870. Advantage Shuffle
Solved
Medium
Topics
Companies
You are given two integer arrays nums1 and nums2 both of the same length. The advantage of nums1 with respect to nums2 is the number of indices i for which nums1[i] > nums2[i].

Return any permutation of nums1 that maximizes its advantage with respect to nums2.

 

Example 1:

Input: nums1 = [2,7,11,15], nums2 = [1,10,4,11]
Output: [2,11,7,15]
Example 2:

Input: nums1 = [12,24,8,32], nums2 = [13,25,32,11]
Output: [24,32,8,12]
 

Constraints:

1 <= nums1.length <= 105
nums2.length == nums1.length
0 <= nums1[i], nums2[i] <= 109


class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        // Max heap to store elements of nums2 along with their original indices
        // Sorted by value in descending order so we can try to beat the largest nums2 elements first
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        // Fill the priority queue with (value, index) pairs from nums2
        for (int i = 0; i < nums2.length; i++) {
            pq.offer(new int[]{nums2[i], i});
        }

        // Sort nums1 so we can pick the smallest or largest element greedily
        Arrays.sort(nums1);
        int l = 0; // Left pointer - points to the smallest available element in nums1
        int r = nums1.length - 1; // Right pointer - points to the largest available element in nums1

        int[] ans = new int[nums1.length]; // Result array to store the final permutation

        // Process nums2 values in decreasing order
        while (!pq.isEmpty()) {
            int[] curr = pq.poll(); // Get the largest unprocessed value from nums2
            int val = curr[0];      // Value of nums2
            int ind = curr[1];      // Original index of this value in nums2

            // If the largest available nums1 element can beat this nums2 element
            if (nums1[r] > val) {
                ans[ind] = nums1[r--]; // Use it and move the right pointer
            } else {
                // Otherwise, sacrifice the smallest available nums1 element
                ans[ind] = nums1[l++]; // Use it and move the left pointer
            }
        }

        return ans; // Return the final result
    }
}
