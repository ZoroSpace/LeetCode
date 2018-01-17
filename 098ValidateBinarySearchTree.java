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
    public boolean isValidBST(TreeNode root) {
        LinkedList<Integer> all = new LinkedList<>();
        all = helper(root,all);
        int size = all.size();
        for(int i = 0;i < size - 1;i++) {
            if(all.poll() >= all.peek()) return false;
        }
        return true;
    }
    
    LinkedList<Integer> helper(TreeNode nodeX,LinkedList<Integer> list) {
        if(nodeX == null) return list;
        list = helper(nodeX.left,list);
        list.offer(nodeX.val);
        list = helper(nodeX.right,list);
        return list;
    }
}
