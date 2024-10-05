2595. Number of Even and Odd Bits
Solved
Easy
Topics
Companies
Hint
You are given a positive integer n.

Let even denote the number of even indices in the binary representation of n with value 1.

Let odd denote the number of odd indices in the binary representation of n with value 1.

Note that bits are indexed from right to left in the binary representation of a number.

Return the array [even, odd].

 

Example 1:

Input: n = 50

Output: [1,2]

Explanation:

The binary representation of 50 is 110010.

It contains 1 on indices 1, 4, and 5.

Example 2:

Input: n = 2

Output: [0,1]

Explanation:

The binary representation of 2 is 10.

It contains 1 only on index 1.

 

Constraints:

1 <= n <= 1000


class Solution {
    public int[] evenOddBit(int n) {
        int[] res=new int[2];
        for(int i=0;i<32;i++){
        if ((n & (1 << i)) != 0) {
            if(i%2==0) res[0]+=1;
            else res[1]+=1;
            }
        }
        return res;
    }
}