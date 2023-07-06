
Sum Root to Leaf Numbers
Medium
6.8K
105
Companies
You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.

 

Example 1:


Input: root = [1,2,3]
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.

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
    public int sumNumbers(TreeNode root) {
        return sumPathNumbers(root, 0);
    }
    
    private int sumPathNumbers(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }
        
        currentSum = currentSum * 10 + node.val;
        
        if (node.left == null && node.right == null) {
            return currentSum;
        }
        
        int leftSum = sumPathNumbers(node.left, currentSum);
        int rightSum = sumPathNumbers(node.right, currentSum);
        
        return leftSum + rightSum;
    }
}

