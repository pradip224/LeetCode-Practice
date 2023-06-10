
Count Primes
Medium
6.9K
1.3K
Companies
Given an integer n, return the number of prime numbers that are strictly less than n.

 

Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
Example 2:

Input: n = 0
Output: 0
Example 3:

Input: n = 1
Output: 0
 

Constraints:

0 <= n <= 5 * 106


class Solution {
    public int countPrimes(int n) {
        // Create a boolean array to track prime numbers
        int[] primeArr = new int[n];
        // for (int i = 2; i < n; i++) {
        //     primeArr[i] = true; // Assume all numbers are prime initially
        // }
        
        // Use the Sieve of Eratosthenes algorithm to find primes
        for (int i = 2; i * i < n; i++) {
            if (primeArr[i] == 0) {
                // Mark all multiples of i as non-prime
                for (int j = i * i; j < n; j += i) {
                    primeArr[j] = 1;
                }
            }
        }
        
        // Count the number of prime numbers
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primeArr[i] == 0) {
                count++;
            }
        }
        
        return count;
    }
}

