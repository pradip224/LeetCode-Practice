378. Kth Smallest Element in a Sorted Matrix
Solved
Medium
Topics
Companies
Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

You must find a solution with a memory complexity better than O(n2).

 

Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
Example 2:

Input: matrix = [[-5]], k = 1
Output: -5
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 300
-109 <= matrix[i][j] <= 109
All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
1 <= k <= n2
 


class Solution {
   // int m, n;
    public int kthSmallest(int[][] matrix, int k) {
      int r = matrix.length;
      int  c = matrix[0].length; 
        int min = matrix[0][0], max = matrix[r-1][c-1], ans = -1;
        while (min<=max) {
            int mid = (min+max)/2;
            if (countLessOrEqual(matrix, mid) >= k) {
                ans = mid;
                max = mid - 1;
            } 
            else 
            {min= mid + 1;}
        }
     return ans;
    }

    int countLessOrEqual(int[][] matrix, int x) {
          int r = matrix.length;
          int  c = matrix[0].length; 
        int count = 0, column = c - 1; 
        for (int i = 0; i<r;i++) {
            while (column >= 0 && matrix[i][column] > x) {
                column--;
            }  // decrease column until matrix[r][c] <= x
            count += (column + 1);
        }
        return count;
    }
}