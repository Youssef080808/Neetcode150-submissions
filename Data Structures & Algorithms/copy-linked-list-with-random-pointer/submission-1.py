"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if head is None:
            return None
        copy_head = Node(head.val)
        rethead = copy_head
        hashmap = {}
        current = head
        hashmap[current] = copy_head
        while current is not None:
            if current.next is None:
                if current.random in hashmap:
                    copy_head.random = hashmap[current.random]
                else:
                    if current.random is None:
                        copy_head.random = None
                    else:
                        copy_head.random = Node(current.random.val)
                        hashmap[current.random] = copy_head.random
                    copy_head.next = None
                break
            if current.next in hashmap:
                copy_head.next = hashmap[current.next]
            else:
                copy_head.next = Node(current.next.val)
                hashmap[current.next] = copy_head.next
            if current.random in hashmap:
                copy_head.random = hashmap[current.random]
            else:
                if current.random is None:
                    copy_head.random = None
                else:
                    copy_head.random = Node(current.random.val)
                    hashmap[current.random] = copy_head.random
            current = current.next
            copy_head = copy_head.next
        
        return rethead
        