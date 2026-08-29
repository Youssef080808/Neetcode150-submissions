# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        current = head
        length = 0
        while current is not None:# length is 6
            length+=1
            current = current.next

        first_head = None#3
        head_list = head#4
        current = head#4
        prev = None
        for i in range(1,length+1):#i=3,k=3//
            if i%k == 0:
                if i == k:
                    first_head = current
                next_node = current.next#4
                current.next = None
                first = self.reverse(head_list, 0)#1
                if prev is not None:
                    prev.next = current
                prev = head_list
                first.next = next_node
                head_list = next_node
                current = next_node
            else:
                current = current.next
        return first_head


    def reverse(self, head, num):
        rettail = head
        rethead = None
        current = head
        prev = None
        while current is not None:
            next_node = current.next
            if next_node is None:
                rethead = current
            current.next = prev
            prev = current
            current = next_node
        return rettail if num == 0 else rethead
                

        