class LRUCache:
    class ListNode:
      def __init__(self, val=0, next=None, prev=None):
          self.val = val
          self.next = next
          self.prev = prev

    def __init__(self, capacity: int):
        self.cap = capacity
        self.hmap = {}
        self.head = self.ListNode()
        self.head.next = self.head
        self.head.prev = self.head

    def get(self, key: int) -> int:
        if key in self.hmap:
            node = self.hmap[key]
            nnext = node.next 
            prev = node.prev
            nnext.prev = prev
            prev.next = nnext
            tail = self.head.prev
            tail.next = node
            node.next = self.head
            self.head.prev = node
            node.prev = tail
            return self.hmap[key].val
        return -1
    def put(self, key: int, value: int) -> None:
        if key in self.hmap:
            node = self.hmap[key]
            node.val = value
            node.prev.next = node.next
            node.next.prev = node.prev
        else:
            if len(self.hmap) == self.cap:
                lru = self.head.next
                lru.prev.next = lru.next
                lru.next.prev = lru.prev
                del self.hmap[lru.key]

            node = self.ListNode(value)
            node.key = key
            self.hmap[key] = node

        tail = self.head.prev
        tail.next = node
        node.prev = tail
        node.next = self.head
        self.head.prev = node   
        

        

        
