965. Univalued Binary Tree
Solved
Easy
Topics
Companies
A binary tree is uni-valued if every node in the tree has the same value.

Given the root of a binary tree, return true if the given tree is uni-valued, or false otherwise.

 

Example 1:


Input: root = [1,1,1,1,1,null,1]
Output: true
Example 2:


Input: root = [2,2,2,5,2]
Output: false
 

Constraints:

The number of nodes in the tree is in the range [1, 100].
0 <= Node.val < 100


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
    public boolean isUnivalTree(TreeNode root) {
        if (root == null)
            return true;

        return solve(root, root.val);
    }

    private boolean solve(TreeNode root, int rootVal) {
        if (root == null)
            return true;

        if (root.val != rootVal)
            return false;
        return solve(root.left, rootVal) && solve(root.right, rootVal);
    }
}