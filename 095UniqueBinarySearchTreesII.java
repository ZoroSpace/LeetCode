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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new LinkedList<>();
        TreeNode root;
        if(n == 0) {
        } else if(n == 1) {
            root = new TreeNode(n);
            result.add(root);
        } else {
            for(int i = 0;i < n;i++) {
                List<TreeNode> l1 = generateTrees(i);
                List<TreeNode> l2 = generateTrees(n-1-i);
                if(i != 0 && (n-1-i) != 0) {
                    for(TreeNode nodeX1 : l1) {
                        for(TreeNode nodeX2 : l2) {
                            root = new TreeNode(n);
                            root.left = nodeX1;
                            root.right = nodeX2;
                            result.add(root);
                        }
                    }
                } else if(i == 0) {
                    for(TreeNode nodeX2 : l2) {
                        root = new TreeNode(n);
                        root.right = nodeX2;
                        result.add(root);
                    }
                } else if((n-1-i) == 0) {
                    for(TreeNode nodeX1 : l1) {
                        root = new TreeNode(n);
                        root.left = nodeX1;
                        result.add(root);
                    }
                }
                    
            }
        }
        return result;
    }
}
