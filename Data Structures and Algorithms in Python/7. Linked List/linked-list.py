
        
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
        