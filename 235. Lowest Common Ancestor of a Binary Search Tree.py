# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if p.val < root.val < q.val or p.val > root.val > q.val:
            return root
        elif p.val == root.val:
            return p
        elif q.val == root.val:
            return q
        elif p.val < root.val:
            return self.lowestCommonAncestor(root.left, p, q)
        else :
            return self.lowestCommonAncestor(root.right, p, q)
