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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return buildTree(0,nums.length-1,nums);
    }
    
    TreeNode buildTree(int lo,int hi,int[] array) {
        if(lo > hi) return null;
        if(lo == hi) return new TreeNode(array[hi]);
        
        TreeNode root = new TreeNode(array[(lo+hi)/2]);
        root.left = buildTree(lo,(lo+hi)/2-1,array);
        root.right = buildTree((lo+hi)/2+1,hi,array);
        return root;
    }
}
