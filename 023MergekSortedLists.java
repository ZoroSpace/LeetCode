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


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return helper(lists,0,lists.length - 1);
    }
    
    ListNode helper(ListNode[] lists,int lo,int hi) {
        if(lo == hi) return lists[lo];
        ListNode s1 = helper(lists,lo,(lo+hi)/2);
        ListNode s2 = helper(lists,(lo+hi)/2+1,hi);
        ListNode start = new ListNode(0),end = start;
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
        return start.next;
    }
    
}
