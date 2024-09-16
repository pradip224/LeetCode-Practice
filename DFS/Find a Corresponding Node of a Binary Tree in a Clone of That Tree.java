1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
Solved
Easy
Topics
Companies
Given two binary trees original and cloned and given a reference to a node target in the original tree.

The cloned tree is a copy of the original tree.

Return a reference to the same node in the cloned tree.

Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.

 

Example 1:


Input: tree = [7,4,3,null,null,6,19], target = 3
Output: 3
Explanation: In all examples the original and cloned trees are shown. The target node is a green node from the original tree. The answer is the yellow node from the cloned tree.
Example 2:


Input: tree = [7], target =  7
Output: 7
Example 3:


Input: tree = [8,null,6,null,5,null,4,null,3,null,2,null,1], target = 4
Output: 4
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
The values of the nodes of the tree are unique.
target node is a node from the original tree and is not null.
 


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        // check if treenode is null
        if (original==null){
            return original;
        }
        // intiate a queue for storing nodes
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        // add the root to the queue
        q.add(cloned);
        // while to iterate till last node
        while(!q.isEmpty()){
            // take out the first node from the stack 
            TreeNode temp = q.poll();
            // check if it satifies the condition
            if(temp.val==target.val){
                return temp;
            }
            // if condition does not satifies add its child nodes to the queue
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
        }
        return null;
    }
}