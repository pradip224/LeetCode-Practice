2264. Largest 3-Same-Digit Number in String
Easy
348
19
Companies
You are given a string num representing a large integer. An integer is good if it meets the following conditions:

It is a substring of num with length 3.
It consists of only one unique digit.
Return the maximum good integer as a string or an empty string "" if no such integer exists.

Note:

A substring is a contiguous sequence of characters within a string.
There may be leading zeroes in num or a good integer.
 

Example 1:

Input: num = "6777133339"
Output: "777"
Explanation: There are two distinct good integers: "777" and "333".
"777" is the largest, so we return "777".
Example 2:

Input: num = "2300019"
Output: "000"
Explanation: "000" is the only good integer.
Example 3:

Input: num = "42352338"
Output: ""
Explanation: No substring of length 3 consists of only one unique digit. Therefore, there are no good integers.
 

Constraints:

3 <= num.length <= 1000
num only consists of digits.

class Solution {
    public String largestGoodInteger(String num) {
        String largestGood = ""; // Initialize the result as an empty string
        
        for (int i = 0; i < num.length() - 2; i++) {
            // Check each substring of length 3
            String substring = num.substring(i, i + 3);
            if (isGoodInteger(substring) && substring.compareTo(largestGood) > 0) {
                largestGood = substring; // Update the largest good integer found
            }
        }
        
        return largestGood;
    }
    
    // Helper function to check if a string is a good integer
    private boolean isGoodInteger(String str) {
        return str.charAt(0) == str.charAt(1) && str.charAt(1) == str.charAt(2);
    }
}
