693. Binary Number with Alternating Bits
Solved
Easy
Topics
Companies
Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.

 

Example 1:

Input: n = 5
Output: true
Explanation: The binary representation of 5 is: 101
Example 2:

Input: n = 7
Output: false
Explanation: The binary representation of 7 is: 111.
Example 3:

Input: n = 11
Output: false
Explanation: The binary representation of 11 is: 1011.
 

Constraints:

1 <= n <= 231 - 1


class Solution {
    public boolean hasAlternatingBits(int n) {
        while(n!=0)
        {
            int lastBit = n & 1;
            int secondLastBit = (n >> 1) & 1;
           if ((lastBit ^ secondLastBit) == 0)
           return false;
           n= n>>1;
        }
        return true;
    }
}