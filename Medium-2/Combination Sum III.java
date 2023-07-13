
Combination Sum III
Medium
5.2K
100
Companies
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

 

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
Example 3:

Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
 

Constraints:

2 <= k <= 9
1 <= n <= 60


import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(combinations, new ArrayList<>(), k, n, 1);
        return combinations;
    }
    
    private void backtrack(List<List<Integer>> combinations, List<Integer> currentCombination, int k, int remainingSum, int startNum) {
        if (currentCombination.size() == k && remainingSum == 0) {
            combinations.add(new ArrayList<>(currentCombination));
            return;
        }
        
        for (int i = startNum; i <= 9; i++) {
            if (remainingSum - i < 0) {
                break;
            }
            
            currentCombination.add(i);
            backtrack(combinations, currentCombination, k, remainingSum - i, i + 1);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}


