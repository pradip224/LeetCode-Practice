
1318. Minimum Flips to Make a OR b Equal to c
Medium
1.8K
93
Companies
Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.

 

Example 1:



Input: a = 2, b = 6, c = 5
Output: 3
Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)
Example 2:

Input: a = 4, b = 2, c = 7
Output: 1
Example 3:

Input: a = 1, b = 2, c = 3
Output: 0
 

Constraints:

1 <= a <= 10^9
1 <= b <= 10^9
1 <= c <= 10^9


class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        
        // Iterate through each bit position (0 to 31) in the numbers a, b, and c
        for (int i = 0; i < 32; i++) {
            // Extract the i-th bit from a, b, and c
            int bitA = (a >> i) & 1; // i-th bit of a
            int bitB = (b >> i) & 1; // i-th bit of b
            int bitC = (c >> i) & 1; // i-th bit of c
            
            // Check if (bitA OR bitB) is equal to bitC
            if ((bitA | bitB) != bitC) {
                // If bitC is 0 and at least one of bitA or bitB is 1, we need to flip both to 0
                if (bitC == 0) {
                    flips += bitA + bitB; // Add the count of necessary flips to the total
                } else {
                    flips += 1; // If bitC is 1 and (bitA OR bitB) is 0, flip at least one bit to 1
                }
            }
        }
        
        return flips;
    }
}

