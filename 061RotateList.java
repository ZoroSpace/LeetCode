/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k < 0 || head == null) return null;
        int length = 1;
        ListNode cur = head;
        while(cur.next != null) {
            cur = cur.next;
            length++;
        }
        k = k%length;
        if(k == 0) return head;
        k = length - k;
        cur.next = head;
        for(int i = 0;i < k;i++) {
            cur = cur.next;
        }
        head = cur.next;
        cur.next = null;
        return head;
    }
}
