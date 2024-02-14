2239. Find Closest Number to Zero
Solved
Easy
Topics
Companies
Hint
Given an integer array nums of size n, return the number with the value closest to 0 in nums. If there are multiple answers, return the number with the largest value.

 

Example 1:

Input: nums = [-4,-2,1,4,8]
Output: 1
Explanation:
The distance from -4 to 0 is |-4| = 4.
The distance from -2 to 0 is |-2| = 2.
The distance from 1 to 0 is |1| = 1.
The distance from 4 to 0 is |4| = 4.
The distance from 8 to 0 is |8| = 8.
Thus, the closest number to 0 in the array is 1.
Example 2:

Input: nums = [2,-1,1]
Output: 1
Explanation: 1 and -1 are both the closest numbers to 0, so 1 being larger is returned.
 

Constraints:

1 <= n <= 1000
-105 <= nums[i] <= 105


class Solution {
    public int findClosestNumber(int[] nums){
        int ans = nums[0] , diff = Math.abs(nums[0]);
        for(int i=1; i<nums.length; i++){
            if(Math.abs(nums[i]) < diff){
                ans = nums[i];
                diff = Math.abs(nums[i]);
            }
            if(diff == Math.abs(nums[i]) && nums[i] > ans){
                ans = nums[i];
            }
        }
        return ans;



//      Another solution
        // int min=Integer.MAX_VALUE , res=0;
        // for(int i=0;i<nums.length;i++){
        //     if(Math.abs(nums[i])< min || nums[i]== Math.abs(min) ){
        //         min=Math.abs(nums[i]);
        //         res=nums[i];
        //     } 
        // }
        // return res;
    }
}

//   Another Solutions

//         Arrays.sort(nums);
//         int ans=0 , val=nums[0];
//         for(int i:nums){
//             if(i==0) return 0;
//             if(i>0){
//                 ans=i;
//                 break;
//             }
//             val=i;
//         }
//         if(ans==0)return nums[nums.length-1];
//         if(Math.abs(val)<ans)return val;
//         return ans;