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
    public boolean isValidBST(TreeNode root) {
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    
    boolean helper(TreeNode nodeX,long lo,long hi) {
        if(nodeX == null) return true;
        if(lo < nodeX.val && nodeX.val < hi) {
            return helper(nodeX.left,lo,(long)nodeX.val) && helper(nodeX.right,(long)nodeX.val,hi);
        } else return false;
    }
}
