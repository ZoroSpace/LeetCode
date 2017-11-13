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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        LinkedList<Integer> result = new LinkedList<>();//试试ArrayList
        if(root == null) return result;
        Stack<TreeNode> lsk = new Stack<>();//left stack
        Stack<TreeNode> rsk = new Stack<>();// right stack
        lsk.push(root);
        TreeNode nodeX = root;
        while(lsk.size() != 0 || rsk.size() != 0) {
            while(nodeX.left != null) {
                lsk.push(nodeX.left);
                if(nodeX.right != null) rsk.push(nodeX.right);
                nodeX = nodeX.left;
            }
            while(lsk.size() >= rsk.size() && (!lsk.empty())) {
                nodeX = lsk.pop();
                result.add(nodeX.val);
            }
            if(nodeX.right != null) rsk.push(nodeX);
            // if(!lsk.empty()) result.add(lsk.pop().val);
            // if(!rsk.empty()) {
            //     nodeX = rsk.pop();
            //     lsk.push(nodeX);
            // }
        }
        return result;
        
    }
}
