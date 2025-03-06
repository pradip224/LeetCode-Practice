740. Delete and Earn
Solved
Medium
Topics
Companies
Hint
You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:

Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
Return the maximum number of points you can earn by applying the above operation some number of times.

 

Example 1:

Input: nums = [3,4,2]
Output: 6
Explanation: You can perform the following operations:
- Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
- Delete 2 to earn 2 points. nums = [].
You earn a total of 6 points.
Example 2:

Input: nums = [2,2,3,3,3,4]
Output: 9
Explanation: You can perform the following operations:
- Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
- Delete a 3 again to earn 3 points. nums = [3].
- Delete a 3 once more to earn 3 points. nums = [].
You earn a total of 9 points.
 

Constraints:

1 <= nums.length <= 2 * 104
1 <= nums[i] <= 104


// Memorization

public class Solution {
    public int deleteAndEarn(int[] nums) {
        // Create a map to store the frequency of each number
        Map<Integer, Integer> sums = new HashMap<>();
        int maxNum = 0;

        // Calculate the total points for each value
        for (int num : nums) {
            sums.put(num, sums.getOrDefault(num, 0) + num);
            maxNum = Math.max(maxNum, num);
        }

        // Memoization map
        Map<Integer, Integer> memo = new HashMap<>();
        return dfs(maxNum, sums, memo);
    }

    // Recursive function with memoization
    private int dfs(int num, Map<Integer, Integer> sums, Map<Integer, Integer> memo) {
        if (num <= 0) return 0;

        // Check memoization cache
        if (memo.containsKey(num)) {
            return memo.get(num);
        }

        // Case 1: Skip current number
        int skip = dfs(num - 1, sums, memo);

        // Case 2: Take current number
        int take = sums.getOrDefault(num, 0) + (num - 1 >= 0 ? dfs(num - 2, sums, memo) : 0);

        // Get the maximum of taking or skipping the current number
        int result = Math.max(skip, take);

        // Store the result in the memoization map
        memo.put(num, result);

        return result;
    }
}
