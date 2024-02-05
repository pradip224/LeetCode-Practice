2099. Find Subsequence of Length K With the Largest Sum
Solved
Easy
Topics
Companies
Hint
You are given an integer array nums and an integer k. You want to find a subsequence of nums of length k that has the largest sum.

Return any such subsequence as an integer array of length k.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: nums = [2,1,3,3], k = 2
Output: [3,3]
Explanation:
The subsequence has the largest sum of 3 + 3 = 6.
Example 2:

Input: nums = [-1,-2,3,4], k = 3
Output: [-1,3,4]
Explanation: 
The subsequence has the largest sum of -1 + 3 + 4 = 6.
Example 3:

Input: nums = [3,4,3,3], k = 2
Output: [3,4]
Explanation:
The subsequence has the largest sum of 3 + 4 = 7. 
Another possible subsequence is [4, 3].
 

Constraints:

1 <= nums.length <= 1000
-105 <= nums[i] <= 105
1 <= k <= nums.length


class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int temp[] = new int[nums.length];
        for (int i =0 ;i<nums.length;i++){ temp[i]=nums[i];}
        int res[] = new int[k];
        Arrays.sort(temp);
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = temp.length - 1; i>=nums.length-k ; i--) {
            if (hm.containsKey(temp[i])) {
                hm.put(temp[i], hm.get(temp[i]) + 1);
            } else {
                hm.put(temp[i], 1);
            }
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (j == k) {
                break;
            }
            if (hm.containsKey(nums[i])) {
                if (hm.get(nums[i]) == 1) {
                    hm.remove(nums[i]);
                } else {
                    hm.put(nums[i], hm.get(nums[i]) - 1);
                }
                res[j] = nums[i];
                j++;
            }
        }
        return res;
    }
}