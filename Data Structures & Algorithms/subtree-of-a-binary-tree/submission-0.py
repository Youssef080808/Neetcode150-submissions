# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:   
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        def same(root, subRoot):
            if not root and subRoot:
                return False
            if not subRoot and root:
                return False
            if not subRoot and not root:
                return True
            if root.val == subRoot.val:
                return same(root.left, subRoot.left) and same(root.right, subRoot.right)
            else:
                return False

        def rec(root):
            if root is None:
                return False
            if same(root, subRoot):
                return True
            return rec(root.left) or rec(root.right)

        return rec(root)
        