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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int maxLevelNumber = 1;
        Queue<TreeNode> q = new LinkedList<TreeNode> ();
        q.offer(root);
        int n;
        TreeNode currentNode;
        while(q.peek() != null) {
            n = q.size();
            for(int i = 0;i<n;i++) {
                currentNode = q.poll();
                if(currentNode.left!= null) {
                    q.offer(currentNode.left);
                }
                if(currentNode.right!= null) {
                    q.offer(currentNode.right);
                }
                
            }
            if(q.size() > 0) {
                maxLevelNumber++;
            }
        }
        return maxLevelNumber;
    }
}
