405. Convert a Number to Hexadecimal
Solved
Easy
Topics
Companies
Given an integer num, return a string representing its hexadecimal representation. For negative integers, two’s complement method is used.

All the letters in the answer string should be lowercase characters, and there should not be any leading zeros in the answer except for the zero itself.

Note: You are not allowed to use any built-in library method to directly solve this problem.

 

Example 1:

Input: num = 26
Output: "1a"
Example 2:

Input: num = -1
Output: "ffffffff"
 

Constraints:

-231 <= num <= 231 - 1


class Solution {
    public String toHex(int num) {
        if(num == 0){
            return "0";
        }
        long val = num;
        if(num < 0){
            val = (long) (Math.pow(2,32) + num);
        }
        
        StringBuilder res = new StringBuilder();
        while (val != 0){
            int remainder = (int) (val - (((int) (val / 16)) * 16));
            val = val /16;
            if(remainder >= 10){
                res.append((char) (remainder + 87));
            }else {
                res.append(remainder);
            }
        }

        return res.reverse().toString();
    }
}