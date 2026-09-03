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
        def rec(root, height:int):
            nonlocal my_list
            if root is None:
                return
            if len(my_list) <= height:
                new_list = [root.val]
                my_list.append(new_list)
            else:
                cur_list = my_list[height]
                cur_list.append(root.val)
             
            rec(root.left, height+1)
            rec(root.right, height+1)
            
        rec(root, 0)
        return my_list 