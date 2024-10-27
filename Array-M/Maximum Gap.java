164. Maximum Gap
Solved
Medium
Topics
Companies
Given an integer array nums, return the maximum difference between two successive elements in its sorted form. If the array contains less than two elements, return 0.

You must write an algorithm that runs in linear time and uses linear extra space.

 

Example 1:

Input: nums = [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9) has the maximum difference 3.
Example 2:

Input: nums = [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 109


class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;

        int hi = 0, lo = Integer.MAX_VALUE, ans = 0;
        for (int n : nums) {
            hi = Math.max(hi, n);
            lo = Math.min(lo, n);
        }

        int bsize = Math.max(1, (hi - lo) / (nums.length - 1));
        int numBuckets = (hi - lo) / bsize + 1;
        List<List<Integer>> buckets = new ArrayList<>(numBuckets);
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int n : nums) {
            int idx = (n - lo) / bsize;
            buckets.get(idx).add(n);
        }

        int currhi = 0;
        for (List<Integer> b : buckets) {
            if (b.isEmpty()) continue;
            int prevhi = currhi != 0 ? currhi : b.get(0), currlo = b.get(0);

            for (int n : b) {
                currhi = Math.max(currhi, n);
                currlo = Math.min(currlo, n);
            }

            ans = Math.max(ans, currlo - prevhi);
        }

        return ans;
    }
}