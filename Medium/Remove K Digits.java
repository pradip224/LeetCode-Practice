 Remove K Digits
Medium
7.7K
328
Companies
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

 

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 

Constraints:

1 <= k <= num.length <= 105
num consists of only digits.
num does not have any leading zeros except for the zero itself.




class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        
        // Handle the case where k is equal to the length of num
        if (k == len) {
            return "0";
        }
        
        Stack<Character> stack = new Stack<>();
        
        // Iterate over each digit in num
        for (int i = 0; i < len; i++) {
            char digit = num.charAt(i);
            
            // Remove digits from the stack as long as there are digits remaining to remove (k > 0)
            while (k > 0 && !stack.isEmpty() && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            
            stack.push(digit);
        }
        
        // Remove any remaining digits to reach the desired length
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        // Construct the resulting number string
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        
        // Remove leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.delete(0, 1);
        }
        
        return sb.toString();
    }
}

