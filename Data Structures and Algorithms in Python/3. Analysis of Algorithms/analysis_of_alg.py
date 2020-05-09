# find_max example of algorithm >O(n)

# complexity = O(n*log n)
def find_max(data):
    # return the maximun element of a nonempty python list
    biggest = data[0]
    for val in data:
        if val > biggest:
            biggest = val
    return biggest

#print(find_max([1,2,3,2,4,5,1]))

# prefix_average1

def prefix_average1(S):
    #return list such that for all j, A[j] equals average of S[0], .... S[j]
    n = len(S)
    A = [0] * n
    for j in range(n):
        total = 0
        for i in range(j+1):
            total += S[i]
        A[j] = total / (j+1)
    return(A)
# O(n^2)

def prefix_average2(S):
    n = len(S)
    A = [0] * n
    for j in range(n):
        A[j] = sum(S[0, j + 1])/(j+1)
    return A

# still O(n^2)

#linear time algorithm
def prefix_average3(S):
    n = len(S) #O(1)
    A = [0] * n #O(n)
    total = 0
    for j in range(n): #O(n)
        total += S[j]
        A[j] = total/(j+1)
    return A


# disjoint sets
def disjoint1(A, B, C):
    for a in A:
        for b in B:
            for c in C:
                if a == b == c:
                    return False
    return True
# the worst case is O(n^3)

def disjoint2(A, B, C):
    for a in A:
        for b in B:
            if a == b:
                for c in C:
                    if a == c:
                        return False
    return True
# O(n^2)

# unique elements
def unique1(S):
    # return true if there are no duplicate elementsin sequence S
    for i in range(len(S)):
        for k in range(j + 1, len(S)):
            if S[i] == S[j]:
                return False
    return True
#O(n^2)

# try ordering first
def unique2(S):
    temp = sorted(S) #O(nlog n)
    for j in range(1, len(temp)):
        if temp[j-1] == temp[j]:
            return False
    return True
#total time O(n log n)

def find(S, val):
    # return index j such that S[j] == val or -1 if no such element
    n = len(S)
    j = 0
    while j < n:
        if S[j] == val:
            return j
        j+=1
    return -1

    


