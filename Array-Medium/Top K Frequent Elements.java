Top K Frequent Elements
Medium
13.9K
501
Companies
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.




import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Count the frequency of each number using a HashMap
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Create a min heap (PriorityQueue) based on the frequencies
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(frequencyMap::get));
        
        // Iterate through the frequency map
        for (int num : frequencyMap.keySet()) {
            minHeap.offer(num); // Add the number to the min heap
            
            // If the size of the min heap exceeds k, remove the element with the minimum frequency
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        // Build the result array from the min heap
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }
        
        return result;
    }
}

