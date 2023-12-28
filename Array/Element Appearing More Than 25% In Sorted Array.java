1287. Element Appearing More Than 25% In Sorted Array
Easy
1.6K
73
Companies
Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time, return that integer.

 

Example 1:

Input: arr = [1,2,2,6,6,6,6,7,10]
Output: 6
Example 2:

Input: arr = [1,1]
Output: 1
 

Constraints:

1 <= arr.length <= 104
0 <= arr[i] <= 105

class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(arr[i] == arr[j]) count++;
            }
            if(count > n / 4) return arr[i];
        }
        return -1;
    }
}