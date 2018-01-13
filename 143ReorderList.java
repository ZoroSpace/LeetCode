/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null) return;
        List<ListNode> list = new ArrayList<>();
        while(head != null) {
            list.add(head);
            head = head.next;
        }
        int lo = 0,hi = list.size()-1;
        while(true) {
            if(lo < hi) {
                list.get(lo).next = list.get(hi);
                lo++;
            } else {
                list.get(lo).next = null;
                return ;
            }
            if(lo < hi) {
                list.get(hi).next = list.get(lo);
                hi--;
            } else {
                list.get(lo).next = null;
                return ;
            }
        }
    }
}
