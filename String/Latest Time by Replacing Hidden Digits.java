1736. Latest Time by Replacing Hidden Digits
Easy
323
173
Companies
You are given a string time in the form of  hh:mm, where some of the digits in the string are hidden (represented by ?).

The valid times are those inclusively between 00:00 and 23:59.

Return the latest valid time you can get from time by replacing the hidden digits.

 

Example 1:

Input: time = "2?:?0"
Output: "23:50"
Explanation: The latest hour beginning with the digit '2' is 23 and the latest minute ending with the digit '0' is 50.
Example 2:

Input: time = "0?:3?"
Output: "09:39"
Example 3:

Input: time = "1?:22"
Output: "19:22"
 

Constraints:

time is in the format hh:mm.
It is guaranteed that you can produce a valid time from the given string.


class Solution {
    public String maximumTime(String time) {
         if (time.charAt(0) == '?') {
            if (time.charAt(1) != '?' && time.charAt(1) - '0' > 3) {
                time = time.substring(0, 0) + '1' + time.substring(1);
            } else {
                time = time.substring(0, 0) + '2' + time.substring(1);
            }
        }
        if (time.charAt(1) == '?') {
            if (time.charAt(0) == '1' || time.charAt(0) == '0') {
                time = time.substring(0, 1) + '9' + time.substring(2);
            } else {
                time = time.substring(0, 1) + '3' + time.substring(2);
            }
        }
        if (time.charAt(3) == '?') {
            time = time.substring(0, 3) + '5' + time.substring(4);
        }
        if (time.charAt(4) == '?') {
            time = time.substring(0, 4) + '9';
        }
        return time;
    }
}