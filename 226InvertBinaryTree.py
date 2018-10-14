# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def invertTree(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        if root == None or (root.left == None and root.right == None):
            return root
        else:
            if root.left == None:
                root.left = root.right
                root.right = None
            elif root.right == None:
                root.right = root.left
                root.left = None
            else:
                t = root.left
                root.left = root.right
                root.right = t
        
        self.invertTree(root.left)
        self.invertTree(root.right)
        return root


# class Solution:
#     def invertTree(self, root):
#         """
#         :type root: TreeNode
#         :rtype: TreeNode
#         """
#         if root:
#             root.left,root.right = self.invertTree(root.right),self.invertTree(root.left)
#         return root
