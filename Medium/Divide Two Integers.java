
Divide Two Integers
Medium
4.4K
13.6K
Companies
Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

Return the quotient after dividing dividend by divisor.

Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.

 

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = 3.33333.. which is truncated to 3.
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = -2.33333.. which is truncated to -2.
 

Constraints:

-231 <= dividend, divisor <= 231 - 1
divisor != 0






class Solution {
    public int divide(int dividend, int divisor) {
        // Handle division by zero
        // if (divisor == 0) {
        //     throw new ArithmeticException("Divisor cannot be zero");
        // }
        
        // Handle overflow case where dividend is the minimum value and divisor is -1
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        // Determine the sign of the quotient
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        
        // Convert dividend and divisor to positive values
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        
        // Initialize the quotient
        long quotient = 0;
        
        // Perform repeated subtraction until the dividend becomes smaller than the divisor
        while (absDividend >= absDivisor) {
            long powerOfTwo = 1;
            long multiple = absDivisor;
            
            // Find the largest multiple of the divisor that can be subtracted from the dividend
            while ((multiple << 1) <= absDividend) {
                multiple <<= 1;
                powerOfTwo <<= 1;
            }
            
            // Subtract the multiple from the dividend and update the quotient
            absDividend -= multiple;
            quotient += powerOfTwo;
        }
        
        // Apply the sign to the quotient
        int result = (int) (sign * quotient);
        return result;
    }
}
