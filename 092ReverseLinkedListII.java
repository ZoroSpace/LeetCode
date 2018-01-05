/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n) return head;
        ListNode s1 = new ListNode(0),s2 = new ListNode(0),s0 = s1,end,cur;
        s1.next = head;
        for(int i = 0;i < m-1;i++) {
            s1 = s1.next;
        }
        end = s1.next;
        for(int i = m;i < n;i++) {
            cur = s1.next;
            s1.next = cur.next;
            cur.next = s2.next;
            s2.next = cur;
        }
        end.next = s1.next.next;
        s1.next.next = s2.next;
        return s0.next;
    }
}
