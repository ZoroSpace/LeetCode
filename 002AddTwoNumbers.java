/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        ListNode current = start;
        int c = 0;
        int sum = 0;
        while(l1 != null || l2 != null) {
            if(l1 == null) {
                sum = c + l2.val;
                l2 = l2.next;
            } else if(l2 == null) {
                sum = c + l1.val;
                l1 = l1.next;
            } else {
                sum = c + l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            c = 0;
            if(sum >= 10) {
                sum = sum - 10;
                c = 1;
            }
            current.next = new ListNode(sum);
            current = current.next;
        }
        if(c == 1) {
            current.next = new ListNode(1);
            current = current.next;
        }
        return start.next;
    }
}
