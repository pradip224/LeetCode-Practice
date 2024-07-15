1837. Sum of Digits in Base K
Solved
Easy
Topics
Companies
Hint
Given an integer n (in base 10) and a base k, return the sum of the digits of n after converting n from base 10 to base k.

After converting, each digit should be interpreted as a base 10 number, and the sum should be returned in base 10.

 

Example 1:

Input: n = 34, k = 6
Output: 9
Explanation: 34 (base 10) expressed in base 6 is 54. 5 + 4 = 9.
Example 2:

Input: n = 10, k = 10
Output: 1
Explanation: n is already in base 10. 1 + 0 = 1.
 

Constraints:

1 <= n <= 100
2 <= k <= 10


class Solution {
    public int sumBase(int n, int k) {
        String digit = convertToBase(n, k);
        int num = 0;
        for (int i = 0; i < digit.length(); i++) {
            num += digit.charAt(i) - '0';
        }
        return num;
    }

    private static String convertToBase(int n, int k) {
        StringBuilder ans = new StringBuilder();
        while (n > 0) {
            ans.append(n % k);
            n = n / k;
        }
        return ans.reverse().toString();
    }
}