
        
class LinkedStack:
    # LIFO Stack implementation using a singly lined list for storage
    
    class _Node:
        # Lightweight, non public class for storing a singly linked node
        __slots__ = "_element", '_next'  # streamline memory usage
        
        def __init__(self, element, next):
            self._element = element
            self._next = next 
    
    def __init__(self):
        self._head = None
        self._size = 0
        
    def __len__(self):
        return self._size
    
    def is_empty(self):
        return self._size == 0
    
    def push(self, e):
        # add element to the top of the stack
        self._head = self._Node(e, self._head)
        self._size +=1
        
    def top(self):
        if self.is_empty():
            raise Empty('Stack is empty')
        return self._head._element
    
    def pop(self):
        if self.is_empty():
            raise Empty('Stack is empty')
        answer = self._head._element
        self._head = self._head._next
        self._size -= 1
        return answer
    
class LinkedQueue:
    # FIFO queue implementation using a singly linked list for storage
    
    class _Node:
        # Lightweight, non public class for storing a singly linked node (same as linked stack)
        __slots__ = "_element", '_next'  # streamline memory usage
        
        def __init__(self, element, next):
            self._element = element
            self._next = next 
            
    def __init__(self):
        # create an empty queue
        self._head = None
        self._tail = None
        self._size = 0
        
    def __len__(self):
        return self._size
    
    def is_empty(self):
        return self._size == 0
    
    def first(self):
        # return (but do not remove) the element at the front of the queue
        if self.is_empty():
            raise Empty('Queue is empty')
        return self._head._element
    
    def dequeue(self):
        # remove and return the first element of the queue (FIFO)
        if self.is_empty():
            raise Empty('Queue is empty')
        answer = self._head._element
        self._head = self._head._next
        self._size -= 1
        if self.is_empty():
            self._tail = None
        return answer
    
    def enqueue(self, e):
        # add an element to the back of a queuej
        newest = self._Node(e, None)
        if self.is_empty():
            self._head = newest
        else:
            self._tail._next = newest
        self._tail = newest
        self._size += 1        
        
# 7.2.2 Circular queue

class CircularQueue:
    # queue implementation using circularly linked list for storage
    
    class _Node:
        # same as previous one
        # Lightweight, non public class for storing a singly linked node (same as linked stack)
        __slots__ = "_element", '_next'  # streamline memory usage
        
        def __init__(self, element, next):
            self._element = element
            self._next = next 
    
    def __init__(self):
        self._tail = None
        self._size = 0
        
    def __len__(self):
        return self._size
    
    def is_empty(self):
        return self._size == 0
    
    def first(self):
        # return (but do not remove) the element at the front of the queue
        # Raise empty exceptions if the queue is empty
        if self.is_empty():
            raise Empty('Queue is empty')
        head = self._tail._next
        return head._element
        
    def dequeue(self):
        # remove and return the first element of the queue
        if self.is_empty():
            raise Empty('Queue is empty')
        oldhead = self._tail._next
        if self._size == 1:
            self._tail = None
        else:
            self._tail._next = oldhead._next
        self._size -=1
        return oldhead._element
    
    def enqueue(self, e):
        # add an element to the back of a queue
        newest = self._Node(e, None) # Node will be new tail node
        if self.is_empty():
            newest._next = newest
        else:
            newest._next = self._tail._next
            self._tail._next = newest
        self._tail = newest
        self._size += 1
        
    def rotate(self):
        # rotate front element to the back of the queue
        if self._size > 0:
            self._tail = self._tail._next
        
        
        
                                                                                                                         