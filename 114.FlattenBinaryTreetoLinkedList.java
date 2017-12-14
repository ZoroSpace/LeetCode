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
    public void flatten(TreeNode root) {
        LinkedList<TreeeNode> list = helper(root);
    }
    
    void helper(TreeNode nodeX) {
        TreeNode l;
        if(nodeX.left != null && nodeX.right != null) {
            l = helper(nodeX.left);
            
        } else if(nodeX.left != null && nodeX.right == null) {
            
        } else if(nodeX.left == null && nodeX.right != null) {
            
        } else {
            
        }
    }
}
