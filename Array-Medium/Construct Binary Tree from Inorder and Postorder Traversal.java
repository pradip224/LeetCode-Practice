

Construct Binary Tree from Inorder and Postorder Traversal
Medium
7.1K
107
Companies
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]
 

Constraints:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.





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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Create a map to store the indices of inorder elements
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        
        // Call the recursive helper function
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, indexMap);
    }
    
    private TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd,
                                     int[] postorder, int postStart, int postEnd,
                                     Map<Integer, Integer> indexMap) {
        // Base case: empty subtree
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        
        // Create the root node using the last element of postorder
        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);
        
        // Find the index of the root in the inorder array
        int rootIndex = indexMap.get(rootValue);
        
        // Recursively construct the left and right subtrees
        // based on the root index and the sizes of the subtrees
        int leftSubtreeSize = rootIndex - inStart;
        int rightSubtreeSize = inEnd - rootIndex;
        
        root.left = buildTreeHelper(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + leftSubtreeSize - 1, indexMap);
        root.right = buildTreeHelper(inorder, rootIndex + 1, inEnd, postorder, postEnd - rightSubtreeSize, postEnd - 1, indexMap);
        
        return root;
    }
}



