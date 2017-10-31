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
        if(head == null || head.next == null) return head;
        ListNode first = head;
        ListNode second = head.next;
        while(second != null) {
            if(first.val == second.val) {
                first.next = second.next;
                second = second.next;
            } else {
                first = second;
                second = second.next;
            }
        }
        return head;
    }
}
