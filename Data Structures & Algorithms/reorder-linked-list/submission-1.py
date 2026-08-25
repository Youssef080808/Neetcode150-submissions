# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        # reverse second half of list  then traverse 
        # two heads 1->5->2->4->3
        length = 0
        current = head
        while current is not None:
            length+=1
            current = current.next
        if length == 1: 
            return 

        i = 0
        current = head
        prev = None
        tail = None
        while current is not None:
            if i == length//2 - 1:
                x = current
                current = current.next
                x.next = None
                i+=1
                continue 
            if i >= length//2:
                next_node = current.next
                current.next = prev
                prev = current
                current = next_node
                i+=1
                continue
            current = current.next
            i+=1

        tail = prev
        current = head
        while current is not None: # 1->2, 5->4->3
            stail = tail.next
            scurrent = current.next
            if current.next is not None:
                tail.next = current.next
            current.next = tail
            tail = stail
            current = scurrent
            


            