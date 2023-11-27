2710. Remove Trailing Zeros From a String
Easy
264
8
Companies
Given a positive integer num represented as a string, return the integer num without trailing zeros as a string.

 

Example 1:

Input: num = "51230100"
Output: "512301"
Explanation: Integer "51230100" has 2 trailing zeros, we remove them and return integer "512301".
Example 2:

Input: num = "123"
Output: "123"
Explanation: Integer "123" has no trailing zeros, we return integer "123".
 

Constraints:

1 <= num.length <= 1000
num consists of only digits.
num doesn't have any leading zeros.


class Solution {
    public String removeTrailingZeros(String num) {
        int n = num.length();
        
        // Find the index of the last non-zero digit
        int lastIndex = n - 1;
        while (lastIndex >= 0 && num.charAt(lastIndex) == '0') {
            lastIndex--;
        }
        
        // If all digits are zero, return "0"
        if (lastIndex == -1) {
            return "0";
        }
        
        // Extract the substring without trailing zeros
        return num.substring(0, lastIndex + 1);
    }
}
