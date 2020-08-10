# python3、
# hints
# 1. Implement a queue using two stacks
# 2. Preprocess block suffixes and prefixes
# 3. Store relevant items in a dequeue


def max_sliding_window_naive(sequence, m):
    queue = Queue()
    maximums = []
    for i in range(m):
        queue.Enqueue(sequence[i])
    maximums.append(queue.Max())
    
    for i in range(m, len(sequence)):
        queue.Dequeue()
        queue.Enqueue(sequence[i])
        maximums.append(queue.Max())

    return maximums
    
class Stack():
    def __init__(self):
        self.__stack = []
        self.max_stack = []
    
    def Push(self, item): 
        if (len(self.max_stack) > 0):
            if (item >= self.max_stack[-1]):
                self.max_stack.append(item)
        else:
            self.max_stack.append(item)
        self.__stack.append(item)
    
    def Pop(self):
        if (self.max_stack[-1] == self.__stack[-1]):
            self.max_stack.pop()
        return self.__stack.pop()
    
    def Max(self):
        return None if self.is_empty() else self.max_stack[-1]
    
    def is_empty(self):
        return True if len(self.__stack) == 0 else False
    

class Queue():
    def __init__(self):
        self.inbox = Stack()
        self.outbox = Stack()
    
    def Enqueue(self, item):
        self.inbox.Push(item)
        
    def Dequeue(self):
        if self.outbox.is_empty():
            while self.inbox.is_empty() is False:
                item = self.inbox.Pop()
                self.outbox.Push(item)
        self.outbox.Pop()
    
    def Max(self):
        in_max = self.inbox.Max(); out_max = self.outbox.Max()
        if in_max is not None and out_max is not None:
            return max(in_max, out_max)
        elif in_max is not None:
            return in_max
        elif out_max is not None:
            return out_max
       
    
if __name__ == '__main__':
    n = int(input())
    input_sequence = [int(i) for i in input().split()]
    assert len(input_sequence) == n
    window_size = int(input())

    print(*max_sliding_window_naive(input_sequence, window_size))

