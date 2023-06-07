
Word Break
Medium
14.2K
591
Companies
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 

Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.




import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Create a set for faster word lookup
        Set<String> wordSet = new HashSet<>(wordDict);
        
        // Create a dynamic programming array to store the results
        boolean[] dp = new boolean[s.length() + 1];
        
        // Base case: an empty string can always be segmented
        dp[0] = true;
        
        // Iterate through the string and check if it can be segmented
        for (int i = 1; i <= s.length(); i++) {
            // Check all possible prefixes of the current substring
            for (int j = 0; j < i; j++) {
                // If the prefix can be segmented and the remaining suffix is in the word dictionary
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true; // Mark the current substring as segmented
                    break; // Move on to the next substring
                }
            }
        }
        
        // The last element in the dynamic programming array will indicate if the entire string can be segmented
        return dp[s.length()];
    }
}

