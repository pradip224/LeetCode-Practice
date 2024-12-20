491. Non-decreasing Subsequences
Solved
Medium
Topics
Companies
Given an integer array nums, return all the different possible non-decreasing subsequences of the given array with at least two elements. You may return the answer in any order.

 

Example 1:

Input: nums = [4,6,7,7]
Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
Example 2:

Input: nums = [4,4,3,2,1]
Output: [[4,4]]
 

Constraints:

1 <= nums.length <= 15
-100 <= nums[i] <= 100


class Solution {
    int[] arr;
    HashSet<List<Integer>> hashSet = new HashSet<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        arr = nums;
        List<Integer> arrayList = new ArrayList<>();
        recursion(arrayList,0);
        List<List<Integer>> result = new ArrayList<>(hashSet);
        return result;
    }

    public void recursion(List<Integer> arrayList, int index){
        if(arrayList.size()>=2) hashSet.add(new ArrayList(arrayList));

        for(int i = index;i<arr.length;i++){
            if(arrayList.size() == 0 || arr[i]>= arrayList.get(arrayList.size()-1)){
                arrayList.add(arr[i]);
                recursion(arrayList,i+1);
                arrayList.remove(arrayList.size()-1);
            }
        }

    }
}
