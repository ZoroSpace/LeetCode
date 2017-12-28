/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
//         ListNode cur = head;
//         int size = 0;
//         while(cur != null) {
//             size++;
//             cur = cur.next;
//         }
        ListNode start1 = new ListNode(0);
        start1.next = null;
        ListNode start2 = new ListNode(0);
        start2.next = head;
        while(start2.next != null) {
            head = start2.next;
            start2.next = head.next;
            head.next = null;
            while()
            
        }
        
        
        
        
        return start.next;
        
    }
    
    
}
