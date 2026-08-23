# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if list1 is None: return list2
        if list2 is None: return list1
        prev = None
        new_head = list1 if list1.val <= list2.val else list2

        while list1 or list2:
            current = None
            if list1 is None:
                current = list2
                list2 = list2.next
            elif list2 is None:
                current = list1
                list1 = list1.next
            else:
                if list1.val <= list2.val:
                    current = list1
                    list1 = list1.next
                else:
                    current = list2
                    list2 = list2.next

            if prev is not None: prev.next = current
            prev = current
            
        return new_head



