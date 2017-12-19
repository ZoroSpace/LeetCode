/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//可能为负数
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        return helper(root,sum);
    }
    
    List<List<Integer>> helper(TreeNode nodeX,int sum) {
        List<List<Integer>> result;
        if(nodeX.left == null && nodeX.right == null && (sum - nodeX.val == 0)) {
            List<Integer> vals = new LinkedList<>();
            vals.add(nodeX.val);
            result = new LinkedList<>();
            result.add(vals);
        } else if(nodeX.left == null && nodeX.right == null && (sum - nodeX.val != 0)) {
            return null;
        } else if(nodeX.left != null && nodeX.right == null) {
            result = helper(nodeX.left,sum - nodeX.val);
            if(result != null) {
                for(List<Integer> l : result) {
                    ((LinkedList<Integer>)l).add(nodeX.val);
                }
            }
        } else if(nodeX.left == null && nodeX.right != null) {
            result = helper(nodeX.right,sum - nodeX.val);
            if(result != null) {
                for(List<Integer> l : result) {
                    ((LinkedList<Integer>)l).add(nodeX.val);
                }
            }
        } else {
            List<List<Integer>> lresult = helper(nodeX.left,sum - nodeX.val);
            List<List<Integer>> Rresult = helper(nodeX.right,sum - nodeX.val);
            result = null;
            if(lresult != null) {
                result = new LinkedList<>();
                for(List<Integer> l : lresult) {
                    ((LinkedList<Integer>)l).add(nodeX.val);
                    result.add(l);
                }
                
            }
            if(Rresult != null) {
                result = new LinkedList<>();
                for(List<Integer> l : Rresult) {
                    ((LinkedList<Integer>)l).add(nodeX.val);
                    result.add(l);
                }
            }
        }
        return result;
    }
}
