
Additive Number
Medium
1K
747
Companies
An additive number is a string whose digits can form an additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

Given a string containing only digits, return true if it is an additive number or false otherwise.

Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

 

Example 1:

Input: "112358"
Output: true
Explanation: 
The digits can form an additive sequence: 1, 1, 2, 3, 5, 8. 
1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
Example 2:

Input: "199100199"
Output: true
Explanation: 
The additive sequence is: 1, 99, 100, 199. 
1 + 99 = 100, 99 + 100 = 199
 

Constraints:

1 <= num.length <= 35
num consists only of digits.





class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; Math.max(j, i) <= n - i - j; j++) {
                if (isAdditive(num, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean isAdditive(String num, int i, int j) {
        if (num.charAt(0) == '0' && i > 1) {
            return false; // Leading zeros are not allowed
        }
        if (num.charAt(i) == '0' && j > 1) {
            return false; // Leading zeros are not allowed
        }
        
        Long firstNum = Long.parseLong(num.substring(0, i));
        Long secondNum = Long.parseLong(num.substring(i, i + j));
        String remaining = num.substring(i + j);
        
        while (!remaining.isEmpty()) {
            Long sum = firstNum + secondNum;
            String sumStr = sum.toString();
            
            if (!remaining.startsWith(sumStr)) {
                return false; // Current sum does not match the remaining string
            }
            
            remaining = remaining.substring(sumStr.length());
            firstNum = secondNum;
            secondNum = sum;
        }
        
        return true; // All sums matched the remaining string
    }
}

