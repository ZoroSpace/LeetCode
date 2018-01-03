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
        return helper(preorder,index,inorder,0,preorder.length-1);
    }
    TreeNode helper(int[] preorder,int ith,int[] inorder,int lo,int hi) {
        if(lo > hi || lo < 0 || hi > preorder.length-1 || ith < 0 || ith > preorder.length-1) return null;
        
        TreeNode root = new TreeNode(preorder[ith]);
        int i;
        for(i = 0;i < preorder.length;i++) {
            if(inorder[i] == preorder[ith]) break;
        }
        ith++;
        TreeNode leftChild = helper(preorder,ith,inorder,lo,i-1);
        TreeNode rightChild;
        if(leftChild != null) ith++;
        rightChild = helper(preorder,ith,inorder,i+1,hi);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }
}
