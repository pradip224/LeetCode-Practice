Insertion Sort List
Medium
2.7K
838
Companies
Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.

The steps of the insertion sort algorithm:

Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
It repeats until no input elements remain.
The following is a graphical example of the insertion sort algorithm. The partially sorted list (black) initially contains only the first element in the list. One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.


 

Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
 

Constraints:

The number of nodes in the list is in the range [1, 5000].
-5000 <= Node.val <= 5000



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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Empty list or single node, already sorted
        }
        
        ListNode dummy = new ListNode(0); // Dummy node to mark the sorted list
        ListNode curr = head; // Current node to be inserted
        
        while (curr != null) {
            ListNode prev = dummy;
            
            // Find the position to insert the current node in the sorted list
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }
            
            ListNode nextNode = curr.next;
            curr.next = prev.next; // Insert the current node
            prev.next = curr;
            curr = nextNode; // Move to the next node for insertion
            
            // Update the head of the sorted list if necessary
            if (curr == null) {
                head = dummy.next;
            }
        }
        
        return head;
    }
}
