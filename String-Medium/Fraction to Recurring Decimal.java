
 Fraction to Recurring Decimal
Medium
1.9K
3.5K
Companies
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

If multiple answers are possible, return any of them.

It is guaranteed that the length of the answer string is less than 104 for all the given inputs.

 

Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:

Input: numerator = 2, denominator = 1
Output: "2"
Example 3:

Input: numerator = 4, denominator = 333
Output: "0.(012)"
 

Constraints:

-231 <= numerator, denominator <= 231 - 1
denominator != 0




class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // If numerator is zero, the fraction is zero
        if (numerator == 0) {
            return "0";
        }
        
        StringBuilder result = new StringBuilder();
        
        // Append the sign of the result
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }
        
        // Convert numerator and denominator to long to handle edge cases
        long num = Math.abs((long) numerator);
        long denom = Math.abs((long) denominator);
        
        // Append the integral part
        result.append(num / denom);
        
        // Check if there is a fractional part
        long remainder = num % denom;
        if (remainder == 0) {
            return result.toString();
        }
        
        // Append the decimal point
        result.append(".");
        
        // Map to store remainder and its position
        Map<Long, Integer> remainderMap = new HashMap<>();
        
        // Perform long division
        while (remainder != 0) {
            // If the remainder repeats, enclose the repeating part in parentheses
            if (remainderMap.containsKey(remainder)) {
                int index = remainderMap.get(remainder);
                result.insert(index, "(");
                result.append(")");
                break;
            }
            
            // Store the current remainder and its position
            remainderMap.put(remainder, result.length());
            
            // Multiply the remainder by 10 and append the quotient
            remainder *= 10;
            result.append(remainder / denom);
            
            // Update the remainder for the next iteration
            remainder %= denom;
        }
        
        return result.toString();
    }
}


