Remove Duplicates from Sorted List II
Medium
7.8K
209
Companies
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

 

Example 1:


Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
Example 2:


Input: head = [1,1,1,2,3]
Output: [2,3]
 

Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.





/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 


 class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Check if the list is empty or has only one node
        if (head == null || head.next == null) {
            return head;
        }
        
        // Create a dummy node to handle the case of removing the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Initialize pointers
        ListNode prev = dummy;
        ListNode current = head;
        
        while (current != null) {
            // Check if current node has duplicates
            if (current.next != null && current.val == current.next.val) {
                // Skip all duplicate nodes
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
                // Skip the last duplicate node
                current = current.next;
                prev.next = current;
            } else {
                // Move the pointers forward
                prev = current;
                current = current.next;
            }
        }
        
        return dummy.next;
    }
}

