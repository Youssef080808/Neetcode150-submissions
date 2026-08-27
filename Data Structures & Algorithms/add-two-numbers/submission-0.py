# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# 956 966 -> 1
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        cur1 = l1
        cur2 = l2
        head = ListNode()
        rethead = head
        carryover = False
        while cur1 is not None or cur2 is not None:
            if cur1 is None:
                sum = cur2.val
                if carryover:
                    sum+=1
                if sum>=10:
                    carryover = True
                    head.val = sum-10
                else:
                    carryover = False
                    head.val = sum
            elif cur2 is None:
                sum = cur1.val
                if carryover:
                    sum+=1
                if sum>=10:
                    carryover = True
                    head.val = sum-10
                else:
                    carryover = False
                    head.val = sum
            else:
                sum = cur1.val + cur2.val
                if carryover:
                    sum += 1
                if sum >= 10:
                    carryover = True
                    head.val = sum-10
                else:
                    carryover = False
                    head.val = sum
            cur1 = cur1.next if cur1 is not None else None
            cur2 = cur2.next if cur2 is not None else None
            if cur1 is None and cur2 is None:
                break
            else:
                head.next = ListNode()
                head = head.next
            
        if carryover:
            head.next = ListNode(1)
        return rethead
        