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
        //若k很大
        ListNode s1 = new ListNode(0);
        ListNode s2 = new ListNode(0);
        s1.next = head;
        for(int i = 0;i < k-1;i++) {
            head = head.next;
        }
        if(head.next == null) return s1.next;
        s2.next = head.next;
        head.next = null;
        head = s2.next;
        while(head.next != null) head = head.next;
        head.next = s1.next;
        return s2.next;
        
    }
}
