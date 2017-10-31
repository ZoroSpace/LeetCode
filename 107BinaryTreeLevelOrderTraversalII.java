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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) {
            return new LinkedList<List<Integer>>();
        }
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        TreeNode currentNode;
        List<Integer> currentLevel;
        int levelNum;
        while(q.peek() != null) {
            currentLevel = new LinkedList<Integer>();
            levelNum = q.size();
            for(int i = 0;i < levelNum;i++) {
                currentNode = q.poll();
                if(currentNode.left != null) q.offer(currentNode.left);
                if(currentNode.right != null) q.offer(currentNode.right);
                currentLevel.add(currentNode.val);
            }
            result.addFirst(currentLevel);
        }
        return result;
    }
}
