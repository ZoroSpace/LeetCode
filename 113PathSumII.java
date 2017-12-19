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
        if(root == null) return new LinkedList<List<Integer>>();
        List<List<Integer>> result = helper(root,sum);
        if(result == null ) return new LinkedList<List<Integer>>();
        return result;
    }
    
    List<List<Integer>> helper(TreeNode nodeX,int sum) {
        List<List<Integer>> result;
        if(nodeX.left == null && nodeX.right == null && (sum - nodeX.val == 0)) {
            List<Integer> vals = new LinkedList<>();
            vals.add(0,nodeX.val);
            result = new LinkedList<>();
            result.add(vals);
        } else if(nodeX.left == null && nodeX.right == null && (sum - nodeX.val != 0)) {
            return null;
        } else if(nodeX.left != null && nodeX.right == null) {
            result = helper(nodeX.left,sum - nodeX.val);
            if(result != null) {
                for(List<Integer> l : result) {
                    ((LinkedList<Integer>)l).add(0,nodeX.val);
                }
            }
        } else if(nodeX.left == null && nodeX.right != null) {
            result = helper(nodeX.right,sum - nodeX.val);
            if(result != null) {
                for(List<Integer> l : result) {
                    ((LinkedList<Integer>)l).add(0,nodeX.val);
                }
            }
        } else {
            List<List<Integer>> lresult = helper(nodeX.left,sum - nodeX.val);
            List<List<Integer>> Rresult = helper(nodeX.right,sum - nodeX.val);
            if(lresult != null) {
                result = new LinkedList<>();
                for(List<Integer> l : lresult) {
                    ((LinkedList<Integer>)l).add(0,nodeX.val);
                }
            }
            result = lresult;
            if(Rresult != null) {
                if(result == null) {
                    result = new LinkedList<>();//被clear掉
                }
                for(List<Integer> l : Rresult) {
                    ((LinkedList<Integer>)l).add(0,nodeX.val);
                    result.add(l);
                }
            }
        }
        return result;
    }
}
