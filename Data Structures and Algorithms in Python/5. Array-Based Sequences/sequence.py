# 5-1 length of list
import sys 
n = 100
data = []
for k in range(n):
    a = len(data)
    b = sys.getsizeof(data)
    print('Length: {0: 3d}; Size in bytes: {1: 4d}'.format(a, b))
    data.append(None)
