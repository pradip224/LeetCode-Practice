3216. Lexicographically Smallest String After a Swap
Solved
Easy
Topics
Companies
Hint
Given a string s containing only digits, return the 
lexicographically smallest string
 that can be obtained after swapping adjacent digits in s with the same parity at most once.

Digits have the same parity if both are odd or both are even. For example, 5 and 9, as well as 2 and 4, have the same parity, while 6 and 9 do not.

 

Example 1:

Input: s = "45320"

Output: "43520"

Explanation:

s[1] == '5' and s[2] == '3' both have the same parity, and swapping them results in the lexicographically smallest string.

Example 2:

Input: s = "001"

Output: "001"

Explanation:

There is no need to perform a swap because s is already the lexicographically smallest.

 

Constraints:

2 <= s.length <= 100
s consists only of digits.


class Solution {
    public String getSmallestString(String s) {
        int n = s.length();
        StringBuilder str = new StringBuilder(s);
        for(int i=0;i<n-1;i++){
            int a=Character.getNumericValue(str.charAt(i));
            int b=Character.getNumericValue(str.charAt(i+1));
            if((a%2==0 && b%2==0) || (a%2!=0 && b%2!=0)){
                if(a>b){
                    char c1 = str.charAt(i);
                    char c2 = str.charAt(i+1);
                    str.setCharAt(i,c2);
                    str.setCharAt(i+1,c1);
                    break;
                }
            }
        }
        return str.toString();
    }
}