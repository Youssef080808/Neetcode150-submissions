# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        count = 0
        min_val = float('-inf')
        def rec(root, highest):
            if root is None:
                return
            nonlocal count
            if root.val >= highest:
                highest = root.val
                count+=1
            rec(root.right, highest)
            rec(root.left, highest)
        rec(root, min_val)
        return count
