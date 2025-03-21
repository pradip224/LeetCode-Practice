809. Expressive Words
Solved
Medium
Topics
Companies
Sometimes people repeat letters to represent extra feeling. For example:

"hello" -> "heeellooo"
"hi" -> "hiiii"
In these strings like "heeellooo", we have groups of adjacent letters that are all the same: "h", "eee", "ll", "ooo".

You are given a string s and an array of query strings words. A query word is stretchy if it can be made to be equal to s by any number of applications of the following extension operation: choose a group consisting of characters c, and add some number of characters c to the group so that the size of the group is three or more.

For example, starting with "hello", we could do an extension on the group "o" to get "hellooo", but we cannot get "helloo" since the group "oo" has a size less than three. Also, we could do another extension like "ll" -> "lllll" to get "helllllooo". If s = "helllllooo", then the query word "hello" would be stretchy because of these two extension operations: query = "hello" -> "hellooo" -> "helllllooo" = s.
Return the number of query strings that are stretchy.

 

Example 1:

Input: s = "heeellooo", words = ["hello", "hi", "helo"]
Output: 1
Explanation: 
We can extend "e" and "o" in the word "hello" to get "heeellooo".
We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
Example 2:

Input: s = "zzzzzyyyyy", words = ["zzyy","zy","zyy"]
Output: 3
 

Constraints:

1 <= s.length, words.length <= 100
1 <= words[i].length <= 100
s and words[i] consist of lowercase letters.

class Solution {
    public int expressiveWords(final String s, final String[] words) {
        int count = 0;

        for(final String word : words)
            if(helper(s, word))
                count++;

        return count;
    }

    private boolean helper(final String s, final String word) {
        if(s.length() < word.length())
            return false;

        int i = 0, j = 0;

        while(i < s.length() && j < word.length()) {
            if(s.charAt(i) != word.charAt(j))
                return false;

            final char curr = word.charAt(j);
            int sCount = 0;

            while(i < s.length() && s.charAt(i) == curr) {
                sCount++;
                i++;
            }

            int wordCount = 0;

            while(j < word.length() && word.charAt(j) == curr) {
                wordCount++;
                j++;
            }

            if(sCount - wordCount < 0 || (sCount - wordCount != 0 && sCount < 3))
                return false;
        }

        return i >= s.length() && j >= word.length();
    }
}
