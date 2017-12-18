/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//可能为负数
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        return helper(root,sum);
    }
    
    List<List<Integer>> helper(TreeNode nodeX,int sum) {
        if(nodeX.left == null && nodeX.right == null && (sum - nodeX.val == 0) {
            List<Integer> vals = new LinkedList<>();
            vals.add(nodeX.val);
            List<List<Integer>> result = new LinkedList<>();
            result.add(vals);
        } else if(nodeX.left != null && nodeX.right == null)
    }
}
