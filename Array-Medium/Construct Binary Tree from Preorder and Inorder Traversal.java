Construct Binary Tree from Preorder and Inorder Traversal
Medium
12.9K
380
Companies
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 

Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.






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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int preorderStart, int preorderEnd,
                                     int[] inorder, int inorderStart, int inorderEnd) {
        if (preorderStart > preorderEnd)
            return null;
        
        int rootValue = preorder[preorderStart];
        TreeNode root = new TreeNode(rootValue);
        
        int rootIndexInorder = inorderStart;
        while (inorder[rootIndexInorder] != rootValue)
            rootIndexInorder++;
        
        int leftSubtreeSize = rootIndexInorder - inorderStart;
        
        root.left = buildTreeHelper(preorder, preorderStart + 1, preorderStart + leftSubtreeSize,
                                    inorder, inorderStart, rootIndexInorder - 1);
        root.right = buildTreeHelper(preorder, preorderStart + leftSubtreeSize + 1, preorderEnd,
                                     inorder, rootIndexInorder + 1, inorderEnd);
        
        return root;
    }
}


