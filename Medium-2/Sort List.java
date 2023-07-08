
Sort List
Medium
10.1K
294
Companies
Given the head of a linked list, return the list after sorting it in ascending order.

 

Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105



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
    public ListNode sortList(ListNode head) {
        // Base case: If the list is empty or has only one element, it is already sorted
        if (head == null || head.next == null) {
            return head;
        }
        
        // Find the middle of the list using the slow and fast pointer technique
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Split the list into two halves
        prev.next = null;
        
        // Recursively sort the two halves
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        
        // Merge the sorted halves
        return merge(left, right);
    }
    
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (left != null && right != null) {
            if (left.val <= right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        
        // Append the remaining nodes, if any
        if (left != null) {
            current.next = left;
        }
        
        if (right != null) {
            current.next = right;
        }
        
        return dummy.next;
    }
}

