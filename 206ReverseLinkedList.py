# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        first=ListNode(0)
        second=ListNode(0)
        first.next=head
        while head!=None:
            first.next=head.next
            head.next=second.next
            second.next=head
            head=first.next
        return second.next
