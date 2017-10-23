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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int upperCounter = 0;//当前层计数
        int upperLimit = 1;
        int lowerCounter = 0;//下层计数
        
        double upperSum = 0;
        
        List<Double> result = new LinkedList<Double>();
        TreeNode currentNode;
        queue.offer(root);
        while(queue.peek() != null) {
            currentNode = queue.poll();
            upperSum += currentNode.val;
            upperCounter++;
            if(currentNode.left != null) {
                queue.offer(currentNode.left);
                lowerCounter++;
            }
            if(currentNode.right != null) {
                queue.offer(currentNode.right);
                lowerCounter++;
            }
            if(upperCounter == upperLimit) {
                upperSum = upperSum/upperLimit;
                result.add(upperSum);
                
                upperSum = 0;
                upperCounter = 0;
                upperLimit = lowerCounter;
                lowerCounter = 0;
            }
        }
        return result;
    }
}
