Check if All Characters Have Equal Number of Occurrences
Easy
673
17
Companies
Given a string s, return true if s is a good string, or false otherwise.

A string s is good if all the characters that appear in s have the same number of occurrences (i.e., the same frequency).

 

Example 1:

Input: s = "abacbc"
Output: true
Explanation: The characters that appear in s are 'a', 'b', and 'c'. All characters occur 2 times in s.
Example 2:

Input: s = "aaabb"
Output: false
Explanation: The characters that appear in s are 'a' and 'b'.
'a' occurs 3 times while 'b' occurs 2 times, which is not the same number of times.
 

Constraints:

1 <= s.length <= 1000
s consists of lowercase English letters.




import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map = new HashMap<>();

        // Count the frequency of each character
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // If there is only one unique frequency, return true
        // if (map.size() == 1) {
        //     return true;
        // }

        // Check if all frequencies are equal
        Iterator<Integer> iter = map.values().iterator();
        int frequency = iter.next(); 
        for (int f : map.values()) {
            if(frequency != f){
                return false;
            }
        }

        return true;
    }
}


