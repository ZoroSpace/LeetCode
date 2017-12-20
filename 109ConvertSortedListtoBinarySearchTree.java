/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ArrayList<ListNode> list = new ArrayList<>();
        list.add(head);
        while(head.next != null) {
            head = head.next;
            list.add(head);
        }
        return helper(0,list.size()-1,list);
    }
    
    TreeNode helper(int lo,int hi,ArrayList<ListNode> nodes) {
        if(hi < lo) return null;
        TreeNode nodeX = new TreeNode(nodes.get((lo+hi)/2).val);
        nodeX.left = helper(lo,(lo+hi)/2-1,nodes);
        nodeX.right = helper((lo+hi)/2+1,hi,nodes);
        return nodeX;
    }
}
