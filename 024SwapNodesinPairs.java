/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode first = head;
        ListNode second = head.next;
        ListNode third;
        ListNode result = head.next;
        while(second.next != null) {
            third = second.next;
            first.next = second.next.next;
            second.next = first;
            second = first.next;
            first = third;
        }
        second.next = first;
        return result;
    }
}
