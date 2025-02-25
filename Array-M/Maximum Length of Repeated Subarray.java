718. Maximum Length of Repeated Subarray
Solved
Medium
Topics
Companies
Hint
Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.

 

Example 1:

Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
Output: 3
Explanation: The repeated subarray with maximum length is [3,2,1].
Example 2:

Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
Output: 5
Explanation: The repeated subarray with maximum length is [0,0,0,0,0].
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 100


class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, dp[][] = new int[m+1][n+1], max = Integer.MIN_VALUE;
        
        for(int i=0; i<=m; i++) {
            dp[i][0] = 0;
        }

        for(int j=0; j<=n; j++) {
            dp[0][j] = 0;
        }

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = 0;
                }

                max = Math.max(dp[i][j], max);
            }
        }

        return max;
    }
}
