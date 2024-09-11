783. Minimum Distance Between BST Nodes
Solved
Easy
Topics
Companies
Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.

 

Example 1:


Input: root = [4,2,6,1,3]
Output: 1
Example 2:


Input: root = [1,0,48,null,null,12,49]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [2, 100].
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

    public  void inorder(TreeNode root, List<Integer> arr ){
       

       if(root==null)return;
        inorder(root.left,arr);
        arr.add(root.val);
      
        inorder(root.right,arr);

    }
    public int minDiffInBST(TreeNode root) {
          List<Integer> arr=new ArrayList<>();
          int mini=Integer.MAX_VALUE;
          inorder(root,arr);
          for(int i=0;i<arr.size()-1;i++){
            //  if(arr.get(i)!=arr.get(i+1))
              mini=Math.min(mini,arr.get(i+1)-arr.get(i));
          }
          return mini;
    }
}