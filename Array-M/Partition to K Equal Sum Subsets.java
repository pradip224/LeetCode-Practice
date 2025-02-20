698. Partition to K Equal Sum Subsets
Solved
Medium
Topics
Companies
Hint
Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.

 

Example 1:

Input: nums = [4,3,2,3,5,2,1], k = 4
Output: true
Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
Example 2:

Input: nums = [1,2,3,4], k = 3
Output: false
 

Constraints:

1 <= k <= nums.length <= 16
1 <= nums[i] <= 104
The frequency of each element is in the range [1, 4].


class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        
        //sum%k must equal to 0 if not just return false
        //if we have to to divide the array greater than array size retun false(we can't)
        if(sum%k!=0 || nums.length<k) return false;
        
        //sort so we can take last element and start filling our bucket
        Arrays.sort(nums);
        
        //our target is sum/k and we have to find this in nums, k times then it is valid
        return canPartitionKSubsets(nums,sum/k,nums.length-1,new int[k]);
    
    }
    public boolean canPartitionKSubsets(int a[],int target,int i,int bucket[]){
        
        //we have taken all the elements
        if(i==-1)
            return true;
        
        //start filling the buckets
        for(int j=0;j<bucket.length;j++){
            
            //can we take this ith element
            if(bucket[j]+a[i]<=target){
            
                //if we take this element
                bucket[j]+=a[i];
                
                //go to next element (in our case go to smallest ele bcz we sorted)
                //if we can fill all buckets then return true
                if(canPartitionKSubsets(a,target,i-1,bucket))
                    return true;
                
                //means we can't fill other buckets if we take ith element so leave this element
                bucket[j]-=a[i];
            
            }
            
            //if our bucket is empty means we have not taken any elements in the buckets
            if(bucket[j]==0)
                break;
        
        }
        
        //all buckets are full but i is pointing to some element (elements still left)
        //or our bucket is empty means we haven't take any element (not valid)
        return false;
    
    }
}
