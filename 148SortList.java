/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null) return head;
        return mergeSort(head);
    }
    
    ListNode mergeSort(ListNode nodeX) {
        if(nodeX.next == null) return nodeX;
        
        ListNode fast = nodeX,slow = nodeX;
        
        ListNode end = slow;
        while(fast != null && fast.next != null) {
            end = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        end.next = null;
        
        ListNode first = nodeX,second = slow;
        first = mergeSort(first);
        second = mergeSort(second);
        ListNode start = new ListNode(0);
        ListNode cur = start;
        while(first != null && second != null) {
            if(first.val < second.val) {
                cur.next = first;
                first = first.next;
            } else {
                cur.next = second;
                second = second.next;
            }
            cur = cur.next;
            cur.next = null;
        }
        
        if(first != null) {
            cur.next = first;
        }
        if(second != null) {
            cur.next = second;
        }
        return start.next;
    }
}
