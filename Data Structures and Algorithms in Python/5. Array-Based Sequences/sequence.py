# 5-1 length of list
import sys 

data = []
def list_length(n):
    for k in range(n):
        a = len(data)
        b = sys.getsizeof(data)
        print('Length: {0: 3d}; Size in bytes: {1: 4d}'.format(a, b))
        data.append(None)
#list_length(100)

# 5-3 Dynamic array class
import ctypes

class DynamicArray:
    # A dynamic array class to a simplified Python list
    
    def __init__(self):
        self._n = 0 # count actual elements
        self._capacity = 1 # default array capacity
        self._A = self._make_array(self._capacity)
        
    def __len__(self):
        return self._n
    
    def __getitem__(self, k):
        if not 0 <= k < self._n:
            raise IndexError('invalid index')
        return self._A[k]
    
    def append(self, obj):
        # add object to the end of the array
        if self._n == self._capacity:
            self._resize(2 * self._capacity)
        self._A[self._n] = obj
        self._n += 1
        
    def _resize(self, c):
        # Resize internal array to capacity c
        B = self._make_array(c)
        for k in range(self._n):
            B[k] = self._A[k]
        self._A = B
        self._capacity = c
        
    def _make_array(self, c):
        return (c * ctypes.py_object)()
    
    def insert(self, k, value):
        # insert value at index k, shifting subsequent values rightward
        if self._n == self._capacity:
            self._resize(2 * self._capacity)
        for j in range(self._n, k, -1):
            self._A[j] = self._A[j-1]
        self._A[k] = value
        self._n += 1
        
    def remove(self, value):
        # Remove first occurrence of value (or raise ValueError)
        # we do not consider shrinking the dynamic array in this version
        for k in range(self._n):
            if self._A[k] == value:
                for j in range(k, self._n - 1):
                    self._A[j] = self._A[j + 1]
                self._A[self._n - 1] = None
                self._n -= 1
                return
        raise ValueError('value not found')
    
    
# Amortization analysis
from time import time
def compute_average(n):
    data = []
    start = time()
    for k in range(n):
        data.append(None)
    end = time()
    return (end - start) / n

#print(compute_average(100))

# Construct new list
n = 10
squares = []
for k in range(1, n + 1):
    squares.append(k*k)

# list comprehension
squares = [k*k for k in range(1, n + 1)]

# 5.4.2 Strings

# letters = ''.join([c for c in document if c.isalpha()])
# or letters = ''.join(c for c in document if c.isalpha())

# 5.5.1 Game score

class GameEntry:
    # Represents one entry of a list of high scores
    
    def __init__(self, name, score):
        self._name = name
        self._score = score
        
    def get_name(self):
        return self._name
    
    def get_score(self):
        return self._score
    
    def __str__(self):
        return '({0}, {1})'.format(self._name, self._score) # e.g. '(Bob, 98)
    
class Scoreboard:
    # Fixed length sequence of high scores in nondecreasing order
    
    def __init__(self, capacity = 10):
        # Initialize scoreboard with given maximum capacity
        # All entries are initially None
        
        self._board = [None] * capacity
        self._n = 0
        
    def __getitem__(self, k):
        return self._board[k]
    
    def __str__(self, k):
        # Return string representation of the high score list
        return '\n'.join(str(self._board[j]) for j in range(self._n))
    
    def add(self, entry):
        score = entry.get_score()
        # Does this entry qualified as a high score : either board is not full or the score is higher than last entry
        good = self._n < len(self._board) or score > self._board[-1].get_score()
        
        if good:
            if self._n < len(self._board):
                self._n +=1
        j = self._n - 1
        while j > 0 and self._board[j-1].get_score() < score:
            self._board[j] = self._board[j - 1]
            j -= 1
        self._board[j] = entry

