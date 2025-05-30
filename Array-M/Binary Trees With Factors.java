823. Binary Trees With Factors
Solved
Medium
Topics
Companies
Given an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.

We make a binary tree using these integers, and each number may be used for any number of times. Each non-leaf node's value should be equal to the product of the values of its children.

Return the number of binary trees we can make. The answer may be too large so return the answer modulo 109 + 7.

 

Example 1:

Input: arr = [2,4]
Output: 3
Explanation: We can make these trees: [2], [4], [4, 2, 2]
Example 2:

Input: arr = [2,4,5,10]
Output: 7
Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 

Constraints:

1 <= arr.length <= 1000
2 <= arr[i] <= 109
All the values of arr are unique.


public class Solution {
    private static final int MOD = 1000000007;

    public int numFactoredBinaryTrees(int[] arr) {
        // Step 1: Sort the input array in ascending order.
        Arrays.sort(arr);
        
        // Create a set to make the containment check faster.
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int num : arr) {
            uniqueNumbers.add(num);
        }

        // Step 2: Initialize a map to store the number of binary trees that end with each element in the array.
        Map<Integer, Integer> dp = new HashMap<>();
        for (int num : arr) {
            dp.put(num, 1);
        }

        // Step 3: Dynamic Programming
        for (int i : arr) {
            for (int j : arr) {
                // If j is larger than the square root of i, break the loop because further j values won't be factors.
                if (j > Math.sqrt(i)) break;
                
                // Check if j is a factor of i and i/j is in the set of unique numbers.
                if (i % j == 0 && uniqueNumbers.contains(i / j)) {
                    long product = (long) dp.get(j) * dp.get(i / j);
                    
                    // Update the number of binary trees ending with i based on the factors j and i/j.
                    dp.put(i, (int) ((dp.get(i) + (i / j == j ? product : product * 2)) % MOD));
                }
            }
        }

        // Step 4: Calculate the final result.
        int result = 0;
        for (int value : dp.values()) {
            result = (result + value) % MOD;
        }
        return result;
    }
}
