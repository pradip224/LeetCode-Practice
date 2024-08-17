2843. Count Symmetric Integers
Solved
Easy
Topics
Companies
Hint
You are given two positive integers low and high.

An integer x consisting of 2 * n digits is symmetric if the sum of the first n digits of x is equal to the sum of the last n digits of x. Numbers with an odd number of digits are never symmetric.

Return the number of symmetric integers in the range [low, high].

 

Example 1:

Input: low = 1, high = 100
Output: 9
Explanation: There are 9 symmetric integers between 1 and 100: 11, 22, 33, 44, 55, 66, 77, 88, and 99.
Example 2:

Input: low = 1200, high = 1230
Output: 4
Explanation: There are 4 symmetric integers between 1200 and 1230: 1203, 1212, 1221, and 1230.
 

Constraints:

1 <= low <= high <= 104


class Solution {
    private static final short[] symCount = new short[10_001];
    
    
    public int countSymmetricIntegers(int low, int high) {
        if (symCount[11] == 0)  buildCounts();
        return symCount[high] - symCount[low - 1];
    }
    
    
    // One time build of the array of how many symmetric numbers 
    // exist at or below any index value.  After the first 
    // leetcode test case, this will not be called for the 
    // remainder of the submit test cases.  The values in 
    // symCount[] will be preserved between a submit's test cases.
    private void buildCounts() {
        // Fill in 0 to 99.
        for (int num = 11; num <= 99; num++)
            symCount[num] = (short)(num / 11);
        
        // Fill in 100 to 999.  No symmetric numbers in this range 
        // since odd number of digits, to just copy the count for 
        // symCount[99].
        short prev = symCount[99];
        for (int num = 100; num <= 999; num++)
            symCount[num] = prev;
        
        // Fill in 1000 to 9999
        prev = symCount[999];
        int idx = 1000;
        for (int high10 = 1; high10 <= 9; high10++) {
            for (int high1 = 0; high1 <= 9; high1++) {
                final int highSum = high10 + high1;
                for (int low10 = 0; low10 <= 9; low10++) 
                    for (int low1 = 0; low1 <= 9; low1++) 
                        symCount[idx++] = (short)((highSum == low10 + low1) ? ++prev : prev);
            }
        }
        
        // Fill in 10_000.
        symCount[10_000] = symCount[9999];
    }
}