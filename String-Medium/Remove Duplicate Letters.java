
Remove Duplicate Letters
Medium
6.9K
439
Companies
Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is 
the smallest in lexicographical order
 among all possible results.

 

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
 

Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.




import java.util.Stack;

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26]; // stores the frequency of each character
        boolean[] visited = new boolean[26]; // tracks if a character is already in the result string
        char[] chars = s.toCharArray();
        
        for (char c : chars) {
            count[c - 'a']++; // count the frequency of each character
        }
        
        Stack<Character> stack = new Stack<>();
        
        for (char c : chars) {
            count[c - 'a']--; // decrement the frequency of the character
            
            if (visited[c - 'a']) {
                continue; // character is already in the result string
            }
            
            // remove characters from the stack until a smaller character or the last occurrence of a character is found
            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false; // mark the removed character as not visited
            }
            
            stack.push(c); // add the current character to the stack
            visited[c - 'a'] = true; // mark the current character as visited
        }
        
        StringBuilder sb = new StringBuilder();
        
        // construct the result string by popping characters from the stack
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}
