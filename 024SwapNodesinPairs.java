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
        if(head == null || head.next == null) return head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode third;
        head = second;
        while(second.next != null && second.next.next != null) {
            third = second.next;
            first.next = second.next.next;
            second.next = first;
            second = first.next;
            first = third;
        }
        first.next = second.next;
        second.next = first;
        return head;
        
    }
}
