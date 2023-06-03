 Subsets II
Medium
8.2K
232
Companies
Given an integer array nums that may contain duplicates, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10





import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to handle duplicates
        
        backtrack(nums, 0, new ArrayList<>(), result);
        
        return result;
    } 
    
    private void backtrack(int[] nums, int start, List<Integer> currentSubset, List<List<Integer>> result) {
        result.add(new ArrayList<>(currentSubset)); // Add the current subset to the result
        
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue; // Skip duplicates to avoid duplicate result
            }
            
            currentSubset.add(nums[i]);
            backtrack(nums, i + 1, currentSubset, result); // Recurse with the next index
            currentSubset.remove(currentSubset.size() - 1); // Backtrack by removing the last element
        }
    }
}

