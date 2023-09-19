1805. Number of Different Integers in a String
Easy
563
88
Companies
You are given a string word that consists of digits and lowercase English letters.

You will replace every non-digit character with a space. For example, "a123bc34d8ef34" will become " 123  34 8  34". Notice that you are left with some integers that are separated by at least one space: "123", "34", "8", and "34".

Return the number of different integers after performing the replacement operations on word.

Two integers are considered different if their decimal representations without any leading zeros are different.

 

Example 1:

Input: word = "a123bc34d8ef34"
Output: 3
Explanation: The three different integers are "123", "34", and "8". Notice that "34" is only counted once.
Example 2:

Input: word = "leet1234code234"
Output: 2
Example 3:

Input: word = "a1b01c001"
Output: 1
Explanation: The three integers "1", "01", and "001" all represent the same integer because
the leading zeros are ignored when comparing their decimal values.
 

Constraints:

1 <= word.length <= 1000
word consists of digits and lowercase English letters.


import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numDifferentIntegers(String word) {
        Set<String> uniqueIntegers = new HashSet<>();
        StringBuilder currentInteger = new StringBuilder();

        for (char c : word.toCharArray()) {
            if (Character.isDigit(c)) {
                currentInteger.append(c);
            } else {
                if (currentInteger.length() > 0) {
                    // Remove leading zeros and add to the set
                    while (currentInteger.length() > 1 && currentInteger.charAt(0) == '0') {
                        currentInteger.deleteCharAt(0);
                    }
                    uniqueIntegers.add(currentInteger.toString());
                    currentInteger.setLength(0); // Reset the currentInteger
                }
            }
        }

        // Add the last integer if it exists
        if (currentInteger.length() > 0) {
            while (currentInteger.length() > 1 && currentInteger.charAt(0) == '0') {
                currentInteger.deleteCharAt(0);
            }
            uniqueIntegers.add(currentInteger.toString());
        }

        return uniqueIntegers.size();
    }
}
