

Maximum Product of Word Lengths
Medium
3.3K
133
Companies
Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. If no such two words exist, return 0.

 

Example 1:

Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16
Explanation: The two words can be "abcw", "xtfn".
Example 2:

Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4
Explanation: The two words can be "ab", "cd".
Example 3:

Input: words = ["a","aa","aaa","aaaa"]
Output: 0
Explanation: No such pair of words.
 

Constraints:

2 <= words.length <= 1000
1 <= words[i].length <= 1000
words[i] consists only of lowercase English letters.



class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] bitmasks = new int[n];

        // Generate bitmasks for each word
        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                // Set the corresponding bit for each letter
                bitmasks[i] |= 1 << (c - 'a');
            }
        }

        int maxProduct = 0;

        // Compare each pair of words
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Check if the words have any common letters
                if ((bitmasks[i] & bitmasks[j]) == 0) {
                    int product = words[i].length() * words[j].length();
                    maxProduct = Math.max(maxProduct, product);
                }
            }
        }

        return maxProduct;
    }
}
