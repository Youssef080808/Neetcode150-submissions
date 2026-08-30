# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        diameter = 0
        def rec(root):
            if root is None:
                return
            diam = self.maxDepth(root.right) + self.maxDepth(root.left)
            nonlocal diameter
            diameter = max(diam, diameter)
            rec(root.right)
            rec(root.left)
        rec(root)
        return diameter

            

    def maxDepth(self, root: Optional[TreeNode]) -> int:
        def rec(root):
            if root is None:
                return 0
            return 1 + max(rec(root.left), rec(root.right))
        return rec(root)