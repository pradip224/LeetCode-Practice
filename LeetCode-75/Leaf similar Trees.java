Q. Leaf similar Trees

Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.



For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

 

Example 1:


Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
Output: true
Example 2:


Input: root1 = [1,2,3], root2 = [1,3,2]
Output: false
 

Constraints:

The number of nodes in each tree will be in the range [1, 200].
Both of the given trees will have values in the range [0, 200].



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
 
 import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafValues1 = new ArrayList<>();
        List<Integer> leafValues2 = new ArrayList<>();
        
        // Extract leaf values from both trees
        getLeafValues(root1, leafValues1);
        getLeafValues(root2, leafValues2);
        
        // Compare the leaf value sequences
        return leafValues1.equals(leafValues2);
    }
    
    private void getLeafValues(TreeNode root, List<Integer> leafValues) {
        if (root == null) return;
        
        if (root.left == null && root.right == null) {
            // Add the leaf value to the list
            leafValues.add(root.val);
        } else {
            // Traverse the left and right subtrees
            getLeafValues(root.left, leafValues);
            getLeafValues(root.right, leafValues);
        }
    }
}

