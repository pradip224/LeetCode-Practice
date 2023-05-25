
Permutations II
Medium
7.5K
131
Companies
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10





import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to handle duplicates
        
        boolean[] used = new boolean[nums.length];
        List<Integer> currentPermutation = new ArrayList<>();
        backtrack(nums, used, currentPermutation, result);
        
        return result;
    }
    
    private void backtrack(int[] nums, boolean[] used, List<Integer> currentPermutation, List<List<Integer>> result) {
        if (currentPermutation.size() == nums.length) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // Skip duplicates or already used numbers
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]))
                continue;
            
            used[i] = true;
            currentPermutation.add(nums[i]);
            backtrack(nums, used, currentPermutation, result);
            currentPermutation.remove(currentPermutation.size() - 1);
            used[i] = false;
        }
    }
}



