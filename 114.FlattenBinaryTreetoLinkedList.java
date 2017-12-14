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
        LinkedList<TreeNode> list = new LinkedList<>();
        list = helper(list,root);
        int size = list.size();
        for (int i=0; i<size - 1; i++) {
            list.get(i).right = list.get(i+1);
        }
    }
    
    LinkedList<TreeNode> helper(LinkedList<TreeNode> list,TreeNode nodeX) {
        if(nodeX == null) return list;
        list.add(nodeX);
        if(nodeX.left != null) list = helper(list,nodeX.left);
        if(nodeX.right != null) list = helper(list,nodeX.right);
        return list;
    }
}
