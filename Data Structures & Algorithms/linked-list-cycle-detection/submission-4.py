# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        ptr1 = head
        ptr2 = head
        while True:
            if ptr1 is None or ptr2 is None or ptr2.next is None:
                return False
            ptr1 = ptr1.next
            ptr2 = ptr2.next.next
            if ptr1 is ptr2:
                return True
        return False