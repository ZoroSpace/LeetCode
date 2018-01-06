/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head,fast = head;
        if(fast != null) fast = fast.next;
        int counter = 0;
        ListNode first = head,second;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                fast = fast.next;
                counter++;
                while(fast != slow) {
                    slow = slow.next;
                    fast = fast.next.next;
                    counter++;
                }
                for(int i = 0;i < counter;i++) {
                    second = first;
                    second = second.next;
                    if(second != first) first = first.next;
                    else return first;
                }
            }
        }
        return null;
    }
}
