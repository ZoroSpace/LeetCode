/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode result = new ListNode(0);
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        for(int i = 0;i < lists.length;i++) {
            helper(result,lists[i]);
        }
        return result.next;
    }
    
    void helper(ListNode re,ListNode s2) {
        ListNode s1 = re.next,end = re;
        re.next = null;
        while(s1 != null && s2 != null) {
            if(s1.val < s2.val) {
                end.next = s1;
                s1 = s1.next;
            } else {
                end.next = s2;
                s2 = s2.next;
            }
            end = end.next;
            end.next = null;
        }
        if(s1 != null) end.next = s1;
        if(s2 != null) end.next = s2;
    }
    
}
