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
        // Base case: if the list is empty or has only one node, it is already sorted
        if (head == null || head.next == null) {
            return head;
        }
        
        // Step 1: Split the list into two halves
        ListNode mid = getMid(head);
        ListNode rightHead = mid.next;
        mid.next = null; // Break the link to isolate the left half
        
        // Step 2: Recursively sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        
        // Step 3: Merge the sorted halves and return the result
        return merge(left, right);
    }
    
    // Helper method to find the middle node using Tortoise and Hare approach
    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next; // Start fast at head.next to get the exact left-middle node
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    // Helper method to merge two sorted linked lists
    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0); // Dummy node to ease pointer manipulation
        ListNode tail = dummy;
        
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        
        // Append any remaining nodes from either list
        tail.next = (list1 != null) ? list1 : list2;
        
        return dummy.next;
    }
}
