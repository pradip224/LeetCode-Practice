932. Beautiful Array
Solved
Medium
Topics
premium lock icon
Companies
An array nums of length n is beautiful if:

nums is a permutation of the integers in the range [1, n].
For every 0 <= i < j < n, there is no index k with i < k < j where 2 * nums[k] == nums[i] + nums[j].
Given the integer n, return any beautiful array nums of length n. There will be at least one valid answer for the given n.

 

Example 1:

Input: n = 4
Output: [2,1,4,3]
Example 2:

Input: n = 5
Output: [3,1,2,5,4]
 

Constraints:

1 <= n <= 1000class Solution {
    public int[] beautifulArray(int n) {
        int[] ans = new int[n];
        for(int i = 0; i  < n; i++){
            ans[i] = i+1;
        }
        recursion(ans, 0, n-1);
        return ans;
    }
    
    public void recursion(int[] arr, int left, int right){
        if(left >= right)
            return;
        ArrayList<Integer> l = new ArrayList<>();
        ArrayList<Integer> r = new ArrayList<>();
		
        boolean alt = true;// Not worry about whether the factor of the interval is even or odd too much, they can be grouped by 
							// just picking one and skip one
							
        for(int i = left; i <= right; i++){ // picking the elements and put them into the two groups
            if(alt)
                l.add(arr[i]);
            else
                r.add(arr[i]);
            alt = !alt;
        }

        for(int i = left; i <= right; i++){ // merging them into the final array
            if(!l.isEmpty())
                arr[i] = l.remove(0);
            else
                arr[i] = r.remove(0);
        }
        recursion(arr, left, (right+left)/2);
        recursion(arr, (left+right)/2+1, right);
    }
}
