1317. Convert Integer to the Sum of Two No-Zero Integers
Solved
Easy
Topics
Companies
Hint
No-Zero integer is a positive integer that does not contain any 0 in its decimal representation.

Given an integer n, return a list of two integers [a, b] where:

a and b are No-Zero integers.
a + b = n
The test cases are generated so that there is at least one valid solution. If there are many valid solutions, you can return any of them.

 

Example 1:

Input: n = 2
Output: [1,1]
Explanation: Let a = 1 and b = 1.
Both a and b are no-zero integers, and a + b = 2 = n.
Example 2:

Input: n = 11
Output: [2,9]
Explanation: Let a = 2 and b = 9.
Both a and b are no-zero integers, and a + b = 9 = n.
Note that there are other valid answers as [8, 3] that can be accepted.
 

Constraints:

2 <= n <= 104


class Solution {
    // I used this function to check whether n1 and n2 are No-Zero integer or not. 
    public boolean isContainzero(int num1, int num2 ){
        if(num1 == 0 || num2==0)
            return true;
        while(num1 > 0) {
            if(num1 % 10 == 0)
                return true;
            num1 /= 10;
        }
         while(num2 > 0) {
            if(num2 % 10 == 0)
                return true;
            num2 /= 10;
        }
        return false;
        
}
    public int[] getNoZeroIntegers(int n) {
        int[] ans = new int[2];
        int n1;
        int n2;
        for(int i=1;i<=n;i++){
            n1=i;
            n2=n-i;
            boolean return_ = isContainzero(n1,n2);
            if(return_==true){
                isContainzero(n1,n2);
            }else{
                ans[0]=n1;
                ans[1]=n2;
                break;
            }
                   
        }
        return ans;
        
    }
}