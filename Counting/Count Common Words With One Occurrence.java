
Count Common Words With One Occurrence
Easy
647
14
Companies
Given two string arrays words1 and words2, return the number of strings that appear exactly once in each of the two arrays.

 

Example 1:

Input: words1 = ["leetcode","is","amazing","as","is"], words2 = ["amazing","leetcode","is"]
Output: 2
Explanation:
- "leetcode" appears exactly once in each of the two arrays. We count this string.
- "amazing" appears exactly once in each of the two arrays. We count this string.
- "is" appears in each of the two arrays, but there are 2 occurrences of it in words1. We do not count this string.
- "as" appears once in words1, but does not appear in words2. We do not count this string.
Thus, there are 2 strings that appear exactly once in each of the two arrays.
Example 2:

Input: words1 = ["b","bb","bbb"], words2 = ["a","aa","aaa"]
Output: 0
Explanation: There are no strings that appear in each of the two arrays.
Example 3:

Input: words1 = ["a","ab"], words2 = ["a","a","a","ab"]
Output: 1
Explanation: The only string that appears exactly once in each of the two arrays is "ab".
 

Constraints:

1 <= words1.length, words2.length <= 1000
1 <= words1[i].length, words2[j].length <= 30
words1[i] and words2[j] consists only of lowercase English letters.






import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> words1Count = new HashMap<>();
        Map<String, Integer> words2Count = new HashMap<>();

        // Update word counts for words1
        for (String word : words1) {
            words1Count.put(word, words1Count.getOrDefault(word, 0) + 1);
        }

        // Update word counts for words2
        for (String word : words2) {
            words2Count.put(word, words2Count.getOrDefault(word, 0) + 1);
        }

        // Update word counts for words2 and check if the word appears exactly once in both arrays
        int count = 0;
        for (String word : words2) {
            Integer count1 = words1Count.get(word);
            Integer count2 = words2Count.get(word);
            if (count1 != null && count1 == 1 && count2 == 1) {
                count++;
            }
        }

        return count;
    }
}


