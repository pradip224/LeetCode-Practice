

Partition List
Medium
5.6K
634
Companies
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

 

Example 1:


Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
Example 2:

Input: head = [2,1], x = 2
Output: [1,2]
 

Constraints:

The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200





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
    public ListNode partition(ListNode head, int x) {
        ListNode smallerHead = new ListNode(0);  // Dummy node for smaller values
        ListNode smaller = smallerHead;
        ListNode greaterHead = new ListNode(0);  // Dummy node for greater values
        ListNode greater = greaterHead;
        
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                smaller.next = curr;
                smaller = smaller.next;
            } else {
                greater.next = curr;
                greater = greater.next;
            }
            curr = curr.next;
        }
        
        greater.next = null;  // Set the end of greater list as null
        smaller.next = greaterHead.next;  // Merge the two lists
        
        return smallerHead.next;  // Return the merged list
    }
}



