/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode slow,fast;
        slow = start;
        fast = slow.next;
        while(fast != null && fast.next != null) {
            if(slow.next.val != fast.next.val) {
                slow = fast;
                fast = fast.next;
            } else {
                while(fast != null && fast.next != null && fast.val == fast.next.val) {
                    fast = fast.next;
                }
                slow.next = fast.next;
                if(slow != null) slow = slow.next;
                if(slow != null) fast = slow.next;
            }
        }
        return start.next;
        
    }
}
