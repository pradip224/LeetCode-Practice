3120. Count the Number of Special Characters I
Solved
Easy
Topics
Companies
Hint
You are given a string word. A letter is called special if it appears both in lowercase and uppercase in word.

Return the number of special letters in word.

 

Example 1:

Input: word = "aaAbcBC"

Output: 3

Explanation:

The special characters in word are 'a', 'b', and 'c'.

Example 2:

Input: word = "abc"

Output: 0

Explanation:

No character in word appears in uppercase.

Example 3:

Input: word = "abBCab"

Output: 1

Explanation:

The only special character in word is 'b'.

 

Constraints:

1 <= word.length <= 50
word consists of only lowercase and uppercase English letters.


class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> smallSet = new HashSet<>();
        Set<Character> capitalSet = new HashSet<>();
        
        for (char c : word.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                smallSet.add(c);
            } else {
                capitalSet.add(c);
            }
        }
        
        int count = 0;
        for (char c : smallSet) {
            if (capitalSet.contains(Character.toUpperCase(c))) {
                count++;
            }
        }
        
        return count;
    }
}