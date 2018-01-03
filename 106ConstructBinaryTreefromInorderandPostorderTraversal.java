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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder,postorder,inorder.length-1,0,inorder.length-1);
    }
    
    TreeNode helper(int[] inorder,int[] postorder,int ith,int lo,int hi) {
        //inorder  :lo,hi,i
        //postorder:ith
        if(lo > hi) return null;
        TreeNode root = new TreeNode(postorder[ith]);
        int i;
        for(i = lo;i <= hi;i++) {
            if(inorder[i] == postorder[ith]) break;
        }
        root.left = helper(inorder,postorder,ith-1-(hi-i),lo,i-1);
        if(i==hi) {
            root.right = null;
        } else {
            root.right = helper(inorder,postorder,ith-1,i+1,hi);
        }
            
        return root;
    }
}
