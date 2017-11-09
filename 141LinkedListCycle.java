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
        if(head == null) return false;
        head.val = Integer.MAX_VALUE;
        while(true) {
            if(head.next == null) {
                return false;
            }
            else if(head.next.val == Integer.MAX_VALUE) return true;
            else {
                head.next.val = Integer.MAX_VALUE;
                head = head.next;
            }
        }
    }
}
