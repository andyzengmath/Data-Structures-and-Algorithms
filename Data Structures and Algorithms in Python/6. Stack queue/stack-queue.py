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