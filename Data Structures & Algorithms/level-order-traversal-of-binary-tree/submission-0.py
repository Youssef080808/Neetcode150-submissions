# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        my_list = [] # 3
        def rec(root, index):
            nonlocal my_list

            if root is None:
                return

            if len(my_list) <= index: # no already present list 
                m_list = [root.val]
                my_list.append(m_list)
            else:
                m_list = my_list[index]
                m_list.append(root.val)
            # Call children but with higher level index    
            rec(root.left, index+1)
            rec(root.right, index+1)
        rec(root, 0)
        return my_list



            
            
            
            