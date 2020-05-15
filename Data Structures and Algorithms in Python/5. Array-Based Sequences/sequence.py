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

