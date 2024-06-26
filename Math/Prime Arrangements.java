1175. Prime Arrangements
Solved
Easy
Topics
Companies
Hint
Return the number of permutations of 1 to n so that prime numbers are at prime indices (1-indexed.)

(Recall that an integer is prime if and only if it is greater than 1, and cannot be written as a product of two positive integers both smaller than it.)

Since the answer may be large, return the answer modulo 10^9 + 7.

 

Example 1:

Input: n = 5
Output: 12
Explanation: For example [1,2,5,4,3] is a valid permutation, but [5,2,3,4,1] is not because the prime number 5 is at index 1.
Example 2:

Input: n = 100
Output: 682289015
 

Constraints:

1 <= n <= 100

class Solution {
    public int numPrimeArrangements(int n) {
        int numPrime=countPrime(n);
        int numComposite=n-numPrime;

        long primePermu=permutation(numPrime);
        long compositePermu=permutation(numComposite);

        long result= (primePermu*compositePermu)%(long)(Math.pow(10,9)+7);
        return (int)result;
    }
    public int countPrime(int n){
        int count=0;
        for(int i=2;i<=n;i++){
            int flag=1;
            for(int j=2;j<=Math.sqrt(i);j++){
                if(i%j==0){
                    flag=0;
                    break;
                }
            }
            if(flag==1){
                count++;
            }
        }
        return count;
    }
    public long permutation(int num){
        long pro=1;
        for(int i=num;i>=1;i--){
            pro=(pro*i)%(long)(Math.pow(10,9)+7);
        }
        return pro;
    }
}