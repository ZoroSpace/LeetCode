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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();//offerFirst
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        result.offerFirst(root.val);
        TreeNode nodeX = root;
        while(nodeX.right != null) {
            nodeX = nodeX.right;
            stack.push(nodeX);
            result.offerFirst(nodeX.val);
        }
        while(!stack.empty()) {
            nodeX = stack.peek();
            if(nodeX.left != null) {
                stack.pop();
                nodeX = nodeX.left;
                stack.push(nodeX);
                result.offerFirst(nodeX.val);
                
                while(nodeX.right != null) {
                    nodeX = nodeX.right;
                    stack.push(nodeX);
                    result.offerFirst(nodeX.val);
                }
                
            } else stack.pop();
        }
        return result;
    }
}
