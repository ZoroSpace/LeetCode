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
        if(root == null || (root.left == null && root.right == null)) return;
        TreeLinkNode validNode = root.next;
        
        while(validNode != null && validNode.left == null && validNode.right == null) validNode = validNode.next;
        
        if(validNode != null) {
            if(validNode.left != null) validNode = validNode.left;
            else validNode = validNode.right;
        }
        
        if(root.right == null) {
            root.left.next = validNode;
        } else {
            if(root.left != null && root.right != null) {
                root.left.next = root.right;
            }
            root.right.next = validNode;
        }
        connect(root.right);
        connect(root.left);
    }
}
