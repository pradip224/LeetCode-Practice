
450. Delete Node in a BST
Medium
8K
209
Companies
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
 

Example 1:


Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

Example 2:

Input: root = [5,3,6,2,4,null,7], key = 0
Output: [5,3,6,2,4,null,7]
Explanation: The tree does not contain a node with value = 0.
Example 3:

Input: root = [], key = 0
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-105 <= Node.val <= 105
Each node has a unique value.
root is a valid binary search tree.
-105 <= key <= 105



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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null; // Base case: tree is empty
        }
        
        if (key < root.val) {
            root.left = deleteNode(root.left, key); // Recur in the left subtree
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key); // Recur in the right subtree
        } else {
            // Node with the key to be deleted found
            
            if (root.left == null) {
                return root.right; // Case 1: Node has only a right child or no children
            } else if (root.right == null) {
                return root.left; // Case 2: Node has only a left child
            }
            
            // Case 3: Node has two children
            root.val = minValue(root.right); // Find the inorder successor
            root.right = deleteNode(root.right, root.val); // Delete the inorder successor
        }
        
        return root;
    }
    
    // Helper method to find the minimum value in a BST
    private int minValue(TreeNode node) {
        int minValue = node.val;
        while (node.left != null) {
            minValue = node.left.val;
            node = node.left;
        }
        return minValue;
    }
}


