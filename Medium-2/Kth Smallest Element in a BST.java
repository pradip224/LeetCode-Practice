
Kth Smallest Element in a BST
Medium
10.2K
181
Companies
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

 

Example 1:


Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:


Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
 

Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104



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
    private int count; // Keep track of the number of nodes visited
    private int result; // Store the kth smallest value
    
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = 0;
        inorderTraversal(root, k);
        return result;
    }
    
    private void inorderTraversal(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        
        // Traverse the left subtree
        inorderTraversal(node.left, k);
        
        // Process the current node
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        
        // Traverse the right subtree
        inorderTraversal(node.right, k);
    }
}
