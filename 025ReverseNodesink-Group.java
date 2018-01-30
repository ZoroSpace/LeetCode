/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode start = new ListNode(0),slow,fast,cur,lastStart = start,temp;
        fast = head;
        slow = head;
        while(fast != null) {
            for(int i = 0;i < k;i++) {
                fast = fast.next;
            }
            cur = slow;
            temp = cur;
            while(cur != fast) {
                cur = cur.next;
                slow.next = lastStart.next;
                lastStart.next = slow;
                slow = cur;
            }
            lastStart = temp;
        }
        return start.next;
    }
}
