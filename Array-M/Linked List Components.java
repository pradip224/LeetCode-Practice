817. Linked List Components
Solved
Medium
Topics
Companies
You are given the head of a linked list containing unique integer values and an integer array nums that is a subset of the linked list values.

Return the number of connected components in nums where two values are connected if they appear consecutively in the linked list.

 

Example 1:


Input: head = [0,1,2,3], nums = [0,1,3]
Output: 2
Explanation: 0 and 1 are connected, so [0, 1] and [3] are the two connected components.
Example 2:


Input: head = [0,1,2,3,4], nums = [0,3,1,4]
Output: 2
Explanation: 0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
 

Constraints:

The number of nodes in the linked list is n.
1 <= n <= 104
0 <= Node.val < n
All the values Node.val are unique.
1 <= nums.length <= n
0 <= nums[i] < n
All the values of nums are unique.
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
    public int numComponents(ListNode head, int[] nums) {
        ListNode temp = head;
        Set<Integer> st = new HashSet<>();

        for(int i : nums){
            st.add(i);
        }

        int cnt = 0;
        boolean flag = false;   // to check the streek

        while(temp != null){
            if(st.contains(temp.val) && !flag){
                // if an element is present in nums[] and streek is not ongoing then increase the count
                cnt++;
                flag = true;
            }
            // to checck streek is break or not
            else if (!st.contains(temp.val) && flag)    flag = false;
            temp = temp.next;
        }

        return cnt;
    }
}
