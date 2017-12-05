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
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return helper(root,0);
    }
    
    int helper(TreeNode nodeX,int sofar) {
        int result;
        if(nodeX.left == null && nodeX.right == null) {
            result = 10*sofar + nodeX.val;
        } else if(nodeX.left != null && nodeX.right == null) {
            result = helper(nodeX.left,10*sofar+nodeX.val);
        } else if(nodeX.left == null && nodeX.right != null) {
            result = helper(nodeX.right,10*sofar+nodeX.val);
        } else {
            result = helper(nodeX.left,10*sofar+nodeX.val) + helper(nodeX.right,10*sofar+nodeX.val);
        }
        return result;
    }
    
    
}
