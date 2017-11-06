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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        setDepth(root);
        if(root.left == null && root.right == null) {
            return true;
        } else if(root.left == null && root.right != null) {
            return root.right.val <=1;
        } else if(root.right == null && root.left != null) {
            return root.left.val <=1;
        } else {
            if(root.left.val - root.right.val <=1 && root.left.val - root.right.val >= -1) {
                return isBalanced(root.left) && isBalanced(root.right);
            } else return false;
        }
        
    }
    
    int setDepth(TreeNode nodeX) {
        if(nodeX.left == null && nodeX.right == null) {
            nodeX.val = 1;
        } else if(nodeX.left == null && nodeX.right != null) {
            nodeX.val = setDepth(nodeX.right) + 1;
        } else if(nodeX.left != null && nodeX.right == null) {
            nodeX.val = setDepth(nodeX.left) + 1;
        } else {
            nodeX.val = Math.max(setDepth(nodeX.left) + 1,setDepth(nodeX.right) + 1);
        }
        return nodeX.val;
    }
    
}
