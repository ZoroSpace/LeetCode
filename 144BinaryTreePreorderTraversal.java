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
		Stack<TreeNode> stack = new Stack<>();
		LinkedList<Integer> result = new LinkedList<>();
        if(root == null) return result;
		TreeNode node = root;
		stack.push(node);
		result.offer(node.val);
		while(!stack.empty()) {
			while(node.left != null) {
				node = node.left;
				stack.push(node);
				result.offer(node.val);
			}
			
			while(!stack.empty() && stack.peek().right == null) {
				stack.pop();
			}
			if(!stack.empty() && stack.peek().right != null) {
				node = stack.pop().right;
				stack.push(node);
				result.offer(node.val);
			}
		}
		return result;
	}
}
