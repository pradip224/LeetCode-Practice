
Max Number of K-Sum Pairs
Medium
2.5K
53
Companies
You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.

 

Example 1:

Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.
Example 2:

Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109
1 <= k <= 109



import java.util.HashMap;

class Solution {
    public int maxOperations(int[] nums, int k) {
        int operations = 0;
        HashMap<Integer, Integer> numFreq = new HashMap<>();

        // Count the frequency of each number in the array
        for (int num : nums) {
            numFreq.put(num, numFreq.getOrDefault(num, 0) + 1);
        }

        // Loop through the array to find pairs that sum up to k
        for (int num : nums) {
            int complement = k - num;
            if (numFreq.containsKey(num) && numFreq.containsKey(complement)) {
                if (num == complement) {
                    // If the current number is the same as the complement, check if there are at least two occurrences of it
                    if (numFreq.get(num) >= 2) {
                        operations++;
                        numFreq.put(num, numFreq.get(num) - 2);
                    }
                } else {
                    // If the current number is different from the complement, check if both numbers have positive frequencies
                    if (numFreq.get(num) > 0 && numFreq.get(complement) > 0) {
                        operations++;
                        numFreq.put(num, numFreq.get(num) - 1);
                        numFreq.put(complement, numFreq.get(complement) - 1);
                    }
                }
            }
        }

        return operations;
    }
}
