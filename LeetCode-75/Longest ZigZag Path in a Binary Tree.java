
1372. Longest ZigZag Path in a Binary Tree
Medium
3K
58
Companies
You are given the root of a binary tree.

A ZigZag path for a binary tree is defined as follow:

Choose any node in the binary tree and a direction (right or left).
If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
Change the direction from right to left or from left to right.
Repeat the second and third steps until you can't move in the tree.
Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

Return the longest ZigZag path contained in that tree.

 

Example 1:


Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1]
Output: 3
Explanation: Longest ZigZag path in blue nodes (right -> left -> right).
Example 2:


Input: root = [1,1,1,null,1,null,null,1,1,null,1]
Output: 4
Explanation: Longest ZigZag path in blue nodes (left -> right -> left -> right).
Example 3:

Input: root = [1]
Output: 0
 

Constraints:

The number of nodes in the tree is in the range [1, 5 * 104].
1 <= Node.val <= 100



class Solution {
    private int longestZigZag = 0; // Variable to store the longest ZigZag path
    
    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        // Start DFS traversal from the root node
        dfs(root.left, 1, true);  // Start with left direction
        dfs(root.right, 1, false); // Start with right direction
        
        return longestZigZag;
    }
    
    // Helper function to perform DFS traversal
    private void dfs(TreeNode node, int length, boolean isLeft) {
        if (node == null) {
            return;
        }
        
        // Update the longest ZigZag path if the current length is greater
        longestZigZag = Math.max(longestZigZag, length);
        
        // Explore the left and right child nodes
        if (isLeft) {
            dfs(node.right, length + 1, false); // Move to the right child with opposite direction
            dfs(node.left, 1, true); // Start ZigZag path in left direction
        } else {
            dfs(node.left, length + 1, true); // Move to the left child with opposite direction
            dfs(node.right, 1, false); // Start ZigZag path in right direction
        }
    }
}

