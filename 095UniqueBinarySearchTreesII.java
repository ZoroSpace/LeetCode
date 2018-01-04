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
        return helper(n,1,n);
    }
    
    List<TreeNode> helper(int n,int lo,int hi) {
        List<TreeNode> result = new LinkedList<>();
        TreeNode root;
        if(n == 0) {
        } else if(n == 1) {
            root = new TreeNode(hi);
            result.add(root);
        } else {
            for(int i = 0;i < n;i++) {
                List<TreeNode> l1 = helper(i,lo,lo + i -1);
                List<TreeNode> l2 = helper(n-1-i,lo+i+1,hi);
                if(i != 0 && (n-1-i) != 0) {
                    for(TreeNode nodeX1 : l1) {
                        for(TreeNode nodeX2 : l2) {
                            root = new TreeNode(lo+i);
                            root.left = nodeX1;
                            root.right = nodeX2;
                            result.add(root);
                        }
                    }
                } else if(i == 0) {
                    for(TreeNode nodeX2 : l2) {
                        root = new TreeNode(lo+i);
                        root.right = nodeX2;
                        result.add(root);
                    }
                } else if((n-1-i) == 0) {
                    for(TreeNode nodeX1 : l1) {
                        root = new TreeNode(lo+i);
                        root.left = nodeX1;
                        result.add(root);
                    }
                }
                    
            }
        }
        return result;
    }
}
