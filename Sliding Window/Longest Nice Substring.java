
Longest Nice Substring
A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase. For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b' appears, but 'B' does not.

Given a string s, return the longest substring of s that is nice. If there are multiple, return the substring of the earliest occurrence. If there are none, return an empty string.
Example 1:

Input: s = "YazaAay"
Output: "aAa"
Explanation: "aAa" is a nice string because 'A/a' is the only letter of the alphabet in s, and both 'A' and 'a' appear.
"aAa" is the longest nice substring.
Example 2:

Input: s = "Bb"
Output: "Bb"
Explanation: "Bb" is a nice string because both 'B' and 'b' appear. The whole string is a substring.
Example 3:

Input: s = "c"
Output: ""
Explanation: There are no nice substrings.
 

Constraints:

1 <= s.length <= 100
s consists of uppercase and lowercase English letters.



class Solution {
    public String longestNiceSubstring(String s) {
        // If input string is less than 2 characters long, there can be no nice substring
        if (s.length() < 2) return "";
        
        // Create a set containing all characters in the input string
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c: arr) set.add(c);
        
        // Iterate over the characters in the input string
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            
            // If the current character have both uppercase and lowercase versions, then continue the loop and check for the next character in the current string
            if (set.contains(Character.toUpperCase(c)) && set.contains(Character.toLowerCase(c))) continue;
            
            // Recursively call the function on the substrings before and after the non-nice character
            String sub1 = longestNiceSubstring(s.substring(0, i));
            String sub2 = longestNiceSubstring(s.substring(i+1));
            
            // Return the longer nice substring found in the two substrings
            return sub1.length() >= sub2.length() ? sub1 : sub2;
        }
        
        // If we reach here, the entire input string is a nice substring
        return s; 
    }
}


