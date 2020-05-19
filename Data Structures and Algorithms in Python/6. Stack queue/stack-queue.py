# Stack

class Empty(Exception):
    # Error attempting to access an element from an empty container
    pass

class ArrayStack:
    # LIFO stack implementation using a Python list as underlying storage
    
    def __init__(self):
        self._data = []
        
    def __len__(self):
        return len(self._data)
    
    def is_empty(self):
        return len(self._data) == 0
    
    def push(self, e):
        self._data.append(e)
        
    def top(self):
        # Return (but do not remove) the element at the top of the stack
        if self.is_empty():
            raise Empty('Stack is empty')
        return self._data[-1]
    
    def pop(self):
        # Remove and return the element from the top of the stack (LIFO)
        if self.is_empty():
            raise Empty('Stack is empty')
        return self._data.pop()
    
# 6.1.3 application

def reverse_file(filename):
    # Overwrite given file with its contents line-by-line reversed
    S = ArrayStack()
    original = open(filename)
    for line in original:
        S.push(line.rstrip('\n'))
    original.close()
    
    output = open(filename, 'w')
    while not S.is_empty():
        output.write(S.pop() + '\n')
    output.close()
    
# 6.1.4 match

def is_matched(expr):
    # Return true if all delimiters are properly match; False otherwise
    lefty = '({['
    righty = ')}]'
    S = ArrayStack()
    for c in expr:
        if c in lefty:
            S.push(c)
        elif c in righty:
            if S.is_empty():
                return False
            if righty.index(c) != lefty.index(S.pop()):
                return False
    return S.is_empty()

def if_matched_html(raw):
    # Return True id all HTML tag are properly match; False otherwise
    S = ArrayStack()
    j = raw.find('<')
    while j != -1:
        k = raw.find('>', j+1)
        if k == -1:
            return False
        tag = raw[j+1: k]
        if not tag.startswith('/'):
            S.push(tag)
        else:
            if S.is_empty():
                return False
            if tag[1:] != S.pop():
                return False
        j = raw.find('<', k+1)
    return S.is_empty()

# 6-6 Queue based on array

class ArrayQueue:
    # FIFO queue implementation using a Python list as underlying storage
    DEFAULT_CAPACITY = 10 # moderate capacity for new queues
    
    def __init__(self):
        self._data = [None]*ArrayQueue.DEFAULT_CAPACITY
        self._size = 0
        self._front = 0
        
    def __len__(self):
        return self._size
    
    def is_empty(self):
        return self._size == 0
    
    def first(self):
        
        if self.is_empty:
            raise Empty('Queue is empty')
        return self._data[self._front]
    
    def dequeue(self):
        
        if self.is_empty:
            raise Empty('Queue is empty')
        answer = self._data[self._front]
        self._data[self._front] = None
        self._front = (self._front + 1) % len(self._data)
        self._size -= 1
        return answer
    
    def enqueue(self, e):
        if self._size == len(self._data):
            self._resize(2* len(self._data))
        avail = (self._front + self._size) % len(self._data)
        self._data[avail] = e
        self._size += 1
        
    def _resize(self, cap):
        
        old = self._data
        self._data = [None] * cap
        walk = self._front
        for k in range(self._size):
            self._data[k] = old[walk]
            walk = (1 + walk) % len(old)
        self._front = 0


