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
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(root);
        LinkedList<Integer> result = new LinkedList<>();
        TreeNode nodeX;
        nodeX = list.peek();
        
        while(nodeX.left != null || nodeX.right != null) {
            while(nodeX.left != null) {
                result.offer(nodeX.val);
                list.offer(nodeX.left);
                nodeX = nodeX.left;
            }
            
            if(nodeX.right != null) {
                nodeX = nodeX.right;
            } else {
                list.poll();
                nodeX = list.peek();
            }
        }
    }
}
