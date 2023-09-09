1678. Goal Parser Interpretation
Easy
1.4K
84
Companies
You own a Goal Parser that can interpret a string command. The command consists of an alphabet of "G", "()" and/or "(al)" in some order. The Goal Parser will interpret "G" as the string "G", "()" as the string "o", and "(al)" as the string "al". The interpreted strings are then concatenated in the original order.

Given the string command, return the Goal Parser's interpretation of command.

 

Example 1:

Input: command = "G()(al)"
Output: "Goal"
Explanation: The Goal Parser interprets the command as follows:
G -> G
() -> o
(al) -> al
The final concatenated result is "Goal".
Example 2:

Input: command = "G()()()()(al)"
Output: "Gooooal"
Example 3:

Input: command = "(al)G(al)()()G"
Output: "alGalooG"
 

Constraints:

1 <= command.length <= 100
command consists of "G", "()", and/or "(al)" in some order.


class Solution {
    public String interpret(String command) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        
        while (i < command.length()) {
            if (command.charAt(i) == 'G') {
                result.append('G');
                i++;
            } else if (command.startsWith("()", i)) {
                result.append('o');
                i += 2; // Skip over '()' characters
            } else if (command.startsWith("(al)", i)) {
                result.append("al");
                i += 4; // Skip over '(al)' characters
            }
        }  
        
        
        return result.toString();
    }
}
