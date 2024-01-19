1886. Determine Whether Matrix Can Be Obtained By Rotation
Solved
Easy
Topics
Companies
Hint
Given two n x n binary matrices mat and target, return true if it is possible to make mat equal to target by rotating mat in 90-degree increments, or false otherwise.

 

Example 1:


Input: mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
Output: true
Explanation: We can rotate mat 90 degrees clockwise to make mat equal target.
Example 2:


Input: mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
Output: false
Explanation: It is impossible to make mat equal to target by rotating mat.
Example 3:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
Output: true
Explanation: We can rotate mat 90 degrees clockwise two times to make mat equal target.
 

Constraints:

n == mat.length == target.length
n == mat[i].length == target[i].length
1 <= n <= 10
mat[i][j] and target[i][j] are either 0 or 1.


class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        boolean flag = false;
        for(int k = 0; k < 4; k++){
            rotateMat90(mat);
            outerLoop: for(int i = 0; i < mat.length; i++){
                for(int j = 0; j < mat[0].length; j++){
                    if(mat[i][j] != target[i][j]){
                        flag = false;
                        break outerLoop;
                    } else{
                        flag = true;
                    }
                }

            }
            if(flag){
                return true;
            }

        }
        return false;
    }

    void rotateMat90(int[][] mat){
        // transpose the mat
        for(int i = 0; i < mat.length; i++){
            for(int j = i; j < mat[i].length; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        // reverse the array in the mat
        for(int[] arr: mat){
            int start = 0;
            int end = arr.length - 1;
            while(start < end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
    }
}