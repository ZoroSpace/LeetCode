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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
		int index = 0;
        return helper(preorder,inorder,index,0,preorder.length-1);
    }
    TreeNode helper(int[] preorder,int[] inorder,int ith,int lo,int hi) {
        if(lo > hi) return null;
        TreeNode root = new TreeNode(preorder[ith]);
        int i;
        for(i = lo;i <= hi;i++) if(inorder[i] == preorder[ith]) break;        
        if(i != lo) root.left = helper(preorder,inorder,ith+1,lo,i-1);
        else root.left = null;
        root.right = helper(preorder,inorder,i-lo+ith+1,i+1,hi);
        return root;
    }
}
