1957. Delete Characters to Make Fancy String
Easy
395
21
Companies
A fancy string is a string where no three consecutive characters are equal.

Given a string s, delete the minimum possible number of characters from s to make it fancy.

Return the final string after the deletion. It can be shown that the answer will always be unique.

 

Example 1:

Input: s = "leeetcode"
Output: "leetcode"
Explanation:
Remove an 'e' from the first group of 'e's to create "leetcode".
No three consecutive characters are equal, so return "leetcode".
Example 2:

Input: s = "aaabaaaa"
Output: "aabaa"
Explanation:
Remove an 'a' from the first group of 'a's to create "aabaaaa".
Remove two 'a's from the second group of 'a's to create "aabaa".
No three consecutive characters are equal, so return "aabaa".
Example 3:

Input: s = "aab"
Output: "aab"
Explanation: No three consecutive characters are equal, so return "aab".
 

Constraints:

1 <= s.length <= 105
s consists only of lowercase English letters.


class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        int count = 1; // Initialize the count to 1 for the first character
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++; // Increment the count if the current character is the same as the previous one
            } else {
                count = 1; // Reset the count if the current character is different
            }
            
            if (count < 3) {
                result.append(s.charAt(i - 1)); // Append the character to the result if count is less than 3
            }
        }
        
        // Append the last character of the string
        result.append(s.charAt(s.length() - 1));
        
        return result.toString();
    }
}
