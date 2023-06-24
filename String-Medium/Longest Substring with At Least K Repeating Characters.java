
 Longest Substring with At Least K Repeating Characters
Medium
5.5K
445
Companies
Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.

 

Example 1:

Input: s = "aaabb", k = 3
Output: 3
Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input: s = "ababbc", k = 2
Output: 5
Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 

Constraints:

1 <= s.length <= 104
s consists of only lowercase English letters.
1 <= k <= 105




class Solution {
    public int longestSubstring(String s, int k) {
        return longestSubstringHelper(s, k, 0, s.length() - 1);
    }
    
    private int longestSubstringHelper(String s, int k, int start, int end) {
        if (end - start + 1 < k) {
            return 0;  // Substring length is less than k, so it can't have a valid substring.
        }
        
        int[] charCounts = new int[26];  // Assuming lowercase English letters
        
        // Count the frequency of each character in the substring.
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            charCounts[c - 'a']++;
        }
        
        // Check if every character in the substring has a frequency greater than or equal to k.
        for (int i = 0; i < 26; i++) {
            if (charCounts[i] > 0 && charCounts[i] < k) {
                // Found a character with frequency less than k, so we split the substring at this character.
                char splitChar = (char) (i + 'a');
                int splitIndex = s.indexOf(splitChar, start);
                
                // Recursively find the longest substring in the left and right parts after the split.
                int left = longestSubstringHelper(s, k, start, splitIndex - 1);
                int right = longestSubstringHelper(s, k, splitIndex + 1, end);
                
                return Math.max(left, right);  // Return the maximum length of the two substrings.
            }
        }
        
        // All characters in the substring have a frequency greater than or equal to k.
        return end - start + 1;
    }
}
