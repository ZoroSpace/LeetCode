/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head =new ListNode(1);
        ListNode end = head;
        while(l1 != null || l2 !=null) {
            if(l1 != null && l2 != null) {
                if(l1.val < l2.val) {
                    end.next = l1;
                    l1 = l1.next;
                } else {
                    end.next = l2;
                    l2 = l2.next;
                        
                }
            } else if(l1 != null && l2 == null) {
                end.next = l1;
                l1 = l1.next;
                    
            } else {
                end.next = l2;
                l2 = l2.next;
            }
            end = end.next;
        }
        return head.next;
    }
}
