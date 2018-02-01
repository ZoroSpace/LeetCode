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
    TreeNode first,second;
    public void recoverTree(TreeNode root) {
        TreeNode cur = root,pre = null,temp;
        while(cur != null) {
            if(cur.left == null) {
                if(pre != null && pre.val > cur.val) {
                    if(first == null) first = pre;
                    second = cur;
                }
                pre = cur;
                cur = cur.right;
            } else {
                temp = cur.left;
                while(temp.right != null && temp.right != cur) {
                    temp = temp.right;
                }
                if(temp.right == null) {
                    temp.right = cur;
                    cur = cur.left;
                } else {
                    temp.right = null;
                    if(pre != null && pre.val > cur.val) {
                        if(first == null) first = pre;
                        second = cur;
                    }
                    pre = cur;
                    cur = cur.right;
                }
            }
        }
        int t = first.val;
        first.val = second.val;
        second.val = t;
    }
}
