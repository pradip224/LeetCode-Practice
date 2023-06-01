
Subsets
Medium
14.5K
210
Companies
Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.






import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] nums, int start, List<Integer> subset, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset)); // Add the current subset to the result
        
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]); // Include the current element in the subset
            
            // Explore further to generate subsets with the current element included
            backtrack(nums, i + 1, subset, result);
            
            subset.remove(subset.size() - 1); // Remove the current element from the subset
        }

        
    }
}


