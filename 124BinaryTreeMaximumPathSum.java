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
    int result = -2147483648;
    public int maxPathSum(TreeNode root) {
        single(root);
        return result;
    }
    
    int single(TreeNode nodeX) {
        if(nodeX == null) return -2147483648;
        int lm = single(nodeX.left),rm = single(nodeX.right);
        result = Math.max(result,lm);
        result = Math.max(result,rm);
        result = Math.max(result,Math.max(lm,0)+Math.max(rm,0)+nodeX.val);
        return Math.max(Math.max(lm,rm),0)+nodeX.val;
    }
}
