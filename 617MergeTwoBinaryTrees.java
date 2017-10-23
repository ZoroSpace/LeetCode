/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode newTree;
        if(t1 != null && t2 == null) {
            newTree = new TreeNode(t1.val);
            newTree.left = mergeTrees(t1.left,null);
            newTree.right = mergeTrees(t1.right,null);
            return newTree;
        } else if(t2 != null && t1 == null) {
            newTree = new TreeNode(t2.val);
            newTree.left = mergeTrees(null,t2.left);
            newTree.right = mergeTrees(null,t2.right);
            return newTree;
        } else if(t1 != null && t2 != null){
            newTree = new TreeNode(t1.val + t2.val);
            newTree.left = mergeTrees(t1.left,t2.left);
            newTree.right = mergeTrees(t1.right,t2.right);
            return newTree;
        } else {
            return null;
        }
    }
}
