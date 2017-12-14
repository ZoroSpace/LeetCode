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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if(root == null) return result;
        Deque<TreeNode> dq = new LinkedList<>();
        dq.offerFirst(root);
        int size = dq.size();
        boolean flag = true;
        TreeNode cur;
        while(size != 0) {
            LinkedList<Integer> l = new LinkedList<>();
            
            if(flag) {
                for(int i = 0;i < size;i++) {
                    cur = dq.pollFirst();
                    if(cur.left != null) dq.offerLast(cur.left);
                    if(cur.right != null) dq.offerLast(cur.right);
                    l.add(cur.val);
                }
            } else {
                for(int i = 0;i < size;i++) {
                    cur = dq.pollLast();
                    if(cur.right != null) dq.offerFirst(cur.right);
                    if(cur.left != null) dq.offerFirst(cur.left);
                    l.add(cur.val);
                }
            }
            result.add(l);
            flag = flag ^ true;
            size = dq.size();
        }
        return result;
    }
}
