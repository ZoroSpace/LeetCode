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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null) return result;
        LinkedList<Integer> level;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int size;
        TreeNode nodeX;
        while(q.size() != 0) {
            size = q.size();
            level = new LinkedList<>();
            for(int i = 0;i < size;i++) {
                nodeX = q.poll();
                level.add(nodeX.val);
                if(nodeX.left != null) q.offer(nodeX.left);
                if(nodeX.right != null) q.offer(nodeX.right);
            }
            result.add(level);
        }
        return result;
            
    }
}
