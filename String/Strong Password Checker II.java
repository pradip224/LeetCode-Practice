2299. Strong Password Checker II
Easy
316
38
Companies
A password is said to be strong if it satisfies all the following criteria:

It has at least 8 characters.
It contains at least one lowercase letter.
It contains at least one uppercase letter.
It contains at least one digit.
It contains at least one special character. The special characters are the characters in the following string: "!@#$%^&*()-+".
It does not contain 2 of the same character in adjacent positions (i.e., "aab" violates this condition, but "aba" does not).
Given a string password, return true if it is a strong password. Otherwise, return false.

 

Example 1:

Input: password = "IloveLe3tcode!"
Output: true
Explanation: The password meets all the requirements. Therefore, we return true.
Example 2:

Input: password = "Me+You--IsMyDream"
Output: false
Explanation: The password does not contain a digit and also contains 2 of the same character in adjacent positions. Therefore, we return false.
Example 3:

Input: password = "1aB!"
Output: false
Explanation: The password does not meet the length requirement. Therefore, we return false.
 

Constraints:

1 <= password.length <= 100
password consists of letters, digits, and special characters: "!@#$%^&*()-+".


class Solution {
    public boolean strongPasswordCheckerII(String password) {
           HashSet<Integer> intAscii = new HashSet<>();
        String specialCharacters = "!@#$%^&*()-+";
        for (int i = 0; i < specialCharacters.length(); i++) {
            int ascii = specialCharacters.charAt(i);
            intAscii.add(ascii);
        }
        
        if(password.length() < 8){
            return false;
        }
        boolean small = false;
        boolean large = false;
        boolean numbers = false;
        boolean specialChars = false;
        for(int i = 0 ; i < password.length() ; i++){
            int ascii = (int)(password.charAt(i));
            if(ascii <= 90 && ascii>=65){
                large = true;
            }
                if(ascii <= 122 && ascii>=97){
                small = true;
            }
            if(ascii <=57 && ascii >=48){
                numbers = true;
            }
            if(intAscii.contains(ascii)){
                specialChars = true;
            }
            if(i> 0 && password.charAt(i)== password.charAt(i-1)){
                return false;
            }
        }
        if(large == false || small == false || numbers == false || specialChars ==false){
            return false;
        }
        return true;
    }
}