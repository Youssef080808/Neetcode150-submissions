# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        result = None
        def rec(root):
            nonlocal result
            if root is None:
                return False
            right_found = rec(root.right)
            left_found = rec(root.left)
            current_found = True if root is p or root is q else False

            count = sum([left_found, right_found, current_found])
            if count >= 2:
                result = root

            return left_found or right_found or current_found 

            
        rec(root)
        return result



        