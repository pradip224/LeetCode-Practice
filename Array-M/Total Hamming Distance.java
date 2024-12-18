477. Total Hamming Distance
Solved
Medium
Topics
Companies
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given an integer array nums, return the sum of Hamming distances between all the pairs of the integers in nums.

 

Example 1:

Input: nums = [4,14,2]
Output: 6
Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case).
The answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
Example 2:

Input: nums = [4,14,4]
Output: 4
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 109
The answer for the given input will fit in a 32-bit integer.


class Solution {
    public int totalHammingDistance(int[] nums) {
    
    int cntOne[]=new int[31];
    int n=nums.length;

//calculating total set bits at particular index 
    for(int i=0;i<n;i++){ 
        int idx=0;
        while(nums[i]>0){ 
            if((nums[i]&1)!=0){ 
                ++cntOne[idx];
            }
            idx++;
            nums[i]>>=1;
        }
    }


// at last the total number of set bits will be multiplies with the length of nums - total set bits at particular index , so that we can get number of set bits at that index
    int tot=0;

    for(int i=0;i<31;i++){ 
        tot+=((n-cntOne[i])*cntOne[i]);
    }

    return tot;

    }
}
