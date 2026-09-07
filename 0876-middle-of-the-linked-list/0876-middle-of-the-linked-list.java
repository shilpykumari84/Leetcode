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
    public ListNode middleNode(ListNode head) {
        // Initialize both pointers at the head of the list
        ListNode slow = head;
        ListNode fast = head;
        
        // Traverse the list until the fast pointer reaches the end
        while (fast != null && fast.next != null) {
            slow = slow.next;          // Moves 1 step forward
            fast = fast.next.next;     // Moves 2 steps forward
        }
        
        // slow is now pointing exactly at the middle node
        return slow;
    }
}
