501. Find Mode in Binary Search Tree
Solved
Easy
Topics
Companies
Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.

If the tree has more than one mode, return them in any order.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [1,null,2,2]
Output: [2]
Example 2:

Input: root = [0]
Output: [0]
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-105 <= Node.val <= 105
 

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).


import java.util.*;

public class Solution {
    private HashMap<Integer, Integer> valueCount = new HashMap<>();
    private int maxCount = 0;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }


        inorderTraversal(root);


        List<Integer> modesList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : valueCount.entrySet()) {
            if (entry.getValue() == maxCount) {
                modesList.add(entry.getKey());
            }
        }

        int[] modesArray = new int[modesList.size()];
        for (int i = 0; i < modesList.size(); i++) {
            modesArray[i] = modesList.get(i);
        }

        return modesArray;
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);

        int currentValue = node.val;
        int currentCount = valueCount.getOrDefault(currentValue, 0) + 1;
        valueCount.put(currentValue, currentCount);
        maxCount = Math.max(maxCount, currentCount);

        inorderTraversal(node.right);
    }
}