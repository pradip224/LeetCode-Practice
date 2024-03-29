2670. Find the Distinct Difference Array
Solved
Easy
Topics
Companies
Hint
You are given a 0-indexed array nums of length n.

The distinct difference array of nums is an array diff of length n such that diff[i] is equal to the number of distinct elements in the suffix nums[i + 1, ..., n - 1] subtracted from the number of distinct elements in the prefix nums[0, ..., i].

Return the distinct difference array of nums.

Note that nums[i, ..., j] denotes the subarray of nums starting at index i and ending at index j inclusive. Particularly, if i > j then nums[i, ..., j] denotes an empty subarray.

 

Example 1:

Input: nums = [1,2,3,4,5]
Output: [-3,-1,1,3,5]
Explanation: For index i = 0, there is 1 element in the prefix and 4 distinct elements in the suffix. Thus, diff[0] = 1 - 4 = -3.
For index i = 1, there are 2 distinct elements in the prefix and 3 distinct elements in the suffix. Thus, diff[1] = 2 - 3 = -1.
For index i = 2, there are 3 distinct elements in the prefix and 2 distinct elements in the suffix. Thus, diff[2] = 3 - 2 = 1.
For index i = 3, there are 4 distinct elements in the prefix and 1 distinct element in the suffix. Thus, diff[3] = 4 - 1 = 3.
For index i = 4, there are 5 distinct elements in the prefix and no elements in the suffix. Thus, diff[4] = 5 - 0 = 5.
Example 2:

Input: nums = [3,2,3,4,2]
Output: [-2,-1,0,2,3]
Explanation: For index i = 0, there is 1 element in the prefix and 3 distinct elements in the suffix. Thus, diff[0] = 1 - 3 = -2.
For index i = 1, there are 2 distinct elements in the prefix and 3 distinct elements in the suffix. Thus, diff[1] = 2 - 3 = -1.
For index i = 2, there are 2 distinct elements in the prefix and 2 distinct elements in the suffix. Thus, diff[2] = 2 - 2 = 0.
For index i = 3, there are 3 distinct elements in the prefix and 1 distinct element in the suffix. Thus, diff[3] = 3 - 1 = 2.
For index i = 4, there are 3 distinct elements in the prefix and no elements in the suffix. Thus, diff[4] = 3 - 0 = 3.
 

Constraints:

1 <= n == nums.length <= 50
1 <= nums[i] <= 50

class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> prefix = new HashMap<>();
        HashMap<Integer,Integer> suffix = new HashMap<>();
        int[] ans = new int[nums.length];
        int[] prearr = new int[nums.length];
        int[] suffarr = new int[nums.length];

        int k =0;
        int x = 0;
        for(int i=0; i<nums.length; i++){
            for(int j =0; j<=i; j++){
                if(!prefix.containsKey(nums[j])){
                    prefix.put(nums[j],1);
                }
            }
            int pref_val = prefix.size();
            k++;

            // System.out.println( prefix.size() + " prefix");
            
            int count = 0;
            for(int j = i+1; j<n; j++){
                
                if(!suffix.containsKey(nums[j])){
                    suffix.put(nums[j],1);
                }
                
            }
            int suff_val = suffix.size();
            suffix.clear();

            ans[i] = pref_val - suff_val;
            
            System.out.println(suff_val);
        }
        
        
       
        
        return ans;
    }
}