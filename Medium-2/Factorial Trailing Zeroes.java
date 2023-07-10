
Factorial Trailing Zeroes
Medium
2.8K
1.9K
Companies
Given an integer n, return the number of trailing zeroes in n!.

Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.

 

Example 1:

Input: n = 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: n = 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Example 3:

Input: n = 0
Output: 0
 

Constraints:

0 <= n <= 104


class Solution {
    public int trailingZeroes(int n) {
        int countOf2 = 0;
        int countOf5 = 0;
        int temp = n;
        
        while (n >= 2) {
            countOf2 += n / 2;
            n /= 2;
        }

        n = temp;
        
        while (n >= 5) {
            countOf5 += n / 5;
            n /= 5;
        }
        
        return Math.min(countOf2, countOf5);
    }
}

