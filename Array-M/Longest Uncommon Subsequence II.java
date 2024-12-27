522. Longest Uncommon Subsequence II
Solved
Medium
Topics
Companies
Given an array of strings strs, return the length of the longest uncommon subsequence between them. If the longest uncommon subsequence does not exist, return -1.

An uncommon subsequence between an array of strings is a string that is a subsequence of one string but not the others.

A subsequence of a string s is a string that can be obtained after deleting any number of characters from s.

For example, "abc" is a subsequence of "aebdc" because you can delete the underlined characters in "aebdc" to get "abc". Other subsequences of "aebdc" include "aebdc", "aeb", and "" (empty string).
 

Example 1:

Input: strs = ["aba","cdc","eae"]
Output: 3
Example 2:

Input: strs = ["aaa","aaa","aa"]
Output: -1
 

Constraints:

2 <= strs.length <= 50
1 <= strs[i].length <= 10
strs[i] consists of lowercase English letters.


class Solution {
    private boolean isSubsequence(String base, String subseq) {
        int i_base = 0;
        for (int i = 0 ; i < subseq.length() ; ++i) {
            while (i_base < base.length() && base.charAt(i_base) != subseq.charAt(i)) {
                ++i_base;
            }
            if (i_base == base.length()) {
                return false;
            }
            ++i_base;
        }
        return true;
    }
    
    public int findLUSlength(String[] strs) {
        int res = -1;
        for (int i = 0 ; i < strs.length ; ++i) {
            boolean broken = false;
            for (int j = 0 ; j < strs.length ; ++j) {
                if (i == j) continue;
                if (isSubsequence(strs[j], strs[i])) {
                    broken = true;
                    break;
                }
            }
            if (!broken) {
                res = Math.max(res, strs[i].length());
            }
        }
        return res;
    }
}
