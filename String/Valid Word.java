3136. Valid Word
Solved
Easy
Topics
Companies
Hint
A word is considered valid if:

It contains a minimum of 3 characters.
It contains only digits (0-9), and English letters (uppercase and lowercase).
It includes at least one vowel.
It includes at least one consonant.
You are given a string word.

Return true if word is valid, otherwise, return false.

Notes:

'a', 'e', 'i', 'o', 'u', and their uppercases are vowels.
A consonant is an English letter that is not a vowel.
 

Example 1:

Input: word = "234Adas"

Output: true

Explanation:

This word satisfies the conditions.

Example 2:

Input: word = "b3"

Output: false

Explanation:

The length of this word is fewer than 3, and does not have a vowel.

Example 3:

Input: word = "a3$e"

Output: false

Explanation:

This word contains a '$' character and does not have a consonant.

 

Constraints:

1 <= word.length <= 20
word consists of English uppercase and lowercase letters, digits, '@', '#', and '$'.


class Solution {
    public boolean isValid(String word) {
        if(word.length()<3) return false;
        boolean ans = false;
        
        for(int i=0;i<word.length();i++){
            char val = word.charAt(i);

            if(val<='9'&&val>='0'){ans=true;}
            else if(val<='z'&&val>='a'){ans=true;}
            else if(val<='Z'&&val>='A'){ans=true;}
            else return false;
            
        }
        
        if(ans == false)    return ans;
        
        String data = "aeiouAEIOU";
        boolean ans1 = false;
        boolean ans2 = false;
        
        for(int i=0;i<word.length();i++){
            char val = word.charAt(i);
            if(data.contains(String.valueOf(val))){ans1=true;}
            else if((val<='z'&&val>='a') || (val<='Z'&&val>='A')) ans2 = true;
            
        }
        
        return ans1&ans2;
    }
}