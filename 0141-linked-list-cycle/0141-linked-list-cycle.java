/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // Handle empty list or single node list with no cycle
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head; // Moves 1 step at a time
        ListNode fast = head; // Moves 2 steps at a time
        
        // Traverse the list until the fast pointer reaches the end
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move slow pointer 1 step
            fast = fast.next.next;    // Move fast pointer 2 steps
            
            // If they meet, a cycle exists
            if (slow == fast) {
                return true;
            }
        }
        
        // If fast reaches null, there is no cycle
        return false;
    }
}
