1832. Check if the Sentence Is Pangram
Easy
2.5K
50
Companies
A pangram is a sentence where every letter of the English alphabet appears at least once.

Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.

 

Example 1:

Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.
Example 2:

Input: sentence = "leetcode"
Output: false
 

Constraints:

1 <= sentence.length <= 1000
sentence consists of lowercase English letters.


class Solution {
    public boolean checkIfPangram(String sentence) {
        // Create a boolean array to track the presence of each letter
        boolean[] alphabet = new boolean[26];
        
        // Iterate through the characters in the sentence
        for (char c : sentence.toCharArray()) {
            // Mark the corresponding index as true
            alphabet[c - 'a'] = true;
        }
        
        // Check if all elements in the array are true
        for (boolean letterPresent : alphabet) {
            if (!letterPresent) {
                // If any letter is missing, return false
                return false;
            }
        }
        
        // If all letters are present, return true
        return true;
    }
}
