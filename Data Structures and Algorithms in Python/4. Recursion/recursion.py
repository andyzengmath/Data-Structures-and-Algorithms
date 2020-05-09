# 4.1.1 factorial function
def factorial(n):
    if n == 0:
        return 1
    else:
        return n * factorial(n-1)
#print(factorial(10))
# Time complexity: O(n)

#4.1.2 English ruler

def draw_line(tick_length, tick_label = ''):
    #draw one line with given tick length ( folowed by optional label)
    
    line = '-' * tick_length
    if tick_label:
        line += ' ' + tick_label
    print(line)
    
def draw_interval(center_length):
    #draw tick interval based upon a central tick length
    if center_length > 0:                 #stops when lengths drops to 0
        draw_interval(center_length - 1)  #recursively draw top ticks
        draw_line(center_length)          #draw the center tick
        draw_interval(center_length - 1)  #recursively draw bottom ticks
            
def draw_ruler(num_inches, major_length):
    # draw English ruler with given number of inches, major tick length
    draw_line(major_length, '0')          # draw inch 0 line
    for j in range(1, 1 + num_inches):
        draw_interval(major_length - 1)   #draw interior ticks for inch
        draw_line(major_length, str(j))   # draw inch j line and label
            
#draw_ruler(1, 3)
# draw_interval(c) yields (2^c -1) lines of output

# binary search

def binary_search(data, target, low, high):
    #return true if target is found in indicated python list
    # the search only considers the portion from data[low] to data[high] inclusive
    
    if low > high:
        return False
    else:
        mid = (low + high)//2
        if target == data[mid]:
            return True
        elif target < data[mid]:
            return binary_search(data, target, low, mid - 1)
        else:
            return binary_search(data, target, mid + 1, high)
# Time complexity = O(log n) f fvcccdd444444dd4cdxxxxxxde33
        
# 4.1.4 File systems
import os

def disk_usage(path):
    # Return the number of bytes used by a file/folder and any descendents
    total = os.path.getsize(path)
    if os.path.isdir(path):
        for filename in os.listdir(path):
            childpath = os.path.join(path.filename)
            total += disk_usage(childpath)
    print('{0:<7}'.format(total), path)
    return total
# O(n)

# 4.3 drawback of recursion algorithm

# 4-6 
def unique3(S, start, stop):
    # Return true if there are no duplicate elements in slice S[start: stop]
    if stop - start < 1: return True
    elif unique3(S, start, stop - 1): return False
    elif unique3(S, start + 1, stop): return False
    else: return S[start] != S[stop - 1]
    
# bad recursion, O(2^n)

# 4-7 bad Fibonacci
def bad_fibonacci(n):
    if n <=1:
        return n
    else:
        return bad_fibonacci(n-2) + bad_fibonacci(n-1)
    
# 4-8 linear recursion improvement
def good_fibonacci(n):
    if n <=1:
        return (n,0)
    else:
        (a, b) = good_fibonacci(n-1)
        return (a+b, a)
# O(n)

# 4.4.1 Linear recursion
#4-7
def linear_sum(S, n):
    # return the first n numbers of sequence S
    if n == 0:
        return 0
    else:
        return linear_sum(S, n-1) + S[n-1]
    
# 4-8
def reverse(S, start, stop):
    # Reverse the element in implicit slice S[start:stop]
    if start < stop -  1:
        S[start], S[stop - 1] = S[stop - 1], S[start]
        reverse(S, start + 1, stop - 1)
    # O(m)
    
# 4-9 power function
def power(x,n):
    if n==0:
        return 1
    else:
        return x* power(x, n-1) 
# O(n)

# 4-10 improvement
def power2(x, n):
    if n == 0:
        return 1
    else:
        partial = power(x, n//2)
        result = partial * partial
        if n % 2 ==1:
            result *= x
        return result
    
# 4.4.2 Binary recursion
def binary_sum(S, start, stop):
    # return the sum of the numbers in implicit slice S[start: stop]
    if start >= stop:
        return 0
    elif start == stop - 1:
        return S[start]
    else:
        mid = (start + stop)//2
        return binary_sum(S, start, mid) + binary_sum(S, mid, stop)
# O(n) 

# 4.6 eliminate tail recursion
def binary_search_iterative(data, target):
    low = 0
    high = len(data) -1
    while low <= high:
        mid = (low + high)//2
        if target == data[mid]:
            return True
        elif target < data[mid]:
            high = mid - 1
        else:
            low = mid + 1
    return False

def reverse_iterative(S):
    start, stop = 0, len(S)
    while start < stop - 1:
        S[start], S[stop -1] = S[stop - 1], S[start]
        start, stop = start + 1, stop - 1
