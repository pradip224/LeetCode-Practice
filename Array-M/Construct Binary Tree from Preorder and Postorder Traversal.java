889. Construct Binary Tree from Preorder and Postorder Traversal
Solved
Medium
Topics
Companies
Given two integer arrays, preorder and postorder where preorder is the preorder traversal of a binary tree of distinct values and postorder is the postorder traversal of the same tree, reconstruct and return the binary tree.

If there exist multiple answers, you can return any of them.

 

Example 1:


Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]
Example 2:

Input: preorder = [1], postorder = [1]
Output: [1]
 

Constraints:

1 <= preorder.length <= 30
1 <= preorder[i] <= preorder.length
All the values of preorder are unique.
postorder.length == preorder.length
1 <= postorder[i] <= postorder.length
All the values of postorder are unique.
It is guaranteed that preorder and postorder are the preorder traversal and postorder traversal of the same binary tree.


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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int[] index = new int[]{0};
        return construct(preorder, postorder, index, 0, preorder.length - 1);
    }
    private TreeNode construct(int[] preorder, int[] postorder, int[] index, int l, int h){
        if(index[0] >= preorder.length || l > h)
            return null;

        TreeNode root = new TreeNode(preorder[index[0]++]);
        if(l == h) return root;

        int i;
        for(i = l; i <= h; i++){
            if(postorder[i] == preorder[index[0]]) break;
        }
        if(l <= h){
            root.left = construct(preorder, postorder, index, l, i);
            root.right = construct(preorder, postorder, index, i + 1, h - 1);
        }
        return root;
    }
}
