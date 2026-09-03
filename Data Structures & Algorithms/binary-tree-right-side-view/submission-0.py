# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        my_list = self.levelOrder(root)
        res = []
        for i in range(len(my_list)):
            cur = my_list[i]
            res.append(cur[len(cur)-1])
        return res

    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        my_list = [] 
        def rec(root, index):
            nonlocal my_list
            if root is None:
                return
            if len(my_list) <= index: 
                m_list = [root.val]
                my_list.append(m_list)
            else:
                m_list = my_list[index]
                m_list.append(root.val)   
            rec(root.left, index+1)
            rec(root.right, index+1)
        rec(root, 0)
        return my_list