3079. Find the Sum of Encrypted Integers
Solved
Easy
Topics
Companies
Hint
You are given an integer array nums containing positive integers. We define a function encrypt such that encrypt(x) replaces every digit in x with the largest digit in x. For example, encrypt(523) = 555 and encrypt(213) = 333.

Return the sum of encrypted elements.

 

Example 1:

Input: nums = [1,2,3]

Output: 6

Explanation: The encrypted elements are [1,2,3]. The sum of encrypted elements is 1 + 2 + 3 == 6.

Example 2:

Input: nums = [10,21,31]

Output: 66

Explanation: The encrypted elements are [11,22,33]. The sum of encrypted elements is 11 + 22 + 33 == 66.

 

Constraints:

1 <= nums.length <= 50
1 <= nums[i] <= 


class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        var sum = 0;
        for (var i = 0; i < nums.length; ++i) {
            var num = nums[i];
            var max = 0;
            var digits = 0;
            while (num > 0) {
                max = Math.max(max, num % 10);
                num /= 10;
                digits = digits * 10 + 1;
            }
            sum += digits * max;
        }
        return sum;
    }
}  