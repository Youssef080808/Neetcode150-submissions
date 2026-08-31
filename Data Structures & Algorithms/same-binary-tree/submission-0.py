# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        result = True
        def rec(p,q):
            nonlocal result
            if not p and q:
                result = False
                return
            if not q and p:
                result = False
                return
            if not p and not q:
                return
            if p.val == q.val:
                rec(p.right, q.right)
                rec(p.left, q.left)
            else:
                result = False
        rec(p,q)
        return result

        