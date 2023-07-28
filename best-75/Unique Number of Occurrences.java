
 Unique Number of Occurrences
Easy
3.9K
89
Companies
Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.

 

Example 1:

Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
Example 2:

Input: arr = [1,2]
Output: false
Example 3:

Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true
 

Constraints:

1 <= arr.length <= 1000
-1000 <= arr[i] <= 1000


import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // Create a HashMap to store the frequency of each element
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each element in the array
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Create a HashSet to store the occurrence counts
        HashSet<Integer> occurrencesSet = new HashSet<>();

        // Check if any count is repeated, if yes return false, otherwise add it to the set
        for (int count : frequencyMap.values()) {
            if (occurrencesSet.contains(count)) {
                return false;
            }
            occurrencesSet.add(count);
        }

        return true;
    }
}


