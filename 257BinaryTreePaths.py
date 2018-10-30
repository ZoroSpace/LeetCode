# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    ans = []
    def binaryTreePaths(self, root):
        """
        :type root: TreeNode
        :rtype: List[str]
        """
        if root == None:
            return self.ans
        path = []
        path.append(root)
        self.helper(root, path)
        return self.ans
    
    
    def helper(self,node,path):
        if node.left == None and node.right == None:
            s = "->"
            vals = []
            for i in path:
                vals.append(str(i.val))
            self.ans.append(s.join(vals))
            return
        if node.left != None:
            path.append(node.left)
            self.helper(node.left,path)
            path.remove(node.left)
        if node.right != None:
            path.append(node.right)
            self.helper(node.right,path)
            path.remove(node.right)
        return
            
        
        
class Solution:
    def binaryTreePaths(self, root):
        """
        :type root: TreeNode
        :rtype: List[str]
        """
        if root == None:
            return []
        path = []
        ans = []
        path.append(root)
        self.helper(root, path,ans)
        return ans
    
    
    def helper(self,node,path,ans):
        if node.left == None and node.right == None:
            s = "->"
            vals = []
            for i in path:
                vals.append(str(i.val))
            ans.append(s.join(vals))
            return
        for nodex in (node.left, node.right):
            if nodex != None:
                path.append(nodex)
                self.helper(nodex,path,ans)
                path.remove(nodex)
        return  
        
        
        
