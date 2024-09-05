572. Subtree of Another Tree
Solved
Easy
Topics
Companies
Hint
Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.

 

Example 1:


Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true
Example 2:


Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false
 

Constraints:

The number of nodes in the root tree is in the range [1, 2000].
The number of nodes in the subRoot tree is in the range [1, 1000].
-104 <= root.val <= 104
-104 <= subRoot.val <= 104


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

//           //////////////////ATISHAY\\\\\\\\\\\\\\\\           \\
//           \\\\\\\\\\\\\\\\\\\JAIN//////////////////           \\

class Solution {
    public boolean isidentical(TreeNode root, TreeNode subroot){
        if(root==null && subroot==null){
            return true;
        } else if(root==null || subroot==null || root.val!=subroot.val){
            return false;
        }
        if(!isidentical(root.left, subroot.left)){
            return false;
        }
        if(!isidentical(root.right, subroot.right)){
            return false;
        }
        return true;
    }
    public boolean subtree(TreeNode root, TreeNode subroot){
        if(root==null){
            return false;
        }

        if(root.val==subroot.val){
            if(isidentical(root, subroot)){
                return true;
            }
        }
        return subtree(root.left, subroot) || subtree(root.right, subroot);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return subtree(root, subRoot);
    }
}