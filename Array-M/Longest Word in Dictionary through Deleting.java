524. Longest Word in Dictionary through Deleting
Solved
Medium
Topics
Companies
Given a string s and a string array dictionary, return the longest string in the dictionary that can be formed by deleting some of the given string characters. If there is more than one possible result, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

 

Example 1:

Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
Output: "apple"
Example 2:

Input: s = "abpcplea", dictionary = ["a","b","c"]
Output: "a"
 

Constraints:

1 <= s.length <= 1000
1 <= dictionary.length <= 1000
1 <= dictionary[i].length <= 1000
s and dictionary[i] consist of lowercase English letters.


class Solution {
    public String findLongestWord(String S, List<String> D) {
        String ans = "";
        for (String word : D) {
            int a = word.length(), b = ans.length();
            if (a < b || (a == b && word.compareTo(ans) > 0)) continue;
            int pos = -1;
            for (int i = 0; i < a; i++) {
                pos = S.indexOf(word.charAt(i), pos + 1);
                if (pos == -1) break;
            }
            if (pos != -1) ans = word;
        }
        return ans;
    }
}
