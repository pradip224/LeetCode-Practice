1784. Check if Binary String Has at Most One Segment of Ones
Easy

Companies
Given a binary string s ​​​​​without leading zeros, return true​​​ if s contains at most one contiguous segment of ones. Otherwise, return false.

 
 
Example 1:

Input: s = "1001"
Output: false
Explanation: The ones do not form a contiguous segment.
Example 2:

Input: s = "110"
Output: true
 

Constraints:

1 <= s.length <= 100
s[i]​​​​ is either '0' or '1'.
s[0] is '1'.


class Solution {
    public boolean checkOnesSegment(String s) {
        int countSegments = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                // If this is the first '1' in the segment, increment countSegments.
                if (i == 0 || s.charAt(i - 1) != '1') {
                    countSegments++;
                }
            }
        }
        
        // If there is only one contiguous segment of ones, return true.
        return countSegments == 1;
    }
}
