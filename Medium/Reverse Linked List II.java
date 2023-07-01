
Reverse Linked List II
Medium
9.3K
421
Companies
Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]
 

Constraints:

The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
 

Follow up: Could you do it in one pass?




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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        
        // Step 1: Initialize pointers
        ListNode prev = null;
        ListNode curr = head;
        
        // Step 2: Traverse to the left position
        for (int i = 1; i < left; i++) {
            prev = curr;
            curr = curr.next;
        }
        
        // Step 3: Reverse the sublist from left to right
        ListNode leftNode = curr;
        ListNode next = null;
        ListNode prevNode = null;
        
        for (int i = left; i <= right; i++) {
            next = curr.next;
            curr.next = prevNode;
            prevNode = curr;
            curr = next;
        }
        
        // Step 4: Connect the reversed sublist back to the original list
        leftNode.next = curr;
        
        if (prev != null) {
            prev.next = prevNode;
        } else {
            head = prevNode;
        }
        
        // Step 5: Return the updated head of the list
        return head;
    }
}

