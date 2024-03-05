2605. Form Smallest Number From Two Digit Arrays
Solved
Easy
Topics
Companies
Hint
Given two arrays of unique digits nums1 and nums2, return the smallest number that contains at least one digit from each array.
 

Example 1:

Input: nums1 = [4,1,3], nums2 = [5,7]
Output: 15
Explanation: The number 15 contains the digit 1 from nums1 and the digit 5 from nums2. It can be proven that 15 is the smallest number we can have.
Example 2:

Input: nums1 = [3,5,2,6], nums2 = [3,1,7]
Output: 3
Explanation: The number 3 contains the digit 3 which exists in both arrays.
 

Constraints:

1 <= nums1.length, nums2.length <= 9
1 <= nums1[i], nums2[i] <= 9
All digits in each array are unique.


class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int temp = getCommon(nums1, nums2);
        if(temp > 0) return temp;
        int a = getMinimum(nums1);
        if(isPresent(nums2, a)){
            return a;
        }
        int b = getMinimum(nums2);
        if(a < b){
            return a*10+b;
        }else{
            return b*10+a;
        }
    }
    public int getMinimum(int[] nums){
        int min = Integer.MAX_VALUE;
        int ans;
        for(int i = 0; i < nums.length; i++){
            min = Math.min(min, nums[i]);
            ans = min;
        }
        return min;
    }
    public boolean isPresent(int[] nums, int k){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == k) return true;
        }
        return false;
    }
    public int getCommon(int[] nums1, int[] nums2){
        int min = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<Integer>();
        int ans=-1;
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    list.add(nums1[i]);
                    break;
                }
            }
        }
        for(int i=0; i<list.size(); i++){
            min = Math.min(min, list.get(i));
            ans = min;
        }
        return ans;
    }
}