# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        current = head
        prev = None
        after = None
        new_head = None # 1>2>3>4
        while current is not None:
            after = current.next # 3
            current.next = prev # 1
            prev = current # 2
            current = after # 3
            if current is None:
                return prev 
            