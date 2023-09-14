1758. Minimum Changes To Make Alternating Binary String
Easy
566
19
Companies
You are given a string s consisting only of the characters '0' and '1'. In one operation, you can change any '0' to '1' or vice versa.

The string is called alternating if no two adjacent characters are equal. For example, the string "010" is alternating, while the string "0100" is not.

Return the minimum number of operations needed to make s alternating.

 

Example 1:

Input: s = "0100"
Output: 1
Explanation: If you change the last character to '1', s will be "0101", which is alternating.
Example 2:

Input: s = "10"
Output: 0
Explanation: s is already alternating.
Example 3:

Input: s = "1111"
Output: 2
Explanation: You need two operations to reach "0101" or "1010".
 

Constraints:

1 <= s.length <= 104
s[i] is either '0' or '1'.


class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int operationsToMake0 = 0; // Operations needed to make the first character '0'
        int operationsToMake1 = 0; // Operations needed to make the first character '1'

        // Iterate through the string and count operations
        for (int i = 0; i < n; i++) {
            char expected0 = (i % 2 == 0) ? '0' : '1'; // Expected character for even positions
            char expected1 = (i % 2 == 0) ? '1' : '0'; // Expected character for odd positions
            
            if (s.charAt(i) != expected0) {
                operationsToMake0++;
            }
            if (s.charAt(i) != expected1) {
                operationsToMake1++;
            }
        }

        // Return the minimum of operationsToMake0 and operationsToMake1
        return Math.min(operationsToMake0, operationsToMake1);
    }
}
