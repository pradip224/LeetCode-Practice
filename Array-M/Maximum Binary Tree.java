654. Maximum Binary Tree
Solved
Medium
Topics
Companies
You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums using the following algorithm:

Create a root node whose value is the maximum value in nums.
Recursively build the left subtree on the subarray prefix to the left of the maximum value.
Recursively build the right subtree on the subarray suffix to the right of the maximum value.
Return the maximum binary tree built from nums.

 

Example 1:


Input: nums = [3,2,1,6,0,5]
Output: [6,3,5,null,2,0,null,null,1]
Explanation: The recursive calls are as follow:
- The largest value in [3,2,1,6,0,5] is 6. Left prefix is [3,2,1] and right suffix is [0,5].
    - The largest value in [3,2,1] is 3. Left prefix is [] and right suffix is [2,1].
        - Empty array, so no child.
        - The largest value in [2,1] is 2. Left prefix is [] and right suffix is [1].
            - Empty array, so no child.
            - Only one element, so child is a node with value 1.
    - The largest value in [0,5] is 5. Left prefix is [0] and right suffix is [].
        - Only one element, so child is a node with value 0.
        - Empty array, so no child.
Example 2:


Input: nums = [3,2,1]
Output: [3,null,2,null,1]
 

Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 1000
All integers in nums are unique.


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return divide(nums,0, nums.length -1);
    }

        private TreeNode divide(int[] nums, int l, int r){
        if(l == r) return new TreeNode(nums[l]);
        
        int mid = l+ (r-l)/2;

        TreeNode left_sub = divide(nums,l, mid);
        TreeNode right_sub = divide(nums,mid+1,r);
        
        return merge(left_sub,right_sub);

    }

    private TreeNode merge(TreeNode left_sub, TreeNode right_sub){
        TreeNode iterator;

        if(left_sub.val > right_sub.val){
            iterator = left_sub;
            
            while(iterator.right != null && iterator.right.val > right_sub.val) iterator = iterator.right;
            if(iterator.right != null){
                TreeNode tmp_left = iterator.right;
                iterator.right = right_sub;
                merge(tmp_left,right_sub); 
            }
            else{
                iterator.right = right_sub;
            }
            return left_sub;
        } 
        else{
            iterator = right_sub;
            while(iterator.left != null && iterator.left.val > left_sub.val) iterator = iterator.left;
            if(iterator.left != null){
                TreeNode tmp_right = iterator.left;
                iterator.left = left_sub;
                merge(left_sub,tmp_right);
            }
            else{
                iterator.left = left_sub;
            }
            return right_sub;
        }
    }
}
