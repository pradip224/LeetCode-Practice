
Longest Palindromic Substring
Medium
25.5K
1.5K
Companies
Given a string s, return the longest 
palindromic
 
substring
 in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.





class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        // Every single character is a palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        
        int maxLength = 1;  // Length of the longest palindromic substring
        int start = 0;     // Starting index of the longest palindromic substring
        
        // Check for palindromes of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLength = 2;
                start = i;
            }
        }
        
        // Check for palindromes of length greater than 2
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    
                    if (len > maxLength) {
                        maxLength = len;
                        start = i;
                    }
                }
            }
        }
        
        return s.substring(start, start + maxLength);
    }
}

