/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode small,big,cur = head.next;
        if(head.val >= x) {
            big = head;
            small = new ListNode(-1);
        } else {
            small = head;
            big = new ListNode(-1);
        }
        while(cur != null) {
            if(cur.val >= x) {
                
            }
            cur = cur.next;
        }
        
    }
}
