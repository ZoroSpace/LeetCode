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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return helper(root,sum);
    }
    
    boolean helper(TreeNode root, int sum) {
        if(root.left == null && root.right == null) {
            if(root.val == sum) return true;
            else return false;
        } else if(root.left == null && root.right != null) {
            return helper(root.right,sum - root.val);
        } else if(root.left != null && root.right == null) {
            return helper(root.left,sum - root.val);
        } else {
            return helper(root.left,sum - root.val) || helper(root.right,sum - root.val);
        }
    }
}
