# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:    
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists:
            return None
        mergedLists = []
        while len(lists) > 1:
            mergedLists = []
            for i in range(0, len(lists), 2):
                l1 = lists[i]
                l2 = lists[i+1] if i + 1 < len(lists) else None
                mergedLists.append(self.mergeTwo(l1, l2))
            lists = mergedLists
        return lists[0]
                
    def mergeTwo(self, l1, l2) -> Optional[ListNode]:
        if l1 is None:
            return l2
        if l2 is None:
            return l1
        cur1 = l1
        cur2 = l2
        dummy = ListNode()
        prev = dummy
        while cur1 is not None or cur2 is not None:
            if cur1 is None:
                prev.next = cur2
                prev = cur2
                cur2 = cur2.next
            elif cur2 is None:
                prev.next = cur1
                prev = cur1
                cur1 = cur1.next
            else:
                if cur1.val <= cur2.val:
                    prev.next = cur1
                    prev = cur1
                    cur1 = cur1.next
                else:
                    prev.next = cur2
                    prev = cur2
                    cur2 = cur2.next
        return dummy.next

