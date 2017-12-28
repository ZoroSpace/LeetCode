/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode start1 = new ListNode(0);
        start1.next = null;
        ListNode start2 = new ListNode(0);
        start2.next = head;
        ListNode temp;
        while(start2.next != null) {
            head = start2.next;
            start2.next = head.next;
            head.next = null;
            temp = start1;
            while(temp.next != null) {
                if(head.val > temp.next.val) temp = temp.next;
                else {
                    head.next = temp.next;
                    temp.next = head;
                    break;
                }
            }
            if(temp.next == null) temp.next = head;
        }
        return start1.next;
    }
}
