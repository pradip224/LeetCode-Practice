
Recover Binary Search Tree
Medium
7.2K
232
Companies
You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

 

Example 1:


Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
Example 2:


Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
 

Constraints:

The number of nodes in the tree is in the range [2, 1000].
-231 <= Node.val <= 231 - 1





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
    private TreeNode firstElement;
    private TreeNode secondElement;
    private TreeNode prevElement;

    public void recoverTree(TreeNode root) {
        // Initialize the variables
        firstElement = null;
        secondElement = null;
        prevElement = new TreeNode(Integer.MIN_VALUE);

        // Traverse the tree to find the swapped nodes
        inorderTraversal(root);

        // Swap the values of the two nodes
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);

        // Check for the swapped nodes
        if (firstElement == null && prevElement.val > node.val) {
            firstElement = prevElement;
        }
        if (firstElement != null && prevElement.val > node.val) {
            secondElement = node;
        }
        prevElement = node;

        inorderTraversal(node.right);
    }
}

