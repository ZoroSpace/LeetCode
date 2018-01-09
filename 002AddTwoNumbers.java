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
        ListNode nodeX;
        int c = 0;
        int sum = 0;
        while(l1 != null || l2 != null) {
            if(l1 == null) {
                sum = c + l2.val;
                c = 0;
                l2 = l2.next;
            } else if(l2 == null) {
                sum = c + l1.val;
                c = 0;
                l1 = l1.next;
            } else {
                sum = c + l1.val + l2.val;
                c = 0;
                if(sum >= 10) {
                    sum = sum - 10;
                    c = 1;
                }
                l1 = l1.next;
                l2 = l2.next;
            }
            nodeX = new ListNode(sum);
            current.next = nodeX;
            current = current.next;
        }
        if(c == 1) {
            nodeX = new ListNode(c);
            current.next = nodeX;
            current = current.next;
        }
        return start.next;
    }
}
