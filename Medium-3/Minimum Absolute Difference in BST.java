Minimum Absolute Difference in BST
Easy
3.9K
184
Companies
Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

 

Example 1:


Input: root = [4,2,6,1,3]
Output: 1
Example 2:


Input: root = [1,0,48,null,null,12,49]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [2, 104].
0 <= Node.val <= 105



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
    // Global variable to keep track of the previous node's value during in-order traversal
    private int prevValue;
    // Global variable to store the minimum absolute difference found so far
    private int minDiff;
    
    public int getMinimumDifference(TreeNode root) {
        // Initialize the variables before starting the traversal
        prevValue = -1;
        minDiff = Integer.MAX_VALUE;
        
        // Start the in-order traversal
        inOrderTraversal(root);
        
        return minDiff;
    }
    
    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        
        // Left Subtree
        inOrderTraversal(node.left);
        
        // Current Node
        if (prevValue != -1) {
            // If this is not the first node, calculate the absolute difference
            minDiff = Math.min(minDiff, node.val - prevValue);
        }
        // Update the previous value to the current node's value
        prevValue = node.val;
        
        // Right Subtree
        inOrderTraversal(node.right);
    }
}

