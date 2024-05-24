3090. Maximum Length Substring With Two Occurrences
Solved
Easy
Topics
Companies
Hint
Given a string s, return the maximum length of a 
substring
 such that it contains at most two occurrences of each character.
 

Example 1:

Input: s = "bcbbbcba"

Output: 4

Explanation:

The following substring has a length of 4 and contains at most two occurrences of each character: "bcbbbcba".
Example 2:

Input: s = "aaaa"

Output: 2

Explanation:

The following substring has a length of 2 and contains at most two occurrences of each character: "aaaa".
 

Constraints:

2 <= s.length <= 100
s consists only of lowercase English letters.


class Solution {

    public int maximumLengthSubstring(String s) {
        int maxLengthOfSubstring = 0;
        char[] occurrences = new char[26];

        for (int rightPoint = 0, leftPoint = 0; rightPoint < s.length(); rightPoint++) {
            char rightCharacter = s.charAt(rightPoint);
            occurrences[rightCharacter - 'a']++;

            if (occurrences[rightCharacter - 'a'] <= 2) {
                maxLengthOfSubstring = Math.max(maxLengthOfSubstring, rightPoint - leftPoint + 1);
                continue;
            }

            while (occurrences[rightCharacter - 'a'] > 2) {
                occurrences[s.charAt(leftPoint) - 'a']--;
                leftPoint++;
            }
        }

        return maxLengthOfSubstring;
    }
}