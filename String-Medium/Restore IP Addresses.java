Restore IP Addresses
Medium
4.7K
749
Companies
A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.

For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.

 

Example 1:

Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]
Example 2:

Input: s = "0000"
Output: ["0.0.0.0"]
Example 3:

Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 

Constraints:

1 <= s.length <= 20
s consists of digits only.






import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String s, int index, int segments, StringBuilder current, List<String> result) {
        if (segments == 4 && index == s.length()) {
            result.add(current.toString());
            return;
        }


        for (int i = 1; i <= 3 && index + i <= s.length(); i++) {
            String segment = s.substring(index, index + i);
            if (isValidSegment(segment)) {
                int length = current.length();
                if (segments < 3) {
                    current.append(segment).append(".");
                } else {
                    current.append(segment);
                }
                backtrack(s, index + i, segments + 1, current, result);
                current.setLength(length); // backtrack by removing the last segment
            }
        }
    }

    private boolean isValidSegment(String segment) {
        if (segment.length() > 3 || segment.isEmpty() || (segment.charAt(0) == '0' && segment.length() > 1) || Integer.parseInt(segment) > 255) {
            return false;
        }
        return true;
    }
}

