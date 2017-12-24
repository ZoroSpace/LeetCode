/**  * Definition for singly-linked list.  * public class ListNode {  *     int val;  *     ListNode next;  *     ListNode(int x) { val = x; }  * }  */
class Solution { 	public ListNode partition(ListNode head,int x) {  	ListNode sSource = new ListNode(-2);  	ListNode s = sSource;  	ListNode lSource = new ListNode(-1);  	ListNode l = lSource;  	while(head != null) {   	if(head.val < x) {    	s.next = head;    	l.next = null;    	s = head;   	} else {    	l.next = head;    	s.next = null;    	l = head;   	}   	head = head.next;  	}  	s.next = lSource.next;  	return sSource.next; 	}
}
