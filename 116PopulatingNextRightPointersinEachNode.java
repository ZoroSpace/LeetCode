/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode head = root;
        TreeLinkNode currentNode;
        while(head.left != null) {
            currentNode = head;
            while(currentNode != null) {
                helper(currentNode);
                currentNode = currentNode.next;
            }
            head = head.left;
        }
    }
    
    void helper(TreeLinkNode nodeX) {
        if(nodeX.next == null) {
            nodeX.left.next = nodeX.right;            
        } else {
            nodeX.left.next = nodeX.right;
            nodeX.right.next = nodeX.next.left;
        }
    }
}
