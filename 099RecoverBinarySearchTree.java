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
    private LinkedList<TreeNode> list;
    public void recoverTree(TreeNode root) {
        list = new LinkedList<>();
        TreeNode left,right;
        int[] nums;
        list.add(root);
        while(list.size() != 0) {
            list.clear();
            left = new TreeNode(Integer.MIN_VALUE);
            right = new TreeNode(Integer.MAX_VALUE);
            helper(root,left,right);
            nums = new int[list.size()];
            for(int i = 0;i < nums.length;i++) nums[i] = list.get(i).val;
            Arrays.sort(nums);
            for(int i = 0;i < nums.length;i++) list.get(i).val = nums[i];
        }
            
        return;
    }
    
    void helper(TreeNode cur,TreeNode left,TreeNode right) {
        if(cur == null) return;
        int t;
        if(left.val <= cur.val && cur.val <= right.val) {
            helper(cur.left,left,cur);
            helper(cur.right,cur,right);
        } else {
            if(cur.val < left.val) {
                list.add(left);
                list.add(cur);
            } else {
                list.add(cur);
                list.add(right);
            }
        }
        return;
    }
}
