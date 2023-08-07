2542. Maximum Subsequence Score
Medium
2.2K
102
Companies
You are given two 0-indexed integer arrays nums1 and nums2 of equal length n and a positive integer k. You must choose a subsequence of indices from nums1 of length k.

For chosen indices i0, i1, ..., ik - 1, your score is defined as:

The sum of the selected elements from nums1 multiplied with the minimum of the selected elements from nums2.
It can defined simply as: (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]).
Return the maximum possible score.

A subsequence of indices of an array is a set that can be derived from the set {0, 1, ..., n-1} by deleting some or no elements.

 

Example 1:

Input: nums1 = [1,3,3,2], nums2 = [2,1,3,4], k = 3
Output: 12
Explanation: 
The four possible subsequence scores are:
- We choose the indices 0, 1, and 2 with score = (1+3+3) * min(2,1,3) = 7.
- We choose the indices 0, 1, and 3 with score = (1+3+2) * min(2,1,4) = 6. 
- We choose the indices 0, 2, and 3 with score = (1+3+2) * min(2,3,4) = 12. 
- We choose the indices 1, 2, and 3 with score = (3+3+2) * min(1,3,4) = 8.
Therefore, we return the max score, which is 12.
Example 2:

Input: nums1 = [4,2,3,1,1], nums2 = [7,5,10,9,6], k = 1
Output: 30
Explanation: 
Choosing index 2 is optimal: nums1[2] * nums2[2] = 3 * 10 = 30 is the maximum possible score.
 

Constraints:

n == nums1.length == nums2.length
1 <= n <= 105
0 <= nums1[i], nums2[j] <= 105
1 <= k <= n


class Solution {
    public long maxScore(int[] speed, int[] efficiency, int k) {
        int n = speed.length;
        
        // Create a 2D array 'ess' to store efficiency and speed pairs
        int[][] ess = new int[n][2];
        for (int i = 0; i < n; ++i)
            ess[i] = new int[] {efficiency[i], speed[i]};
        
        // Sort the 'ess' array based on efficiency in descending order
        Arrays.sort(ess, (a, b) -> b[0] - a[0]);
        
        // Create a priority queue 'pq' to store 'k' fastest speeds
        // Use a min-heap comparator to keep the smallest elements at the front
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
        
        long res = 0; // Initialize the result
        long sumS = 0; // Initialize the sum of speeds
        
        // Iterate through each pair of efficiency and speed in 'ess'
        for (int[] es : ess) {
            pq.add(es[1]); // Add speed to the priority queue
            sumS += es[1]; // Update the sum of speeds
            
            // If the size of the priority queue exceeds 'k', remove the smallest speed
            if (pq.size() > k)
                sumS -= pq.poll();
            
            // If the size of the priority queue reaches 'k', calculate the current score
            if (pq.size() == k)
                res = Math.max(res, (sumS * es[0]));
        }
        
        return res; // Return the maximum score
    }
}

