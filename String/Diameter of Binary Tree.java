543. Diameter of Binary Tree
Easy
12.3K
772
Companies
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

 

Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100



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
    private int maxDiameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        calculateDepth(root);
        return maxDiameter;
    }
    
    private int calculateDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftDepth = calculateDepth(node.left);
        int rightDepth = calculateDepth(node.right);
        
        // Update the maximum diameter encountered so far
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
        
        // Return the depth of the current subtree rooted at 'node'
        return 1 + Math.max(leftDepth, rightDepth);
    }
}


